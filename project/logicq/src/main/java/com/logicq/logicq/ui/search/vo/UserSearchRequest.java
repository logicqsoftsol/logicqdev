package com.logicq.logicq.ui.search.vo;

import java.io.Serializable;
import java.util.List;

import com.logicq.logicq.common.LogicqHttpServletRequest;
import com.logicq.logicq.ui.user.vo.UserVO;

public class UserSearchRequest extends LogicqHttpServletRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6099241235870597440L;
	
	private UserSearchVO userSearchVO;
	private List<UserVO> userlist;

	public UserSearchVO getUserSearchVO() {
		return userSearchVO;
	}

	public void setUserSearchVO(UserSearchVO userSearchVO) {
		this.userSearchVO = userSearchVO;
	}
	
	public List<UserVO> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<UserVO> userlist) {
		this.userlist = userlist;
	}
}
