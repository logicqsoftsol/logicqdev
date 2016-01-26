package com.logicq.logicq.service.login;

import com.logicq.logicq.model.login.Login;
import com.logicq.logicq.ui.login.vo.LoginRequest;
import com.logicq.logicq.ui.login.vo.LoginResponse;

public interface IloginService {

	public LoginResponse checkLoginUser(LoginRequest p_request, LoginResponse p_loginresponse);

	public void insertLoginDetails(Login loginDetails);
}
