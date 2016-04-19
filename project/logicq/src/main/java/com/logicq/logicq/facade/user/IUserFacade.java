package com.logicq.logicq.facade.user;

import java.util.List;

import com.logicq.logicq.model.user.User;
import com.logicq.logicq.ui.user.vo.UserProfilesRequest;
import com.logicq.logicq.ui.user.vo.UserProfilesResponse;
import com.logicq.logicq.ui.user.vo.UserRegistrationRequest;
import com.logicq.logicq.ui.user.vo.UserRegistrationResponse;
import com.logicq.logicq.ui.user.vo.UserVO;

public interface IUserFacade {

	/**
	 * Add User
	 * 
	 * @param User
	 *            user
	 */
	public UserRegistrationResponse addUser(UserRegistrationRequest userRequest, UserRegistrationResponse userResponse);

	/**
	 * Update User
	 * 
	 * @param User
	 *            user
	 */
	public void updateUser(UserVO user);

	/**
	 * Delete User
	 * 
	 * @param User
	 *            user
	 */
	public void deleteUser(UserVO user);

	/**
	 * Get User
	 * 
	 * @param int
	 *            User Id
	 */
	public User getUserById(int id);

	/**
	 * Get User List
	 * 
	 * @return List - User list
	 */
	public List<User> getUsers();

	public UserProfilesResponse getParticularUsersForArea(UserProfilesRequest request, UserProfilesResponse response);
}
