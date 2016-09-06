package com.logicq.electionmgm.dao.user;

import java.util.List;

import com.logicq.electionmgm.model.user.User;

public interface IUserDAO {
	
	public List<User> loadUsers();
	

}
