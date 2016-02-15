package com.logicq.logicq.dao.user.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.logicq.logicq.constant.CommunicationType;
import com.logicq.logicq.dao.AbstractDAO;
import com.logicq.logicq.dao.user.IUserDAO;
import com.logicq.logicq.dao.user.UserFilterObject;
import com.logicq.logicq.model.user.User;
import com.logicq.logicq.model.user.UserConstant;

/**
 * User DAO
 * 
 * @author SudhanshuL
 * @since 11 Dec 2012
 * @version 1.0.0
 */
public class UserDAO extends AbstractDAO<User> implements IUserDAO {

	public void addUser(User user) {

		save(user, null);
	}

	public void updateUser(User user) {

		update(user, null);
	}

	public void deleteUser(User user) {

		delete(user, null);
	}

	public User getUserById(Long userid) {

		return null;
	}

	public List<User> getUsers() {

		return null;
	}

	public User getuserDetail(Long userId) {

		User user = (User) load(User.class, userId);
		if (user != null) {
			return user;
		} else {
			return null;
		}
	}

	public Boolean checkMobileNo(String mobileNo) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mobileNo", mobileNo);
		List<User> users = (List<User>) executeNamedQuery(UserConstant.GET_MOBILE_NO, params);
		if (users != null && !users.isEmpty() && (users.size() > 0)) {
			return false;
		}
		return true;
	}

	public Boolean checkEmail(String emailId) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("emailId", emailId);
		List<User> users = (List<User>) executeNamedQuery(UserConstant.GET_EMAIL_ID, params);
		if (users != null && !users.isEmpty() && (users.size() > 0)) {
			return false;
		}
		return true;
	}

	private List<UserFilterObject> bindParameters(Long input) {

		UserFilterObject obj = new UserFilterObject();
		List<UserFilterObject> userFilterList = new ArrayList<UserFilterObject>();
		obj.setFieldname("userId");
		obj.setFieldvalue(input);
		userFilterList.add(obj);
		return userFilterList;
	}

	public User getUserIdFromEmailOrMobile(String input, CommunicationType type) {

		Map<String, Object> params = new HashMap<String, Object>();
		List<User> users = new ArrayList<User>();
		if (CommunicationType.EMAIL.equals(type)) {
			params.put("emailId", input);
			users = (List<User>) executeNamedQuery(UserConstant.GET_EMAIL_ID, params);
		} else {
			params.put("mobileNo", input);
			users = (List<User>) executeNamedQuery(UserConstant.GET_MOBILE_NO, params);
		}
		if (users != null && !users.isEmpty() && (users.size() > 0)) {
			return users.get(0);
		}
		return null;
	}
}