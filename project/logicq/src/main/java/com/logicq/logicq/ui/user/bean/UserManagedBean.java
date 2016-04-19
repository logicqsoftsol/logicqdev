package com.logicq.logicq.ui.user.bean;

import com.logicq.logicq.common.LogicqContextProvider;
import com.logicq.logicq.constant.EntityType;
import com.logicq.logicq.ui.task.vo.TaskVO;
import com.logicq.logicq.ui.user.helper.UserBeanHelper;
import com.logicq.logicq.ui.user.vo.UserProfilesRequest;
import com.logicq.logicq.ui.user.vo.UserProfilesResponse;
import com.logicq.logicq.ui.user.vo.UserRegistrationRequest;
import com.logicq.logicq.ui.user.vo.UserRegistrationResponse;
import com.logicq.logicq.ui.user.vo.UserVO;

/**
 * *@author SudhanshuL
 * 
 * @since 11 Dec 2012
 * @version 1.0.0
 */
public class UserManagedBean {

	public UserRegistrationResponse addUser(UserBean userBean) {

		UserBeanHelper userBeanHelper = LogicqContextProvider.getApplicationContext().getBean(UserBeanHelper.class);
		UserVO userVO = LogicqContextProvider.getApplicationContext().getBean(UserVO.class);
		TaskVO taskVO = LogicqContextProvider.getApplicationContext().getBean(TaskVO.class);
		userVO = userBeanHelper.conversionUItoVO(userBean, userVO);
		UserRegistrationRequest userRequest = LogicqContextProvider.getApplicationContext().getBean(UserRegistrationRequest.class);
		UserRegistrationResponse userRegistrationResponse = LogicqContextProvider.getApplicationContext().getBean(UserRegistrationResponse.class);
		userRequest.setUserVO(userVO);
		userRequest.setTaskVO(taskVO);
		userRegistrationResponse = userBeanHelper.addUser(userRequest, userRegistrationResponse);
		return userRegistrationResponse;
	}

	/**
	 * Reset Fields
	 */
	public String reset() {

		UserBean userbean = LogicqContextProvider.getApplicationContext().getBean(UserBean.class);
		userbean.setId(0);
		userbean.setName("");
		userbean.setSurname("");
		return "sucess";
	}

	public UserProfilesResponse getParticularUsersForArea(EntityType entityType, String area) {

		UserBeanHelper userBeanHelper = LogicqContextProvider.getApplicationContext().getBean(UserBeanHelper.class);
		UserProfilesRequest userProfilesRequest = LogicqContextProvider.getApplicationContext().getBean(UserProfilesRequest.class);
		UserProfilesResponse userProfilesResponse = LogicqContextProvider.getApplicationContext().getBean(UserProfilesResponse.class);
		userProfilesRequest.setEntityType(entityType);
		userProfilesRequest.setArea(area);
		UserProfilesResponse response = userBeanHelper.getParticularUsersForArea(userProfilesRequest, userProfilesResponse);
		return response;
	}
}
