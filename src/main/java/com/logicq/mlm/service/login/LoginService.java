package com.logicq.mlm.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.mlm.dao.login.ILoginDAO;

@Service
@Transactional
public class LoginService implements ILoginService{

	@Autowired
	ILoginDAO logindao;
	
	@Override
	public void loadusers() {
		logindao.loadUsers();
	}
	
	

}
