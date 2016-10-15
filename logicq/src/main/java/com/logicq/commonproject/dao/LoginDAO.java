package com.logicq.commonproject.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.logicq.commonproject.model.Login;

/**
 * NIHAR 15-Oct-2016 6:17:24 pm
 */
@Repository
public class LoginDAO extends AbstractDAO<Login> implements ILoginDAO {

	@Override
	public List<Login> getUser() {

		// TODO Auto-generated method stub
		return (List<Login>) loadClass(Login.class);
	}
}
