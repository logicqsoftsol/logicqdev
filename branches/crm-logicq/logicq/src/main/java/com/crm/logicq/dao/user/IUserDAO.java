package com.crm.logicq.dao.user;

import java.util.List;

import com.crm.logicq.model.alert.SMSDetails;
import com.crm.logicq.model.user.User;

public interface IUserDAO {
	
	public List<User> loadUsers();
	public void insertSMSDetails(List<SMSDetails> smsdetails);
	public void getUser(String cardid) throws Exception;

}
