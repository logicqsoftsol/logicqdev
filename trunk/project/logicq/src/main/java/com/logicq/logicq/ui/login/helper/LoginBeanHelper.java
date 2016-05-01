package com.logicq.logicq.ui.login.helper;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.logicq.logicq.service.login.IloginService;
import com.logicq.logicq.ui.login.bean.LoginBean;
import com.logicq.logicq.ui.login.vo.LoginRequest;
import com.logicq.logicq.ui.login.vo.LoginResponse;
import com.logicq.logicq.ui.login.vo.LoginVO;

public class LoginBeanHelper {
	@Autowired
	IloginService loginFacade;



	public static LoginVO conversionUItoVO(LoginBean p_loginbean, LoginVO p_login) {

		 p_login.setEmail(p_loginbean.getUsername());
	     p_login.setPassword(p_loginbean.getPassword());

		return p_login;
	}

	public static LoginBean conversionVOtoUI(LoginVO p_login, LoginBean p_loginbean) {
		 p_loginbean.setUsername(p_login.getEmail());
		 p_loginbean.setPassword(p_login.getPassword());

		return p_loginbean;
	}

	public LoginResponse checkloginUser(LoginRequest resquest,LoginResponse response) {
		return (loginFacade.checkLoginUser(resquest, response));
	}

	public static void renderPropertiesAfterLogin(LoginBean loginbean) {
		loginbean.setNavrender("true");
		loginbean.setLogoutvisible("true");
		loginbean.setLoginvisible("false");
		loginbean.setSignupvisible("false");
		loginbean.setLogedinusername("demo");
		loginbean.setLogedintime(new Date().toString());
	}

}
