package com.logicq.logicq.conversion.user;

import org.apache.log4j.Logger;

import com.logicq.logicq.common.LogicqConversion;
import com.logicq.logicq.model.user.User;
import com.logicq.logicq.model.user.UserSearch;
import com.logicq.logicq.ui.search.vo.UserSearchVO;
import com.logicq.logicq.ui.user.vo.UserVO;

public class UserSearchConversion {
	
	final static Logger logger = Logger.getLogger(UserSearchConversion.class);
	
	private static UserSearchConversion instance;

	public static UserSearchConversion getInstance() {

		if (null == instance) {
			instance = new UserSearchConversion();
		}
		return instance;
	}

	/*
	 * 
	 */
	public UserSearch conversionFromVOtoEntity(UserSearchVO usersearchVO, Class claz) {
		return (UserSearch) LogicqConversion.objectConversion(usersearchVO, UserSearch.class);
	}

	/**
	 * 
	 * @param user
	 * @param userVO
	 * @return
	 */
	public UserSearchVO conversionFromEntitytoVO(UserSearch usersearch, UserSearchVO usersearchVO) {
			usersearchVO = (UserSearchVO) LogicqConversion.objectConversion(usersearch, UserSearchVO.class);
		return usersearchVO;
	}

}
