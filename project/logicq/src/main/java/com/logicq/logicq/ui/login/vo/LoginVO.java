package com.logicq.logicq.ui.login.vo;

import java.util.Date;

public class LoginVO {

	private String email;
	private String password;
	private String phonnumber;
	private Date lastlogindate;
	private Integer loginattempcounts;
	private Integer ipaddress;
	private Long userid;

	public String getEmail() {

		return email;
	}

	public void setEmail(String email) {

		this.email = email;
	}

	public String getPassword() {

		return password;
	}

	public void setPassword(String password) {

		this.password = password;
	}

	public Date getLastlogindate() {

		return lastlogindate;
	}

	public void setLastlogindate(Date lastlogindate) {

		this.lastlogindate = lastlogindate;
	}

	public Integer getLoginattempcounts() {

		return loginattempcounts;
	}

	public void setLoginattempcounts(Integer loginattempcounts) {

		this.loginattempcounts = loginattempcounts;
	}

	public Integer getIpaddress() {

		return ipaddress;
	}

	public String getPhonnumber() {

		return phonnumber;
	}

	public void setPhonnumber(String phonnumber) {

		this.phonnumber = phonnumber;
	}

	public Long getUserid() {

		return userid;
	}

	public void setUserid(Long userid) {

		this.userid = userid;
	}

	public void setIpaddress(Integer ipaddress) {

		this.ipaddress = ipaddress;
	}
}
