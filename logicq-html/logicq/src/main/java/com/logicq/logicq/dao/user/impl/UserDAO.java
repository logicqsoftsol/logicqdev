package com.logicq.logicq.dao.user.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import com.logicq.logicq.common.criteriamanager.LogicqCriteriaHandler;
import com.logicq.logicq.constant.CommunicationType;
import com.logicq.logicq.constant.EntityType;
import com.logicq.logicq.dao.AbstractDAO;
import com.logicq.logicq.dao.user.IUserDAO;
import com.logicq.logicq.dao.user.UserFilterObject;
import com.logicq.logicq.model.user.User;
import com.logicq.logicq.model.user.UserConstant;
import com.logicq.logicq.model.user.UserSearch;

/**
 * User DAO
 * 
 * @author SudhanshuL
 * @since 11 Dec 2012
 * @version 1.0.0
 */
@Repository
public class UserDAO extends AbstractDAO<User> implements IUserDAO {

	public void addUser(User user) {

		save(user);
	}

	public void updateUser(User user) {

		update(user);
	}

	public void deleteUser(User user) {

		delete(user);
	}

	public User getUserById(Long userid) {

		return null;
	}

	@SuppressWarnings("unchecked")
	public List<User> getUsers() {

		return (List<User>) loadClass(User.class);
	}

	public User getuserDetail(Long userId) {
			return (User) load(User.class, userId);
	}

	public Boolean checkMobileNo(String mobileNo) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("phone", mobileNo);
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) executeNamedQuery(UserConstant.GET_MOBILE_NO, params);
		if (users != null && !users.isEmpty() && (users.size() > 0)) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public Boolean checkEmail(String emailId) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("email", emailId);
		List<User> users = (List<User>) executeNamedQuery(UserConstant.GET_EMAIL_ID, params);
		if (users != null && !users.isEmpty() && (users.size() > 0)) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unused")
	private List<UserFilterObject> bindParameters(Long input) {

		UserFilterObject obj = new UserFilterObject();
		List<UserFilterObject> userFilterList = new ArrayList<UserFilterObject>();
		obj.setFieldname("userId");
		obj.setFieldvalue(input);
		userFilterList.add(obj);
		return userFilterList;
	}

	@SuppressWarnings("unchecked")
	public User getUserIdFromEmailOrMobile(String input, CommunicationType type) {

		Map<String, Object> params = new HashMap<String, Object>();
		List<User> users = new ArrayList<User>();
		if (CommunicationType.EMAIL.equals(type)) {
			params.put("email", input);
			users = (List<User>) executeNamedQuery(UserConstant.GET_EMAIL_ID, params);
		} else {
			params.put("phone", input);
			users = (List<User>) executeNamedQuery(UserConstant.GET_MOBILE_NO, params);
		}
		if (users != null && !users.isEmpty() && (users.size() > 0)) {
			return users.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<User> getUsersForAddress(String[] addressDetails) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("city", addressDetails[0]);
		return (List<User>) executeNamedQuery(UserConstant.GET_USERS_NEAR_ADDRESS, params);
	}

	@SuppressWarnings("unchecked")
	public List<User> getParticularUsersForArea(EntityType entityType, String area) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("entityType", entityType);
		params.put("city", area);
		return (List<User>) executeNamedQuery(UserConstant.GET_PARTICULAR_USERS_NEAR_ADDRESS, params);
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllEntityAccordingtoLocation(UserSearch usersearch) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("entityType", usersearch.getSearchText());
		params.put("addressId", usersearch.getAddressid());
		return  (List<User>) executeNamedQuery(UserConstant.GET_PARTICULAR_USERS_NEAR_ADDRESS, params);
	}

	private Criteria formQueryParams(UserSearch usersearch,LogicqCriteriaHandler l_crietria) {
		Criteria criteria=l_crietria.createCriteria(getSession(), User.class);
		criteria.createAlias("user.addresses", "addr", JoinType.LEFT_OUTER_JOIN); 
		//criteria.add(Restrictions.eq("patient.phone", phone))
	return criteria;
	}

}