package com.logicq.logicq.ui.login.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

public class LoginVO {
		private String email;
	    private String password;
	    private Integer phonnumber;
	    private Date lastlogindate;
	    private Integer loginattempcounts;
	    private Integer ipaddress;
	    private Integer userid;
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
		public Integer getPhonnumber() {
			return phonnumber;
		}
		public void setPhonnumber(Integer phonnumber) {
			this.phonnumber = phonnumber;
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
		public void setIpaddress(Integer ipaddress) {
			this.ipaddress = ipaddress;
		}
		public Integer getUserid() {
			return userid;
		}
		public void setUserid(Integer userid) {
			this.userid = userid;
		}
	
	

}
