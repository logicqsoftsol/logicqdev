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
import com.crm.logicq.service.user.IUserService;
import com.crm.logicq.vo.attendance.AttendanceAbsentDetails;
import com.crm.logicq.vo.attendance.CardDetailsVO;
import com.crm.logicq.vo.attendance.EducationVO;
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
	
	@Autowired
	IUserService userservice;
	
	@Override
	public void triggerEvent(EventDetailsVO eventDetailsVO) throws Exception{

		String eventType = eventDetailsVO.getEventtype();
		switch(eventType){
			case "ATTENDANCE" : 
				triggerAttendanceEventAndSendSMS(eventDetailsVO);
				break;
			case "EXAM" : 
				triggerExamEventAndSendSMS(eventDetailsVO);
				break;
			case "DAILY" : 	
				triggerDailyEventAndSendSMS(eventDetailsVO);
				break;
			case "WEEK-DAYS-ONLY" : 
				triggerWeekdaysOnlyEventAndSendSMS(eventDetailsVO);
				break;
			case "WEEK-ENDS-ONLY" : 	
				triggerWeekEndsOnlyEventAndSendSMS(eventDetailsVO);
				break;
			case "FUNCTION" : 	
				triggerFunctionEventAndSendSMS(eventDetailsVO);
				break;
			case "VACATION" : 	
				triggerVacationEventAndSendSMS(eventDetailsVO);
				break;
			case "REGIONAL-FUNCTION" : 	
				triggerRegionalFunctionEventAndSendSMS(eventDetailsVO);
				break;	
			case "NATIONAL-HOLIDAY" : 	
				triggerNationalHolidayEventAndSendSMS(eventDetailsVO);
				break;	
			case "EMERGENCY" : 	
				triggerEmergencyEventAndSendSMS(eventDetailsVO);
				break;	
			case "OTHER" : 	
				triggerOtherEventAndSendSMS(eventDetailsVO);
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
			SMSDetails smsdetails = SMSHelper.prepareSMSDetailsFromUserForAttendance(absent.getUserdetails(), absent.getCardetails(),
					eventDetailsVO.getTemplatetext(), templatekeys);
			smsabsentlist.add(smsdetails);
		}
		}
		if (null != smsabsentlist && !smsabsentlist.isEmpty()) {
			SMSHelper.executeSMS(smsabsentlist);
		}
		
		LogicqContextProvider.removeElementFromApplicationMap(ABSETUSER);
	}
	
	private void attendancedetailsForPresentDetails(EventDetailsVO eventDetailsVO) throws Exception {
		List<CardReadDetails> cardReadDetails = readFileDAO.readAccessFile();
		logger.error(" Fetch data from msacess :"+ cardReadDetails);
		Map<String, CardDetailsVO> carddetailsvomap = CardDetailsConversionHelper.convertEntityToVO(cardReadDetails);

		@SuppressWarnings("unchecked")
		Map<String, UserVO> allusermapdetails = (Map<String, UserVO>) LogicqContextProvider
				.getElementFromApplicationMap(CACHEDUSER);
		Map<String,EducationVO>  studentedudetails = (Map<String, EducationVO>) LogicqContextProvider.getElementFromApplicationMap(STUDENT_EDU_CACHED);
		List<SMSDetails> smspresentlist = new ArrayList<SMSDetails>();
		List<String> templatekeys = StringFormatHelper.getSMSTemplateKey(eventDetailsVO.getTemplatetext());
		List<AttendanceDetails> attendancedetails = new ArrayList<AttendanceDetails>();
		List<AttendanceAbsentDetails> absetdetails = new ArrayList<AttendanceAbsentDetails>();
		
        //if user not login or not loaded .
		if(null==allusermapdetails || allusermapdetails.isEmpty()){
        	    userservice.loadEmployees();
				userservice.loadStudents();
				allusermapdetails = (Map<String, UserVO>) LogicqContextProvider
						.getElementFromApplicationMap(CACHEDUSER);
         }
		
		for (Map.Entry<String, UserVO> usermap : allusermapdetails.entrySet()) {
			UserVO user = usermap.getValue();
			CardDetailsVO cardvo = null;
			EducationVO eduvo=null;
			AttendanceDetails attendance = new AttendanceDetails();
			Attendancekey key=new Attendancekey();
			attendance.setKey(key);
			AttendanceAbsentDetails absentdetails=new AttendanceAbsentDetails();
			if("STUDENT".equals(eventDetailsVO.getApplicablefor())){
				if(studentedudetails.isEmpty()){
					eduvo=studentedudetails.get(usermap.getKey());
				}
			}
			
			if ((user.getEntityType().getValue().equals(eventDetailsVO.getApplicablefor()))
					|| ("ALL".equals(eventDetailsVO.getApplicablefor()))) {
				try {
					cardvo = carddetailsvomap.get(usermap.getKey());
					if (null == cardvo) {
						cardvo = new CardDetailsVO();
						cardvo.setCardid(usermap.getKey());
						attendance.setIsPresent(ISABSENT_VALUE);
						absentdetails.setCardetails(cardvo);
						absentdetails.setUserdetails(user);
						absentdetails.setEducationVO(eduvo);
						absetdetails.add(absentdetails);

					} else {
						attendance.setIsPresent(ISPRESENT_VALUE);
						SMSDetails smsdetails = SMSHelper.prepareSMSDetailsFromUserForAttendance(user, cardvo,
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
				if(null!=eduvo){
				attendance.setSectionname(eduvo.getSectionname());
				attendance.setClassname(eduvo.getClassname());
				}
				attendancedetails.add(attendance);
			}
		}
		//put map for abset user
		LogicqContextProvider.addElementToApplicationMap(ABSETUSER, absetdetails);
		logger.error("Befor Execute SMS Details "+smspresentlist);
		//Execute SMS
		SMSHelper.executeSMS(smspresentlist);
		logger.error("After Execute SMS Details "+smspresentlist);
	
		if(!attendancedetails.isEmpty()){
			attendanceservice.saveAttendance(attendancedetails);
		}
	}

	

	
	private void triggerOtherEventAndSendSMS(EventDetailsVO eventDetailsVO) {
		SMSHelper.prepareTemplateAndExecuteSMS(eventDetailsVO);
	}

	private void triggerEmergencyEventAndSendSMS(EventDetailsVO eventDetailsVO) {
		SMSHelper.prepareTemplateAndExecuteSMS(eventDetailsVO);
	}

	private void triggerNationalHolidayEventAndSendSMS(EventDetailsVO eventDetailsVO) {
		SMSHelper.prepareTemplateAndExecuteSMS(eventDetailsVO);
	}

	private void triggerRegionalFunctionEventAndSendSMS(EventDetailsVO eventDetailsVO) {
		SMSHelper.prepareTemplateAndExecuteSMS(eventDetailsVO);
	}

	private void triggerVacationEventAndSendSMS(EventDetailsVO eventDetailsVO) {
		SMSHelper.prepareTemplateAndExecuteSMS(eventDetailsVO);
	}

	private void triggerFunctionEventAndSendSMS(EventDetailsVO eventDetailsVO) {
		SMSHelper.prepareTemplateAndExecuteSMS(eventDetailsVO);
	}

	private void triggerWeekEndsOnlyEventAndSendSMS(EventDetailsVO eventDetailsVO) {
		SMSHelper.prepareTemplateAndExecuteSMS(eventDetailsVO);
	}

	private void triggerWeekdaysOnlyEventAndSendSMS(EventDetailsVO eventDetailsVO) {
		SMSHelper.prepareTemplateAndExecuteSMS(eventDetailsVO);
	}

	private void triggerDailyEventAndSendSMS(EventDetailsVO eventDetailsVO) {
		SMSHelper.prepareTemplateAndExecuteSMS(eventDetailsVO);
	}

	private void triggerExamEventAndSendSMS(EventDetailsVO eventDetailsVO) {
		SMSHelper.prepareTemplateAndExecuteSMS(eventDetailsVO);
	}
	
	
}
