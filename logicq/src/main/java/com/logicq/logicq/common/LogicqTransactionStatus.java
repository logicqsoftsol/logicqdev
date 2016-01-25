 
package com.logicq.logicq.common;

import java.util.Map;

import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;

public class LogicqTransactionStatus implements TransactionStatus {
	
	private Integer navigationcode;
	
	private Map<Integer,String> messagecode;
	public Map<Integer, String> getMessagecode() {
		return messagecode;
	}

	public void setMessagecode(Map<Integer, String> messagecode) {
		this.messagecode = messagecode;
	}

	public LogicqException getException() {
		return exception;
	}

	public void setException(LogicqException exception) {
		this.exception = exception;
	}

	private LogicqException exception; 
	
	public Integer getNavigationcode() {
		return navigationcode;
	}

	public void setNavigationcode(Integer navigationcode) {
		this.navigationcode = navigationcode;
	}

	public Object createSavepoint() throws TransactionException {
		// TODO Auto-generated method stub
		return null;
	}

	public void rollbackToSavepoint(Object savepoint)
			throws TransactionException {
		// TODO Auto-generated method stub
		
	}

	public void releaseSavepoint(Object savepoint) throws TransactionException {
		// TODO Auto-generated method stub
		
	}

	public boolean isNewTransaction() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean hasSavepoint() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setRollbackOnly() {
		// TODO Auto-generated method stub
		
	}

	public boolean isRollbackOnly() {
		// TODO Auto-generated method stub
		return false;
	}

	public void flush() {
		// TODO Auto-generated method stub
		
	}

	public boolean isCompleted() {
		// TODO Auto-generated method stub
		return false;
	}


}


/**
NIHAR
07-Jan-2016
1:34:22 am
*/