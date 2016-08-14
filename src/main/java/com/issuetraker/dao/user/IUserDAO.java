package com.issuetraker.dao.user;

import java.util.List;

import com.issuetraker.model.user.User;

public interface IUserDAO {
	
	public List<User> loadUsers();
	

}
