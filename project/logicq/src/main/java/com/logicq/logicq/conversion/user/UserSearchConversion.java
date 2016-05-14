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
		LogicqConversion<UserSearch> votoentity = new LogicqConversion<UserSearch>();
		UserSearch usersearch=null;
		try {
			usersearch = votoentity.objectConversion(usersearchVO, UserSearch.class);
		} catch (Exception e) {
		
		}
		return usersearch;
	}

	/**
	 * 
	 * @param user
	 * @param userVO
	 * @return
	 */
	public UserSearchVO conversionFromEntitytoVO(UserSearch usersearch, UserSearchVO usersearchVO) {
		LogicqConversion<UserSearchVO> votoentity = new LogicqConversion<UserSearchVO>();
		try {
			usersearchVO = votoentity.objectConversion(usersearch, UserSearchVO.class);
		} catch (Exception e) {

		}
		return usersearchVO;
	}

}
