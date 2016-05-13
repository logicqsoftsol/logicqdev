package com.logicq.logicq.ui.login.vo;

import java.io.Serializable;

import com.logicq.logicq.common.LogicqTransactionStatus;

public class LoginResponse  implements Serializable {

	
	private LogicqTransactionStatus logicqTransactionStatus;

	public LogicqTransactionStatus getLogicqTransactionStatus() {

		return logicqTransactionStatus;
	}

	public void setLogicqTransactionStatus(LogicqTransactionStatus logicqTransactionStatus) {

		this.logicqTransactionStatus = logicqTransactionStatus;
	}

	private static final long serialVersionUID = 4815830332720854968L;
	public LoginVO loginVO;

	public LoginVO getLoginVO() {

		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {

		this.loginVO = loginVO;
	}
}
/**
 * NIHAR 07-Jan-2016 1:53:40 am
 */