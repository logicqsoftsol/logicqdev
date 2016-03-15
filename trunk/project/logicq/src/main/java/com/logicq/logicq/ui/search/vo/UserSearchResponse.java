package com.logicq.logicq.ui.search.vo;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.logicq.logicq.common.LogicqHttpServletResponse;
import com.logicq.logicq.common.LogicqTransactionStatus;

public class UserSearchResponse extends LogicqHttpServletResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8594177380643791823L;
	@Autowired
	private LogicqTransactionStatus logicqTransactionStatus;

	public LogicqTransactionStatus getLogicqTransactionStatus() {

		return logicqTransactionStatus;
	}

	public void setLogicqTransactionStatus(LogicqTransactionStatus logicqTransactionStatus) {

		this.logicqTransactionStatus = logicqTransactionStatus;
	}
}
