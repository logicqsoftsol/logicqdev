package com.logicq.logicq.ui.user.vo;

import java.io.Serializable;

import com.logicq.logicq.common.LogicqTransactionStatus;

public class UserRegistrationResponse  implements Serializable {

	/**
	 * serial version uid
	 */
	private static final long serialVersionUID = 2166814370618487115L;

	private LogicqTransactionStatus logicqTransactionStatus;

	public LogicqTransactionStatus getLogicqTransactionStatus() {

		return logicqTransactionStatus;
	}

	public void setLogicqTransactionStatus(LogicqTransactionStatus logicqTransactionStatus) {

		this.logicqTransactionStatus = logicqTransactionStatus;
	}
}
