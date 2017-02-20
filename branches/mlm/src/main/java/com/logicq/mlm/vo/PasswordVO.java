package com.logicq.mlm.vo;

import java.io.Serializable;

public class PasswordVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4019734399821601762L;
	
	private String oldpassword;
	private String newPassword;
	private String confirmPasword;
	private String date;
	public String getOldpassword() {
		return oldpassword;
	}
	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getConfirmPasword() {
		return confirmPasword;
	}
	public void setConfirmPasword(String confirmPasword) {
		this.confirmPasword = confirmPasword;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
