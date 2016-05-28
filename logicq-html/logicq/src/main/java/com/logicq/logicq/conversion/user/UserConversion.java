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
		return (User) LogicqConversion.objectConversion(userVO, User.class);
	}

	/**
	 * 
	 * @param user
	 * @param userVO
	 * @return
	 */
	public UserVO conversionFromEntitytoVO(User user, Class claz) {

		return (UserVO) LogicqConversion.objectConversion(user, UserVO.class);
	}
}
