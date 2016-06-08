package com.logicq.logicq.service.login.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.logicq.conversion.login.LoginConversion;
import com.logicq.logicq.dao.login.ILoginDAO;
import com.logicq.logicq.model.login.Login;
import com.logicq.logicq.security.helper.TokenHandler;
import com.logicq.logicq.security.helper.UserFactory;
import com.logicq.logicq.security.service.UserService;
import com.logicq.logicq.service.login.IloginService;
import com.logicq.logicq.service.task.ITaskManagerService;
import com.logicq.logicq.service.user.IUserService;
import com.logicq.logicq.ui.login.vo.LoginVO;

@Service
@Transactional
public class LoginService implements IloginService {

	LoginConversion loginConversion = LoginConversion.getInstance();
	@Autowired
	ILoginDAO loginDAO;


	@Autowired
	IUserService userService;

	@Autowired
	ITaskManagerService taskManagerService;


	

	public void insertLoginDetails(Login loginDetails) {
		loginDAO.insertLoginDetails(loginDetails);

	}

	
	@Override
	public LoginVO checkLoginUser(LoginVO p_request) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public LoginVO checkLoginUser(String username, String password) {
		Login loginuser=loginDAO.fethchLoginUser(username, password);
		return  UserFactory.create(loginuser);
	}


	@Override
	public void load() {
		HashMap<String, LoginVO> usermap = UserService.getUserMap();
		List<Login> alllogin = loginDAO.load();
		for (Login login : alllogin) {
			LoginVO loginvo = UserFactory.create(login);
			usermap.put(loginvo.getUsername(), loginvo);
		}
		UserService.setUserMap(usermap);
	}


}
