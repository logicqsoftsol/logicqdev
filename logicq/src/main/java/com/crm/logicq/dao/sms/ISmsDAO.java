package com.crm.logicq.dao.sms;

import java.util.List;

import com.crm.logicq.model.alert.SMSDetails;

public interface ISmsDAO {
	
	public void insertSMSDetails(List<SMSDetails> smsdetails);

}
