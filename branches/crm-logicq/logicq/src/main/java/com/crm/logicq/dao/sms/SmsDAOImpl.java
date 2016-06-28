package com.crm.logicq.dao.sms;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.crm.logicq.common.AbstractDAO;
import com.crm.logicq.model.alert.SMSDetails;

@Repository
public class SmsDAOImpl extends AbstractDAO<SMSDetails> implements ISmsDAO {

	
	@Override
	public void insertSMSDetails(List<SMSDetails> smsdetails){
	  bulkSave(smsdetails);
	}
	
	
	

}
