package com.logicq.logicq.service.login;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.logicq.logicq.model.login.Login;
import com.logicq.logicq.ui.login.vo.LoginVO;
import com.logicq.logicq.ui.security.LoginUserVO;

public interface IloginService {

	@ExceptionHandler(Exception.class)
	public LoginVO checkLoginUser(LoginVO p_request);

	@ExceptionHandler(Exception.class)
	public LoginUserVO checkLoginUser(String username,String password);
	
	@ExceptionHandler(Exception.class)
	public void insertLoginDetails(Login loginDetails);
}
