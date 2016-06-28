package com.crm.logicq.helper;

import com.crm.logicq.model.CardReadDetails;
import com.crm.logicq.model.alert.SMSDetails;
import com.crm.logicq.model.communication.PhoneCommunication;
import com.crm.logicq.model.user.User;

public class SMSHelper {
	
	
	public static SMSDetails prepareSMSDetailsFromUser(User user, PhoneCommunication communication,
			CardReadDetails cardetails) {
		SMSDetails smsdetails = new SMSDetails();
		smsdetails.setMobileNumber(communication.getMobilenumber());
		smsdetails.setFirstName(user.getFirstName());
		smsdetails.setLastName(user.getLastName());
		smsdetails.setSmsdate(cardetails.getCardswappdate());
		smsdetails.setIntime(cardetails.getIntime());
		smsdetails.setOuttime(cardetails.getOuttime());
		smsdetails.setContactType(communication.getContactType());
		return smsdetails;
	}

}
