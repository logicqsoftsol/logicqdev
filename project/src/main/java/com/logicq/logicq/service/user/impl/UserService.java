package com.logicq.logicq.service.user.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.logicq.constant.CommunicationType;
import com.logicq.logicq.conversion.user.UserConversion;
import com.logicq.logicq.dao.user.IUserDAO;
import com.logicq.logicq.model.login.Login;
import com.logicq.logicq.model.user.User;
import com.logicq.logicq.service.login.IloginService;
import com.logicq.logicq.service.task.ITaskManagerService;
import com.logicq.logicq.service.user.IUserService;
import com.logicq.logicq.ui.task.vo.TaskVO;
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
@Transactional
public class UserService implements IUserService {

	@Autowired
	IUserDAO userDAO;
	@Autowired
	ITaskManagerService itaskManagerService;
	@Autowired
	IloginService loginService;

	public ITaskManagerService getItaskManagerService() {

		return itaskManagerService;
	}

	public void setItaskManagerService(ITaskManagerService itaskManagerService) {

		this.itaskManagerService = itaskManagerService;
	}

	UserConversion userConversion = UserConversion.getInstance();

	public IUserDAO getUserDAO() {

		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {

		this.userDAO = userDAO;
	}

	/**
	 * Add User
	 * 
	 * @param User
	 *            user
	 */
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
			//Calling to task service for verify document
			TaskVO l_task = new TaskVO();
			l_task.setDescription("hardcode");
			l_task.setName("sudhanshu");
			l_task.setStatus("test");
			l_task.setPriority("High");
			itaskManagerService.addTask(l_task);
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

		return (getUserDAO().getuserDetail(id));
	}

	public Long getUserIdFromEmailOrMobile(String input, CommunicationType type) {

		User user = getUserDAO().getUserIdFromEmailOrMobile(input, type);
		return (user.getId());
	}
}