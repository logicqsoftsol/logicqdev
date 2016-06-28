package com.crm.logicq.service.user.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.crm.logicq.common.LogicqContextProvider;
import com.crm.logicq.dao.user.IUserDAO;
import com.crm.logicq.helper.SMSHelper;
import com.crm.logicq.model.CardReadDetails;
import com.crm.logicq.model.alert.SMSDetails;
import com.crm.logicq.model.communication.PhoneCommunication;
import com.crm.logicq.model.user.User;
import com.crm.logicq.service.user.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService{

	@Autowired
	IUserDAO userdao;
	
	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public void loadUsers() {
		List<User> userdetails= userdao.loadUsers();
		userdetails.stream().forEach((user) -> {
			LogicqContextProvider.addElementToApplicationMap(user.getIdetificationid(), user);
		});
	}

	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void getUserForSMS(List<CardReadDetails> cardreadDeatils) {
		List<SMSDetails> allSMSDetails = new ArrayList<SMSDetails>();
		for (CardReadDetails carddetail : cardreadDeatils) {
			User user = (User) LogicqContextProvider.getElementFromApplicationMap(carddetail.getCardid());
			Set<PhoneCommunication> communications = user.getCommunication();
			for (PhoneCommunication communication : communications) {
				if (null != communication && communication.isActive()) {
					SMSDetails smsdetails = SMSHelper.prepareSMSDetailsFromUser(user, communication, carddetail);
					allSMSDetails.add(smsdetails);
				}
			}
		}
		if(null!=allSMSDetails && !allSMSDetails.isEmpty()){
			userdao.insertSMSDetails(allSMSDetails);
		}
		
	}


	
	
}
