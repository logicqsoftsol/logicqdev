package com.crm.logicq.service.event.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.crm.logicq.common.LogicqContextProvider;
import com.crm.logicq.constant.ContactType;
import com.crm.logicq.dao.readfile.IReadFileDAO;
import com.crm.logicq.helper.SMSHelper;
import com.crm.logicq.model.alert.SMSDetails;
import com.crm.logicq.model.communication.PhoneCommunication;
import com.crm.logicq.model.user.CardReadDetails;
import com.crm.logicq.model.user.Employee;
import com.crm.logicq.model.user.Student;
import com.crm.logicq.service.event.IEventService;
import com.crm.logicq.vo.event.EventDetailsVO;

@Service("eventService")
@Transactional
public class EventService implements IEventService {
	
	@Autowired
	IReadFileDAO readFileDAO;
	
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
		List<SMSDetails> allSMSDetails = new ArrayList<SMSDetails>();
		for (CardReadDetails cardDetail : cardReadDetails) {
			Integer cardId = cardDetail.getCardid();
			Object employee = LogicqContextProvider.getElementFromEmployeeMap(String.valueOf(cardId));
			String name = null;
			PhoneCommunication com=new PhoneCommunication();
			if(employee != null &&  employee instanceof Employee){
				Employee emp = (Employee) employee;
				name = emp.getBasicdetails().getFirstname();
				com.setActive(Boolean.TRUE);
				com.setMobilenumber(emp.getContactdetails().getCommunicationdetails().getMobilenumber());
				SMSDetails smsdetails = SMSHelper.prepareSMSDetailsFromUser(name, com, cardDetail, eventDetailsVO.getTemplatetext());
				allSMSDetails.add(smsdetails);
			} else {
				Object student = LogicqContextProvider.getElementFromStudentMap(String.valueOf(cardId));
				if(null!=student && student instanceof Student ){
				Student stu = (Student)student;
				name = stu.getBasicdetails().getFirstname();
				com.setActive(Boolean.TRUE);
				com.setMobilenumber(stu.getContactdetails().getCommunicationdetails().getMobilenumber());
				SMSDetails smsdetails = SMSHelper.prepareSMSDetailsFromUser(name, com, cardDetail, eventDetailsVO.getTemplatetext());
				allSMSDetails.add(smsdetails);
				}
				
			}
		
		}
		if (null != allSMSDetails && !allSMSDetails.isEmpty()) {
			for (SMSDetails smsinfo : allSMSDetails) {
				System.out.println("Call SMS");
				//SMSHelper.sendSMS(smsinfo);
			}
			// userdao.insertSMSDetails(allSMSDetails);
		}
		
	}

}
