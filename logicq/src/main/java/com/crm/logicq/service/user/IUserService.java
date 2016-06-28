package com.crm.logicq.service.user;

import java.util.List;

import com.crm.logicq.model.CardReadDetails;

public interface IUserService {
	
	public void loadUsers();

	public void getUserForSMS(List<CardReadDetails> cardreadDeatils);
	
}
