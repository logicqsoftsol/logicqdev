package com.logicq.logicq.service.user.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.logicq.logicq.common.LogicqContextProvider;
import com.logicq.logicq.constant.AlertType;
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
import com.logicq.logicq.ui.alert.vo.AlertDetailsInputVO;
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

	final static Logger logger = Logger.getLogger(UserService.class);
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
	public UserVO addUser(UserVO userRequest) {

		UserVO userVO = userRequest;
		Boolean isUserValid = validateUser(userVO);
		if (isUserValid) {
			User user = userConversion.conversionFromVOtoEntity(userVO, User.class);
			userDAO.addUser(user);
			//insert into login table
			Login loginDetails = setLoginDetails(user);
			loginService.insertLoginDetails(loginDetails);
			//build alert DTO
			AlertDetailsInputVO alertDetailsInputVO = new AlertDetailsInputVO();
			alertDetailsInputVO = buildAlertDetails(user,
			                                        alertDetailsInputVO,
			                                        "com.logicq.logicq.service.user.impl.UserService.addUser(UserRegistrationRequest, UserRegistrationResponse)");
			//call to email sending service.
			alertService.sendAlert(alertDetailsInputVO);
		} else {
			logger.info(" user already exist : uservalidation " + isUserValid);
		}
		return userVO;
	}

	private AlertDetailsInputVO buildAlertDetails(User user, AlertDetailsInputVO alertDetailsInputVO, String serviceId) {

		String emailId = user.getEmailId();
		Random ran = new Random();
		int max = 999999;
		int min = 100000;
		int bound = ((max - min) + 1);
		int randomNo = ran.nextInt(bound) + min;
		Map<String, Object> nameValuePair = new HashMap<String, Object>();
		nameValuePair.put("emailId", emailId);
		nameValuePair.put("subject", "OTP for your new Account Creation");
		nameValuePair.put("otpValue", String.valueOf(randomNo));
		alertDetailsInputVO.setAlertType(AlertType.EMAIL);
		alertDetailsInputVO.setNameValuePair(nameValuePair);
		alertDetailsInputVO.setServiceId(serviceId);
		alertDetailsInputVO.setUserId(user.getId());
		return alertDetailsInputVO;
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

		Boolean isNewEmail = checkEmail(userVO.getEmailId());
		Boolean isNewMobileNo = checkMobileNo(userVO.getMobileno());
		return (isNewEmail && isNewMobileNo);
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

		User l_userentity = userConversion.conversionFromVOtoEntity(user, User.class);
		userDAO.deleteUser(l_userentity);
	}

	/**
	 * Update User
	 * 
	 * @param User
	 *            user
	 */
	public void updateUser(UserVO user) {

		User l_userentity = userConversion.conversionFromVOtoEntity(user, User.class);
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

	public UserVO getParticularUsersForArea(UserVO request) {

		List<UserVO> userVOs = new ArrayList<UserVO>();
		EntityType entityType = request.getEntityType();
		//String area = request.getArea();
		List<User> users = null;// userDAO.getParticularUsersForArea(entityType, area);
		for (User user : users) {
			UserVO userVO = LogicqContextProvider.getApplicationContext().getBean(UserVO.class);
			userVO = userConversion.conversionFromEntitytoVO(user, userVO);
			userVOs.add(userVO);
		}
		return request;
	}
}