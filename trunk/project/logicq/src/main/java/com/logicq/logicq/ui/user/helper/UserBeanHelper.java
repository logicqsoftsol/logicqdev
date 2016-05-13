package com.logicq.logicq.ui.user.helper;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;

import com.logicq.logicq.service.user.IUserService;
import com.logicq.logicq.ui.user.bean.UserBean;
import com.logicq.logicq.ui.user.vo.UserProfilesRequest;
import com.logicq.logicq.ui.user.vo.UserProfilesResponse;
import com.logicq.logicq.ui.user.vo.UserRegistrationRequest;
import com.logicq.logicq.ui.user.vo.UserRegistrationResponse;
import com.logicq.logicq.ui.user.vo.UserVO;
import com.logicq.logicq.utils.DateUtils;

public class UserBeanHelper {

	@Autowired
	IUserService userService;

	

	public UserRegistrationResponse addUser(UserRegistrationRequest userRequest, UserRegistrationResponse userResponse) {

		return (userService.addUser(userRequest, userResponse));
	}

	
	public UserVO conversionUItoVO(UserBean userBean, UserVO userVO) {
		userVO.setFirstName(userBean.getFirstname());  
		userVO.setLastName(userBean.getLastname());
		userVO.setDateOfBirth(DateUtils.convertStringToDate(userBean.getDob()));
		userVO.setEmailId(userBean.getEmail());
		userVO.setGender(userBean.getSex());
		userVO.setMobileno(userBean.getMobilenumber());
		userVO.setPassword(userBean.getPassword());
		return userVO;
	}

	public UserBean conversionVOtoUI(UserVO p_user, UserBean p_userbean) {
		p_userbean.setFirstname(p_user.getFirstName());
		p_userbean.setLastname(p_user.getLastName());
		p_userbean.setDob(DateUtils.convertDateToString(p_user.getDateOfBirth()));
		p_userbean.setEmail(p_user.getEmailId());
		p_userbean.setSex(p_user.getGender());
		p_userbean.setMobilenumber(p_user.getMobileno());
		p_userbean.setPassword(p_user.getPassword());
		p_userbean.setConfirmpassword(p_user.getPassword());
		return p_userbean;
	}

	public UserProfilesResponse getParticularUsersForArea(UserProfilesRequest request, UserProfilesResponse response) {

		return (userService.getParticularUsersForArea(request, response));
	}
}
