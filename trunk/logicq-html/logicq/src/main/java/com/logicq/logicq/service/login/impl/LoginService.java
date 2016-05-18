package com.logicq.logicq.service.login.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.logicq.conversion.login.LoginConversion;
import com.logicq.logicq.dao.login.ILoginDAO;
import com.logicq.logicq.model.login.Login;
import com.logicq.logicq.model.login.Role;
import com.logicq.logicq.model.user.User;
import com.logicq.logicq.service.login.IloginService;
import com.logicq.logicq.service.task.ITaskManagerService;
import com.logicq.logicq.service.user.IUserService;
import com.logicq.logicq.ui.login.vo.LoginVO;

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


	public LoginVO checkLoginUser(LoginVO p_loginrequest) {

		Login loginuserentity = loginConversion.handleConversionVOtoEntityWithContext(p_loginrequest);
		List<Login> l_login = loginDAO.checkLoginUser(loginuserentity);
		if (l_login.size() > 0) {
			Long roleid = Long.valueOf(0);
			loginConversion.conversionFromEntitytoVO(l_login.get(0), p_loginrequest);
			User user = userService.getuserDetail(l_login.get(0).getUserid());
			Set<Role> listrole = user.getRole();
			for (Role role : listrole) {
				roleid = role.getRoleid();
			}
		}
			
		return p_loginrequest;
	}

	public void insertLoginDetails(Login loginDetails) {

		loginDAO.insertLoginDetails(loginDetails);
	}
}
