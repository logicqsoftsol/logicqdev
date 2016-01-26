package com.logicq.logicq.facade.login;

import com.logicq.logicq.ui.login.vo.LoginRequest;
import com.logicq.logicq.ui.login.vo.LoginResponse;


public interface ILoginFacade {
	
	public LoginResponse checkLoginUser(LoginRequest p_request,LoginResponse p_response);

}
