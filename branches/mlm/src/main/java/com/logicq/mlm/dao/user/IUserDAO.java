package com.logicq.mlm.dao.user;

import com.logicq.mlm.model.profile.UserProfile;

public interface IUserDAO {
	
	UserProfile fetchUser(UserProfile user);
	void deleteUser(UserProfile user);
	void saveUser(UserProfile user);
	void updateUser(UserProfile user);

}
