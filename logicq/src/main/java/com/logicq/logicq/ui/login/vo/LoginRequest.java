package com.logicq.logicq.ui.login.vo;

import java.io.Serializable;

import com.logicq.logicq.common.LogicqHttpServletRequest;
import com.logicq.logicq.ui.task.vo.TaskVO;

public class LoginRequest extends LogicqHttpServletRequest implements Serializable{

	public LoginVO loginVO;
	public TaskVO taskVO;
    
	public TaskVO getTaskVO() {
		return taskVO;
	}

	public void setTaskVO(TaskVO taskVO) {
		this.taskVO = taskVO;
	}

	public LoginVO getLoginVO() {
		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}

}

/**
 * NIHAR 07-Jan-2016 1:53:11 am
 */
