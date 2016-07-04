package com.crm.logicq.service.user;

import java.util.List;

import com.crm.logicq.model.user.CardReadDetails;

public interface IUserService {
	
	public void loadUsers();

	public void getUserForSMS(List<CardReadDetails> cardreadDeatils);
	public void triggerSMS(List<CardReadDetails> cardreadDeatils) throws Exception;
}
