package com.crm.logicq.dao.login.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.crm.logicq.common.AbstractDAO;
import com.crm.logicq.dao.login.ILoginDAO;
import com.crm.logicq.model.login.Login;

@Repository
public class LoginDAO extends AbstractDAO<Login> implements ILoginDAO {

	@Override
	public List<Login> loadloginUser() {
		
		return (List<Login>) loadClass(Login.class);
	}

	

	
	

}
