
package com.logicq.logicq.ui.login.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.logicq.logicq.common.LogicqContextProvider;
import com.logicq.logicq.constant.LogicQConstants;
import com.logicq.logicq.ui.login.helper.LoginBeanHelper;
import com.logicq.logicq.ui.login.vo.LoginResponse;

@ManagedBean(name = "loginMB")
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String navrender = "false";
	private String otpcode;
	private String logoutvisible = "false";
	private String loginvisible = "true";
	private String signupvisible = "true";
	private String logedinusername;
	private String logedintime;
	private String loginStastus;
	private String loginstastusrender = "fase";
	private String acesscoderender = "false";

	public String getOtpcode() {

		return otpcode;
	}

	public void setOtpcode(String otpcode) {

		this.otpcode = otpcode;
	}

	public String getAcesscoderender() {

		return acesscoderender;
	}

	public void setAcesscoderender(String acesscoderender) {

		this.acesscoderender = acesscoderender;
	}

	//getLoginstatusrender()
	public String getLoginstastusrender() {

		return loginstastusrender;
	}

	public void setLoginstastusrender(String loginstastusrender) {

		this.loginstastusrender = loginstastusrender;
	}

	//getLogin status
	public String getLoginStastus() {

		return loginStastus;
	}

	public void setLoginStastus(String loginStastus) {

		this.loginStastus = loginStastus;
	}

	public String getLogedinusername() {

		return logedinusername;
	}

	public void setLogedinusername(String logedinusername) {

		this.logedinusername = logedinusername;
	}

	public String getLogedintime() {

		return logedintime;
	}

	public void setLogedintime(String logedintime) {

		this.logedintime = logedintime;
	}

	public String getLoginvisible() {

		return loginvisible;
	}

	public void setLoginvisible(String loginvisible) {

		this.loginvisible = loginvisible;
	}

	public String getSignupvisible() {

		return signupvisible;
	}

	public void setSignupvisible(String signupvisible) {

		this.signupvisible = signupvisible;
	}

	public String getLogoutvisible() {

		return logoutvisible;
	}

	public void setLogoutvisible(String logoutvisible) {

		this.logoutvisible = logoutvisible;
	}

	public void getMobAcessCode() {

		setAcesscoderender("true");
	}

	public String getNavrender() {

		return navrender;
	}

	public void setNavrender(String navrender) {

		this.navrender = navrender;
	}

	public String getUsername() {

		return username;
	}

	public void setUsername(String username) {

		this.username = username;
	}

	public String getPassword() {

		return password;
	}

	public void setPassword(String password) {

		this.password = password;
	}

	public String checkLogin() {

		loginStastus = "Error in login please check with your userid and password";
		loginstastusrender = "true";
		LoginManagedBean loginManagedBean = LogicqContextProvider.getApplicationContext().getBean(LoginManagedBean.class);
		LoginResponse response = loginManagedBean.checkLoginUser(this);
		LoginBeanHelper.renderPropertiesAfterLogin(this);
		//return (loginManagedBean.checkLoginUser(this));
		int value = response.getLogicqTransactionStatus().getNavigationcode();
		if (value == LogicQConstants.ADMIN) {
			return LogicQConstants.ADMIN_ROLE;
		} else if (value == LogicQConstants.USER) {
			return LogicQConstants.USER_ROLE;
		}
		else{
			loginStastus = "Error in login please check with your userid and password";
			loginstastusrender = "true";
			return LogicQConstants.INVALID_USER;
		}
		
		 
	}

	public String logout() {

		System.out.println("in LoginBean logout()");
		System.out.println("in LoginBean password logout()");
		navrender = "false";
		loginvisible = "true";
		signupvisible = "true";
		logoutvisible = "false";
		return "logout";
	}
}
