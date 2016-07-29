package com.crm.logicq.service.alert.impl.sms;

import java.util.List;

import com.crm.logicq.model.alert.SMSDetails;
import com.crm.logicq.service.alert.IAlertImplService;

public interface ISMSService extends IAlertImplService{

	public void logsmsdetails(List<SMSDetails> smsdetails);
	
}
