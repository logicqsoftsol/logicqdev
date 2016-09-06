package com.logicq.electionmgm.dao.user.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.logicq.common.AbstractDAO;
import com.logicq.electionmgm.dao.user.IUserDAO;
import com.logicq.electionmgm.model.user.User;


@Repository
public class UserDAOImpl extends AbstractDAO<User> implements IUserDAO{


	
	@Override
	public List<User> loadUsers() {
		return (List<User>) loadClass(User.class);
	}

	

	
}
