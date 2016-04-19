package com.logicq.logicq.facade.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.logicq.model.user.User;
import com.logicq.logicq.service.user.IUserService;
import com.logicq.logicq.ui.user.vo.UserProfilesRequest;
import com.logicq.logicq.ui.user.vo.UserProfilesResponse;
import com.logicq.logicq.ui.user.vo.UserRegistrationRequest;
import com.logicq.logicq.ui.user.vo.UserRegistrationResponse;
import com.logicq.logicq.ui.user.vo.UserVO;

public class UserFacade implements IUserFacade {

	@Autowired
	IUserService userService;

	public IUserService getUserService() {

		return userService;
	}

	public void setUserService(IUserService userService) {

		this.userService = userService;
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public UserRegistrationResponse addUser(UserRegistrationRequest userRequest, UserRegistrationResponse userResponse) {

		return (getUserService().addUser(userRequest, userResponse));
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public void updateUser(UserVO user) {
		// TODO Auto-generated method stub

	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public void deleteUser(UserVO user) {
		// TODO Auto-generated method stub

	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public User getUserById(int id) {

		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<User> getUsers() {

		// TODO Auto-generated method stub
		return null;
	}

	public UserProfilesResponse getParticularUsersForArea(UserProfilesRequest request, UserProfilesResponse response) {

		return (getUserService().getParticularUsersForArea(request, response));
	}
}
