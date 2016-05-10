package com.logicq.logicq.service.user.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.logicq.logicq.common.LogicqContextProvider;
import com.logicq.logicq.constant.CommunicationType;
import com.logicq.logicq.constant.EntityType;
import com.logicq.logicq.conversion.user.UserConversion;
import com.logicq.logicq.dao.user.IUserDAO;
import com.logicq.logicq.model.login.Login;
import com.logicq.logicq.model.user.User;
import com.logicq.logicq.service.alert.IAlertService;
import com.logicq.logicq.service.login.IloginService;
import com.logicq.logicq.service.task.ITaskManagerService;
import com.logicq.logicq.service.user.IUserService;
import com.logicq.logicq.ui.task.vo.TaskVO;
import com.logicq.logicq.ui.user.vo.UserProfilesRequest;
import com.logicq.logicq.ui.user.vo.UserProfilesResponse;
import com.logicq.logicq.ui.user.vo.UserRegistrationRequest;
import com.logicq.logicq.ui.user.vo.UserRegistrationResponse;
import com.logicq.logicq.ui.user.vo.UserVO;

/**
 * User Service
 * 
 * @author SudhanshuL
 * @since 11 Dec 2012
 * @version 1.0.0
 */
@Service
@Transactional
public class UserService implements IUserService {

	@Autowired
	IUserDAO userDAO;
	@Autowired
	ITaskManagerService itaskManagerService;
	@Autowired
	IloginService loginService;
	@Autowired
	IAlertService alertService;
	//@Autowired
	//AlertDetailsInputVO alertDetailsInputVO;

	UserConversion userConversion = UserConversion.getInstance();

	/**
	 * Add User
	 * 
	 * @param User
	 *            user
	 */
	@ExceptionHandler(Exception.class)
	public UserRegistrationResponse addUser(UserRegistrationRequest userRequest, UserRegistrationResponse userResponse) {

		UserVO userVO = userRequest.getUserVO();
		Boolean isUserValid = validateUser(userRequest.getUserVO());
		if (isUserValid) {
			User user = userConversion.handleConversionVOtoEntityWithContext(userVO);
			userDAO.addUser(user);
			//insert into login table
			Login loginDetails = setLoginDetails(user);
			loginService.insertLoginDetails(loginDetails);
			//call to email sending service.
			//alertService.sendAlert(alertDetailsInputVO);
			//Calling to task service for verify document
			TaskVO taskVO = new TaskVO();
			taskVO.setDescription("hardcode");
			taskVO.setName("sudhanshu");
			taskVO.setStatus("test");
			taskVO.setPriority("High");
			//itaskManagerService.addTask(taskVO);
		} else {
			//throw Exception
		}
		return userResponse;
	}

	private Login setLoginDetails(User user) {

		Login loginDetails = new Login();
		loginDetails.setEmail(user.getEmailId());
		loginDetails.setPhonnumber(user.getMobileNo());
		loginDetails.setPassword(user.getPassword());
		loginDetails.setUserid(user.getId());
		loginDetails.setLastlogindate(new Date());
		loginDetails.setIpaddress("10.210.245.165");
		return loginDetails;
	}

	private Boolean validateUser(UserVO userVO) {

		Boolean validFields = checkNullValues(userVO);
		if ( !validFields) {
			return false;
		}
		Boolean isNewEmail = checkEmail(userVO.getEmailId());
		Boolean isNewMobileNo = checkMobileNo(userVO.getMobileNo());
		return (isNewEmail && isNewMobileNo);
	}

	private Boolean checkNullValues(UserVO userVO) {

		if ((userVO.getEmailId() == null)
		    || (userVO.getMobileNo() == null)
		    || (userVO.getPassword() == null)
		    || (userVO.getSurname() == null)
		    || (userVO.getName() == null)
		    || (userVO.getMobileNo() == "")
		    || (userVO.getPassword() == "")
		    || (userVO.getSurname() == "")
		    || (userVO.getName() == "")
		    || (userVO.getEmailId() == "")) {
			return false;
		}
		return true;
	}

	private Boolean checkMobileNo(String mobileNo) {

		return (userDAO.checkMobileNo(mobileNo));
	}

	private Boolean checkEmail(String emailId) {

		return (userDAO.checkEmail(emailId));
	}

	/**
	 * Delete User
	 * 
	 * @param User
	 *            user
	 */
	public void deleteUser(UserVO user) {

		User l_userentity = userConversion.handleConversionVOtoEntityWithContext(user);
		userDAO.deleteUser(l_userentity);
	}

	/**
	 * Update User
	 * 
	 * @param User
	 *            user
	 */
	public void updateUser(UserVO user) {

		User l_userentity = userConversion.handleConversionVOtoEntityWithContext(user);
		userDAO.updateUser(l_userentity);
	}

	/**
	 * Get User
	 * 
	 * @param int
	 *            User Id
	 */
	public User getUserById(Long id) {

		return userDAO.getUserById(id);
	}

	/**
	 * Get User List
	 */
	public List<User> getUsers() {

		return userDAO.getUsers();
	}

	public User getuserDetail(Long id) {

		return (userDAO.getuserDetail(id));
	}

	public Long getUserIdFromEmailOrMobile(String input, CommunicationType type) {

		User user = userDAO.getUserIdFromEmailOrMobile(input, type);
		return (user.getId());
	}

	public UserProfilesResponse getParticularUsersForArea(UserProfilesRequest request, UserProfilesResponse response) {

		List<UserVO> userVOs = new ArrayList<UserVO>();
		EntityType entityType = request.getEntityType();
		String area = request.getArea();
		List<User> users =null;// userDAO.getParticularUsersForArea(entityType, area);
		for (User user : users) {
			UserVO userVO = LogicqContextProvider.getApplicationContext().getBean(UserVO.class);
			userVO = userConversion.conversionFromEntitytoVO(user, userVO);
			userVOs.add(userVO);
		}
		response.setUserVOs(userVOs);
		return response;
	}
}