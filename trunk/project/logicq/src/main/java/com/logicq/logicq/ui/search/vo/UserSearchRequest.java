package com.logicq.logicq.ui.search.vo;

import java.io.Serializable;

import com.logicq.logicq.common.LogicqHttpServletRequest;

public class UserSearchRequest extends LogicqHttpServletRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6099241235870597440L;
	private UserSearchVO userSearchVO;

	public UserSearchVO getUserSearchVO() {

		return userSearchVO;
	}

	public void setUserSearchVO(UserSearchVO userSearchVO) {

		this.userSearchVO = userSearchVO;
	}
}
