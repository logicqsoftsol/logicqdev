package com.logicq.logicq.conversion.user;

import org.apache.log4j.Logger;

import com.logicq.logicq.common.LogicqConversion;
import com.logicq.logicq.model.user.User;
import com.logicq.logicq.ui.user.vo.UserVO;

public class UserConversion {

	final static Logger logger = Logger.getLogger(UserConversion.class);
	
	private static UserConversion instance;

	public static UserConversion getInstance() {

		if (null == instance) {
			instance = new UserConversion();
		}
		return instance;
	}

	/*
	 * 
	 */
	public User conversionFromVOtoEntity(UserVO userVO, Class claz) {
		LogicqConversion<User> votoentity = new LogicqConversion<User>();
		User user=null;
		try {
			user = votoentity.objectConversion(userVO, User.class);
		} catch (Exception e) {
		
		}
		return user;
	}

	/**
	 * 
	 * @param user
	 * @param userVO
	 * @return
	 */
	public UserVO conversionFromEntitytoVO(User user, UserVO userVO) {
		LogicqConversion<UserVO> votoentity = new LogicqConversion<UserVO>();
		try {
			userVO = votoentity.objectConversion(user, UserVO.class);
		} catch (Exception e) {

		}
		return userVO;
	}
}
