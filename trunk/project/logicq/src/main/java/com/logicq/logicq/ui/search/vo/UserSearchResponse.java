package com.logicq.logicq.ui.search.vo;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.logicq.logicq.common.LogicqHttpServletResponse;
import com.logicq.logicq.common.LogicqTransactionStatus;
import com.logicq.logicq.ui.user.vo.UserVO;

public class UserSearchResponse extends LogicqHttpServletResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8594177380643791823L;
	
	@Autowired
	private LogicqTransactionStatus logicqTransactionStatus;
	
	private List<UserVO> userlist;

	public List<UserVO> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<UserVO> userlist) {
		this.userlist = userlist;
	}

	public LogicqTransactionStatus getLogicqTransactionStatus() {

		return logicqTransactionStatus;
	}

	public void setLogicqTransactionStatus(LogicqTransactionStatus logicqTransactionStatus) {

		this.logicqTransactionStatus = logicqTransactionStatus;
	}
}
