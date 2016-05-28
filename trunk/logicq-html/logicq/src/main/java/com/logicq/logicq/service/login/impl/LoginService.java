package com.logicq.logicq.service.login.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.logicq.common.LogicqConversion;
import com.logicq.logicq.conversion.login.LoginConversion;
import com.logicq.logicq.dao.login.ILoginDAO;
import com.logicq.logicq.dao.login.impl.LoginDAO;
import com.logicq.logicq.model.login.Login;
import com.logicq.logicq.model.login.Role;
import com.logicq.logicq.model.security.LoginUser;
import com.logicq.logicq.model.user.User;
import com.logicq.logicq.security.helper.UserFactory;
import com.logicq.logicq.service.login.IloginService;
import com.logicq.logicq.service.task.ITaskManagerService;
import com.logicq.logicq.service.user.IUserService;
import com.logicq.logicq.ui.login.vo.LoginVO;
import com.logicq.logicq.ui.security.LoginUserVO;

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
	public LoginUserVO checkLoginUser(String username, String password) {
		LoginDAO loginDAO=new LoginDAO();
		LoginUser loginuser=loginDAO.fethchUser(username, password);
		return  UserFactory.create(loginuser);
	}
}
