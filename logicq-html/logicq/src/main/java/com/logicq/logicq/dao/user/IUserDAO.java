package com.logicq.logicq.dao.user;

import java.util.List;

import com.logicq.logicq.constant.CommunicationType;
import com.logicq.logicq.constant.EntityType;
import com.logicq.logicq.model.user.User;
import com.logicq.logicq.model.user.UserSearch;

/**
 * User DAO Interface
 * 
 * @author SudhanshuL
 * @since 11 Dec 2015
 * @version 1.0.0
 */
public interface IUserDAO {

	/**
	 * Add User
	 * 
	 * @param LoginUser
	 *            user
	 */
	public void addUser(User user);

	/**
	 * Update User
	 * 
	 * @param LoginUser
	 *            user
	 */
	public void updateUser(User user);

	/**
	 * Delete User
	 * 
	 * @param LoginUser
	 *            user
	 */
	public void deleteUser(User user);

	/**
	 * Get User
	 * 
	 * @param int
	 *            User Id
	 */
	public User getUserById(Long id);

	public User getuserDetail(Long id);

	/**
	 * Get User List
	 */
	public List<User> getUsers();

	public Boolean checkMobileNo(String mobileNo);

	public Boolean checkEmail(String emailId);

	public User getUserIdFromEmailOrMobile(String input, CommunicationType type);

	public List<User> getUsersForAddress(String[] addressDetails);
	
	List<User> getAllEntityAccordingtoLocation(UserSearch usersearch);

}
