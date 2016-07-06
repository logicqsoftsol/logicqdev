package com.crm.logicq.dao.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crm.logicq.common.AbstractDAO;
import com.crm.logicq.dao.sms.ISmsDAO;
import com.crm.logicq.dao.user.IUserDAO;
import com.crm.logicq.model.alert.SMSDetails;
import com.crm.logicq.model.user.User;


@Repository
public class UserDAOImpl extends AbstractDAO<User> implements IUserDAO{

	@Autowired
	ISmsDAO smsdao;
	
	@Override
	public List<User> loadUsers() {
		return (List<User>) loadClass(User.class);
	}

	
	@Override
	public void insertSMSDetails(List<SMSDetails> smsdetails) {
		smsdao.insertSMSDetails(smsdetails);
	}


	@Override
	public void getUser(String cardid) throws Exception {
		// TODO Auto-generated method stub
		
	}

	
}
