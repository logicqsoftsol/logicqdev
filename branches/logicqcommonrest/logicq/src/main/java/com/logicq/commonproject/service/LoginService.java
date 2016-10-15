package com.logicq.commonproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.commonproject.dao.ILoginDAO;
import com.logicq.commonproject.model.Login;

/**
 * NIHAR 15-Oct-2016 6:07:52 pm
 */
@Service
@Transactional
public class LoginService implements ILoginService {

	@Autowired
	ILoginDAO loginDAO;

	@Override
	public boolean validateUser(String username, String password) {

		List<Login> loginUserlist = loginDAO.getUser();
		for (Login login : loginUserlist) {
			if (login.getUsername().equals(username) && login.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
}
