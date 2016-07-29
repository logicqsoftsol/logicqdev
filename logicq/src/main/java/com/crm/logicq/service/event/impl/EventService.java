package com.crm.logicq.service.event.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.logicq.common.ICommonConstant;
import com.crm.logicq.common.LogicqContextProvider;
import com.crm.logicq.dao.readfile.IReadFileDAO;
import com.crm.logicq.helper.SMSHelper;
import com.crm.logicq.model.alert.SMSDetails;
import com.crm.logicq.model.attendance.AttendanceDetails;
import com.crm.logicq.model.user.CardReadDetails;
import com.crm.logicq.security.helper.StringFormatHelper;
import com.crm.logicq.service.alert.impl.sms.ISMSService;
import com.crm.logicq.service.attendance.IAttendanceService;
import com.crm.logicq.service.event.IEventService;
import com.crm.logicq.vo.event.EventDetailsVO;
import com.crm.logicq.vo.user.UserVO;

@Service("eventService")
@Transactional
public class EventService implements IEventService , ICommonConstant {
	
	
	private final static Logger logger = Logger.getLogger(EventService.class);
	
	@Autowired
	IReadFileDAO readFileDAO;
	
	@Autowired
	ISMSService smsservice;
	
	@Autowired
	IAttendanceService attendanceservice;
	
	@Override
	public void triggerEvent(EventDetailsVO eventDetailsVO) throws Exception{

		String eventType = eventDetailsVO.getEventtype();
		switch(eventType){
			case "ATTENDANCE" : 
				triggerEventAndSendSMS(eventDetailsVO);
				break;
			case "DurgaPuja" :
				System.out.println("Durga Puja Alert");
				break;
			default :
				System.out.println("Default Alert");
			
		} 
	}
	
	private void triggerEventAndSendSMS(EventDetailsVO eventDetailsVO) throws Exception {
		
		List<CardReadDetails> cardReadDetails= readFileDAO.readAccessFile();
		Map<String,UserVO> allusermapdetails = (Map<String, UserVO>) LogicqContextProvider.getElementFromApplicationMap(CACHEDUSER);
		List<SMSDetails> allSMSDetails = new ArrayList<SMSDetails>();
		List<String> templatekeys=StringFormatHelper.getSMSTemplateKey(eventDetailsVO.getTemplatetext());
        List<AttendanceDetails> attendancedetails=new ArrayList<AttendanceDetails>();
		for (CardReadDetails cardDetail : cardReadDetails) {
			// need to change after getting proper date
			cardDetail.setCardswappdate(new Date());
			Integer cardId = cardDetail.getCardid();
			UserVO user = allusermapdetails.get(String.valueOf(cardId));
			if(null!=user){
			AttendanceDetails attendance=new AttendanceDetails();
			attendance.setAttendancefor(user.getEntityType().toString());
			attendance.setDate(cardDetail.getCardswappdate());
			attendance.setFullName(user.getName());
			attendance.setIdetificationid(String.valueOf(cardId));
			attendance.setIntime(String.valueOf(cardDetail.getIntime()));
			attendance.setOuttime(String.valueOf(cardDetail.getOuttime()));
			attendance.setIsPresent(ISPRESENT_VALUE);
			attendance.setMobile(user.getMobilenumber());
			attendancedetails.add(attendance);
			try {
				SMSDetails smsdetails = SMSHelper.prepareSMSDetailsFromUser(user, cardDetail,
						eventDetailsVO.getTemplatetext(), templatekeys);
				allSMSDetails.add(smsdetails);
			} catch (Exception ex) {
				logger.error("unable to prepare SMS Details ", ex);
			}
			}
		}
		runSMSExecutor(allSMSDetails);
		
		if(!attendancedetails.isEmpty()){
			attendanceservice.saveAttendance(attendancedetails);
		}
		
	}

	private void runSMSExecutor(List<SMSDetails> allSMSDetails) {
		if (null != allSMSDetails && !allSMSDetails.isEmpty()) {
			ExecutorService executorService = Executors.newFixedThreadPool(2);
			try{
			executorService.execute(new Runnable() {
			    public void run() {
			    	List<SMSDetails> smsdetailslist=new ArrayList<SMSDetails>();
			    	allSMSDetails.forEach((smsinfo) -> {
			    		SMSDetails smslogdetails=null;
			    		try {
			    			//smslogdetails= SMSHelper.sendSMS(smsinfo);
						} catch (Exception ex) {
							smslogdetails.setStatus(ex.getMessage());
						}
			    		smsdetailslist.add(smslogdetails);
			    		
			    	});
			    	ISMSService smsservice=LogicqContextProvider.getApplicationContext().getBean(ISMSService.class);
		    		smsservice.logsmsdetails(smsdetailslist);
			    }
			});
			}finally{
			executorService.shutdown();
			}
		}
	}

}
