package com.logicq.mlm.service.user;

import com.logicq.mlm.model.profile.UserProfile;

public interface IUserService {
	
	UserProfile fetchUser(UserProfile user);
	void deleteUser(UserProfile user);
	void saveUser(UserProfile user);
	void updateUser(UserProfile user);

}
