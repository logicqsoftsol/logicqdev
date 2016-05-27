package com.logicq.logicq.conversion.login;

import com.logicq.logicq.common.LogicqContextProvider;
import com.logicq.logicq.model.login.Login;
import com.logicq.logicq.ui.login.vo.LoginVO;

public class LoginConversion {

	private static LoginConversion loginConversioninstance;

	public static LoginConversion getInstance() {

		if (loginConversioninstance == null) {
			loginConversioninstance = new LoginConversion();
		}
		return loginConversioninstance;
	}

	public Login conversionFromVOtoEntity(LoginVO loginvo, Login loginuser) {

		loginuser.setEmail(loginvo.getEmail());
//		loginuser.setPhonnumber(loginvo.getPhonnumber());
//		loginuser.setIpaddress(loginvo.getIpaddress());
//		loginuser.setLastlogindate(loginvo.getLastlogindate());
//		loginuser.setLoginattempcounts(loginvo.getLoginattempcounts());
//		loginuser.setUserid(loginvo.getUserid());
		loginuser.setPassword(loginvo.getPassword());
		return loginuser;
	}

	public LoginVO conversionFromEntitytoVO(Login loginuser, LoginVO loginvo) {

		loginvo.setEmail(loginuser.getEmail());
//		loginvo.setPhonnumber(loginuser.getPhonnumber());
//		loginvo.setIpaddress(loginuser.getIpaddress());
//		loginvo.setLastlogindate(loginuser.getLastlogindate());
//		loginvo.setLoginattempcounts(loginuser.getLoginattempcounts());
//		loginvo.setUserid(loginuser.getUserid());
		loginvo.setPassword(loginuser.getPassword());
		return loginvo;
	}

	public Login handleConversionVOtoEntityWithContext(LoginVO loginvo) {

		Login loginentity = null;
		if (null == loginentity) {
			loginentity = new Login();
		}
		return conversionFromVOtoEntity(loginvo, loginentity);
	}
}
/**
 * NIHAR 01-Jan-2016 3:51:15 pm
 */