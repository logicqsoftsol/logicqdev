package com.issuetraker.common;

public class LogicqException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8892965087690382588L;

		private String exceptionmsg;
		private String msgcode;
		private Exception excpetion;
	   
		public String getExceptionmsg() {
			return exceptionmsg;
		}

		public void setExceptionmsg(String exceptionmsg) {
			this.exceptionmsg = exceptionmsg;
		}

		public String getMsgcode() {
			return msgcode;
		}

		public void setMsgcode(String msgcode) {
			this.msgcode = msgcode;
		}

		public Exception getExcpetion() {
			return excpetion;
		}

		public void setExcpetion(Exception excpetion) {
			this.excpetion = excpetion;
		}

	public LogicqException(String msgcode, Exception exception) {
		this.msgcode = msgcode;
		this.exceptionmsg = exception.getMessage();
		this.excpetion=exception;
	}
	
	public LogicqException(String msgcode,String exceptionmsg) {
		this.msgcode = msgcode;
		this.exceptionmsg = exceptionmsg;
	}
	
	public LogicqException(String exceptionmsg) {
		this.exceptionmsg = exceptionmsg;
	}
	   
	 
	 

}
