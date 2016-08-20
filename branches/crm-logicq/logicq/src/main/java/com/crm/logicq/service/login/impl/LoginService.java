package com.crm.logicq.service.login.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.logicq.dao.login.ILoginDAO;
import com.crm.logicq.model.login.Login;
import com.crm.logicq.security.helper.LoginFactory;
import com.crm.logicq.security.service.UserService;
import com.crm.logicq.service.login.IloginService;
import com.crm.logicq.ui.security.LoginVO;

@Service
@Transactional
public class LoginService implements IloginService {


	@Autowired
	ILoginDAO logindao;

	@Override
	public List<LoginVO> loadloginUser() {
		UserService userservice=new UserService();
		
		List<LoginVO> logindetails = new ArrayList<LoginVO>();
		List<Login> loginusers = logindao.loadloginUser();
		if (!loginusers.isEmpty()) {
			for (Login login : loginusers) {
				LoginVO loginvo = LoginFactory.create(login);
			  	logindetails.add(loginvo);
			  	userservice.addUser(loginvo);
			}
		}
		return logindetails;
	}
	
	

}
