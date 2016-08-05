package com.crm.logicq.service.event.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.logicq.common.ICommonConstant;
import com.crm.logicq.common.LogicqContextProvider;
import com.crm.logicq.constant.EntityType;
import com.crm.logicq.dao.readfile.IReadFileDAO;
import com.crm.logicq.helper.CardDetailsConversionHelper;
import com.crm.logicq.helper.SMSHelper;
import com.crm.logicq.model.alert.SMSDetails;
import com.crm.logicq.model.attendance.AttendanceDetails;
import com.crm.logicq.model.attendance.Attendancekey;
import com.crm.logicq.model.user.CardReadDetails;
import com.crm.logicq.security.helper.StringFormatHelper;
import com.crm.logicq.service.alert.impl.sms.ISMSService;
import com.crm.logicq.service.attendance.IAttendanceService;
import com.crm.logicq.service.event.IEventService;
import com.crm.logicq.vo.attendance.AttendanceAbsentDetails;
import com.crm.logicq.vo.attendance.CardDetailsVO;
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
				triggerAttendanceEventAndSendSMS(eventDetailsVO);
				break;
		
			default :
				System.out.println("Default Alert");
			
		} 
	}
	
	private void triggerAttendanceEventAndSendSMS(EventDetailsVO eventDetailsVO) throws Exception {
		if ((eventDetailsVO.getEventID() == 11) || ("ATTENDANCE-ABSENT".equals(eventDetailsVO.getEventName()))) {
			attendancedetailsForAbsentDetails(eventDetailsVO);
		} else {
			attendancedetailsForPresentDetails(eventDetailsVO);
		}
		
	}

	private void attendancedetailsForAbsentDetails(EventDetailsVO eventDetailsVO) throws Exception {
		@SuppressWarnings("unchecked")
		List<AttendanceAbsentDetails> absentdetails = (List<AttendanceAbsentDetails>) LogicqContextProvider
				.getElementFromApplicationMap(ABSETUSER);
		List<SMSDetails> smsabsentlist = new ArrayList<SMSDetails>();
		List<String> templatekeys = StringFormatHelper.getSMSTemplateKey(eventDetailsVO.getTemplatetext());
		if(null!=absentdetails){
		for(AttendanceAbsentDetails absent:absentdetails){
			SMSDetails smsdetails = SMSHelper.prepareSMSDetailsFromUser(absent.getUserdetails(), absent.getCardetails(),
					eventDetailsVO.getTemplatetext(), templatekeys);
			smsabsentlist.add(smsdetails);
		}
		}
		if (null != smsabsentlist && !smsabsentlist.isEmpty()) {
			runSMSExecutor(smsabsentlist);
		}
		
		LogicqContextProvider.removeElementFromApplicationMap(ABSETUSER);
	}
	
	private void attendancedetailsForPresentDetails(EventDetailsVO eventDetailsVO) throws Exception {
		List<CardReadDetails> cardReadDetails = readFileDAO.readAccessFile();
		Map<String, CardDetailsVO> carddetailsvomap = CardDetailsConversionHelper.convertEntityToVO(cardReadDetails);

		@SuppressWarnings("unchecked")
		Map<String, UserVO> allusermapdetails = (Map<String, UserVO>) LogicqContextProvider
				.getElementFromApplicationMap(CACHEDUSER);
		List<SMSDetails> smspresentlist = new ArrayList<SMSDetails>();
		List<String> templatekeys = StringFormatHelper.getSMSTemplateKey(eventDetailsVO.getTemplatetext());
		List<AttendanceDetails> attendancedetails = new ArrayList<AttendanceDetails>();
		List<AttendanceAbsentDetails> absetdetails = new ArrayList<AttendanceAbsentDetails>();

		for (Map.Entry<String, UserVO> usermap : allusermapdetails.entrySet()) {
			UserVO user = usermap.getValue();
			CardDetailsVO cardvo = null;
			AttendanceDetails attendance = new AttendanceDetails();
			Attendancekey key=new Attendancekey();
			attendance.setKey(key);
			
			AttendanceAbsentDetails absentdetails=new AttendanceAbsentDetails();
			if (user.getEntityType().equals(EntityType.STUDENT)) {
				try {
				cardvo = carddetailsvomap.get(usermap.getKey());
				if (null == cardvo) {
					cardvo = new CardDetailsVO();
					cardvo.setCardid(usermap.getKey());
					attendance.setIsPresent(ISABSENT_VALUE);
					absentdetails.setCardetails(cardvo);
					absentdetails.setUserdetails(user);
					absetdetails.add(absentdetails);
					
				} else {
					   attendance.setIsPresent(ISPRESENT_VALUE);
						SMSDetails smsdetails = SMSHelper.prepareSMSDetailsFromUser(user, cardvo,
								eventDetailsVO.getTemplatetext(), templatekeys);
						smspresentlist.add(smsdetails);
				}
				} catch (Exception ex) {
					logger.error("unable to prepare SMS Details ", ex);
				}
			}
			if (null != cardvo) {
				attendance.setAttendancefor(user.getEntityType().toString());
				if (null != cardvo.getCardswapdate()) {
					attendance.getKey().setDate(cardvo.getCardswapdate());
				} else {
					attendance.getKey().setDate(new Date());
				}
				attendance.setFullName(user.getName());
				attendance.getKey().setIdetificationid(cardvo.getCardid());
				if (null != cardvo.getIntime()) {
					attendance.setIntime(String.valueOf(cardvo.getIntime()));
				} else {
					attendance.setIntime(null);
				}
				if (null != cardvo.getOuttime()) {
					attendance.setOuttime(String.valueOf(cardvo.getOuttime()));
				} else {
					attendance.setOuttime(null);
				}
				attendance.setMobile(user.getMobilenumber());
				attendancedetails.add(attendance);
			}
		}
		//put map for abset user
		LogicqContextProvider.addElementToApplicationMap(ABSETUSER, absetdetails);
		
		if (null != smspresentlist && !smspresentlist.isEmpty()) {
			runSMSExecutor(smspresentlist);
		}
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
			    	   SMSDetails	smslogdetails= SMSHelper.sendSMS(smsinfo);
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
