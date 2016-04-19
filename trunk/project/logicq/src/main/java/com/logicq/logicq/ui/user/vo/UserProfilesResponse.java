package com.logicq.logicq.ui.user.vo;

import java.io.Serializable;
import java.util.List;

import com.logicq.logicq.common.LogicqHttpServletResponse;

public class UserProfilesResponse extends LogicqHttpServletResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<UserVO> userVOs;

	public List<UserVO> getUserVOs() {

		return userVOs;
	}

	public void setUserVOs(List<UserVO> userVOs) {

		this.userVOs = userVOs;
	}
}
