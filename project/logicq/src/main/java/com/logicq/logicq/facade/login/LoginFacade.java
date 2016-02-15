package com.logicq.logicq.facade.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.logicq.service.login.IloginService;
import com.logicq.logicq.ui.login.vo.LoginRequest;
import com.logicq.logicq.ui.login.vo.LoginResponse;

public class LoginFacade implements ILoginFacade {

	@Autowired
	IloginService loginService;

	public void setLoginService(IloginService loginService) {

		this.loginService = loginService;
	}

	public IloginService getLoginService() {

		return loginService;
	}

	@Transactional(propagation=Propagation.SUPPORTS,readOnly = true)
	public LoginResponse checkLoginUser(LoginRequest p_request, LoginResponse p_response) {

		return getLoginService().checkLoginUser(p_request, p_response);
	}
}
