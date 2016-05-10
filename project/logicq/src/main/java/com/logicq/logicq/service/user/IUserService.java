package com.logicq.logicq.service.user;

import java.util.List;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.logicq.logicq.constant.CommunicationType;
import com.logicq.logicq.model.user.User;
import com.logicq.logicq.ui.user.vo.UserProfilesRequest;
import com.logicq.logicq.ui.user.vo.UserProfilesResponse;
import com.logicq.logicq.ui.user.vo.UserRegistrationRequest;
import com.logicq.logicq.ui.user.vo.UserRegistrationResponse;
import com.logicq.logicq.ui.user.vo.UserVO;

/**
 * User Service Interface
 * 
 * @author SudhanshuL
 * @since 11 Dec 2012
 * @version 1.0.0
 */
public interface IUserService {

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
	@ExceptionHandler(Exception.class)
	public void updateUser(UserVO user);

	/**
	 * Delete User
	 * 
	 * @param User
	 *            user
	 */
	@ExceptionHandler(Exception.class)
	public void deleteUser(UserVO user);

	/**
	 * Get User
	 * 
	 * @param Long
	 *            User Id
	 */
	@ExceptionHandler(Exception.class)
	public User getUserById(Long id);

	/**
	 * Get User List
	 * 
	 * @return List - User list
	 */
	@ExceptionHandler(Exception.class)
	public List<User> getUsers();

	@ExceptionHandler(Exception.class)
	public Long getUserIdFromEmailOrMobile(String input, CommunicationType type);

	@ExceptionHandler(Exception.class)
	public User getuserDetail(Long id);

	@ExceptionHandler(Exception.class)
	public UserProfilesResponse getParticularUsersForArea(UserProfilesRequest request, UserProfilesResponse response);
}