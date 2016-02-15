package com.logicq.logicq.service.login;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.logicq.logicq.model.login.Login;
import com.logicq.logicq.ui.login.vo.LoginRequest;
import com.logicq.logicq.ui.login.vo.LoginResponse;

public interface IloginService {

	@ExceptionHandler(Exception.class)
	public LoginResponse checkLoginUser(LoginRequest p_request, LoginResponse p_loginresponse);

	@ExceptionHandler(Exception.class)
	public void insertLoginDetails(Login loginDetails);
}
