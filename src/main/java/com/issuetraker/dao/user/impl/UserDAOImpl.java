package com.issuetraker.dao.user.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.issuetraker.common.AbstractDAO;
import com.issuetraker.dao.user.IUserDAO;
import com.issuetraker.model.user.User;


@Repository
public class UserDAOImpl extends AbstractDAO<User> implements IUserDAO{


	
	@Override
	public List<User> loadUsers() {
		return (List<User>) loadClass(User.class);
	}

	

	
}
