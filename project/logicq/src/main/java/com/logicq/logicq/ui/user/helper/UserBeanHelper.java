package com.logicq.logicq.ui.user.helper;

import org.springframework.beans.factory.annotation.Autowired;

import com.logicq.logicq.service.user.IUserService;
import com.logicq.logicq.ui.user.bean.UserBean;
import com.logicq.logicq.ui.user.vo.UserProfilesRequest;
import com.logicq.logicq.ui.user.vo.UserProfilesResponse;
import com.logicq.logicq.ui.user.vo.UserRegistrationRequest;
import com.logicq.logicq.ui.user.vo.UserRegistrationResponse;
import com.logicq.logicq.ui.user.vo.UserVO;

public class UserBeanHelper {

	@Autowired
	IUserService userService;

	

	public UserRegistrationResponse addUser(UserRegistrationRequest userRequest, UserRegistrationResponse userResponse) {

		return (userService.addUser(userRequest, userResponse));
	}

	public UserVO conversionUItoVO(UserBean userBean, UserVO userVO) {

		userVO.setName(userBean.getName());
		userVO.setSurname(userBean.getSurname());
		userVO.setEmailId(userBean.getEmail());
		userVO.setMobileNo(userBean.getMobilenumber());
		userVO.setGender(userBean.getSex());
		userVO.setPassword(userBean.getPassword());
		return userVO;
	}

	public UserBean conversionVOtoUI(UserVO p_user, UserBean p_userbean) {

		p_userbean.setId(p_user.getId());
		p_userbean.setName(p_user.getName());
		p_userbean.setSurname(p_user.getSurname());
		return p_userbean;
	}

	public boolean validateUser(String user) {

		return false;
	}

	public UserProfilesResponse getParticularUsersForArea(UserProfilesRequest request, UserProfilesResponse response) {

		return (userService.getParticularUsersForArea(request, response));
	}
}
