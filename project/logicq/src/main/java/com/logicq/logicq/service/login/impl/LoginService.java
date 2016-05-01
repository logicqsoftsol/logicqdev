package com.logicq.logicq.service.login.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.logicq.logicq.constant.LogicQConstants;
import com.logicq.logicq.conversion.login.LoginConversion;
import com.logicq.logicq.dao.login.ILoginDAO;
import com.logicq.logicq.model.login.Login;
import com.logicq.logicq.model.login.Role;
import com.logicq.logicq.model.user.User;
import com.logicq.logicq.service.login.IloginService;
import com.logicq.logicq.service.task.ITaskManagerService;
import com.logicq.logicq.service.user.IUserService;
import com.logicq.logicq.ui.login.vo.LoginRequest;
import com.logicq.logicq.ui.login.vo.LoginResponse;

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


	public LoginResponse checkLoginUser(LoginRequest p_loginrequest, LoginResponse p_response) {

		Login loginuserentity = loginConversion.handleConversionVOtoEntityWithContext(p_loginrequest.getLoginVO());
		List<Login> l_login = loginDAO.checkLoginUser(loginuserentity);
		if (l_login.size() > 0) {
			Long roleid = Long.valueOf(0);
			p_response.setLoginVO(loginConversion.conversionFromEntitytoVO(l_login.get(0), p_loginrequest.getLoginVO()));
			User user = userService.getuserDetail(l_login.get(0).getUserid());
			Set<Role> listrole = user.getRole();
			for (Role role : listrole) {
				roleid = role.getRoleid();
			}
			if (roleid == LogicQConstants.ADMIN) {
				p_response.getLogicqTransactionStatus().setNavigationcode(LogicQConstants.ADMIN);
			} else {
				p_response.getLogicqTransactionStatus().setNavigationcode(LogicQConstants.USER);
			}
		} else {
			p_response.getLogicqTransactionStatus().setNavigationcode(LogicQConstants.INV_USER);
		}
		return p_response;
	}

	public void insertLoginDetails(Login loginDetails) {

		loginDAO.insertLoginDetails(loginDetails);
	}
}
