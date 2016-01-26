package com.logicq.logicq.ui.login.bean;

import com.logicq.logicq.common.LogicqContextProvider;
import com.logicq.logicq.ui.login.helper.LoginBeanHelper;
import com.logicq.logicq.ui.login.vo.LoginRequest;
import com.logicq.logicq.ui.login.vo.LoginResponse;
import com.logicq.logicq.ui.login.vo.LoginVO;
import com.logicq.logicq.ui.task.vo.TaskVO;

public class LoginManagedBean {

	public LoginResponse checkLoginUser(LoginBean loginbean) {

		LoginBeanHelper loginBeanHelper = LogicqContextProvider.getApplicationContext().getBean(LoginBeanHelper.class);
		LoginVO loginvo = LogicqContextProvider.getApplicationContext().getBean(LoginVO.class);
		TaskVO taskVO = LogicqContextProvider.getApplicationContext().getBean(TaskVO.class);
		loginvo = LoginBeanHelper.conversionUItoVO(loginbean, loginvo);
		LoginRequest loginrequest = LogicqContextProvider.getApplicationContext().getBean(LoginRequest.class);
		LoginResponse loginresponse = LogicqContextProvider.getApplicationContext().getBean(LoginResponse.class);
		loginrequest.setLoginVO(loginvo);
		loginrequest.setTaskVO(taskVO);
		return loginBeanHelper.checkloginUser(loginrequest, loginresponse);
	}
}
