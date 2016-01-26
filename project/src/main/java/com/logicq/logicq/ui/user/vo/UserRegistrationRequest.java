package com.logicq.logicq.ui.user.vo;

import java.io.Serializable;

import com.logicq.logicq.common.LogicqHttpServletRequest;
import com.logicq.logicq.ui.task.vo.TaskVO;

public class UserRegistrationRequest extends LogicqHttpServletRequest implements Serializable {

	/**
	 * serial version uid
	 */
	private static final long serialVersionUID = 226240580370577359L;
	private UserVO userVO;
	public TaskVO taskVO;

	public TaskVO getTaskVO() {

		return taskVO;
	}

	public void setTaskVO(TaskVO taskVO) {

		this.taskVO = taskVO;
	}

	public UserVO getUserVO() {

		return userVO;
	}

	public void setUserVO(UserVO userVO) {

		this.userVO = userVO;
	}
}
