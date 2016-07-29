package com.crm.logicq.service.alert.impl.sms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.crm.logicq.dao.sms.ISmsDAO;
import com.crm.logicq.model.alert.SMSDetails;

@Service
@Transactional
public class SMSService  implements ISMSService {

	@Autowired
	ISmsDAO smsdao;
	
	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void logsmsdetails(List<SMSDetails> smsdetails) {
		smsdao.insertSMSDetails(smsdetails);
	}

	
	
}
