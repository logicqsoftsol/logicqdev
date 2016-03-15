package com.logicq.logicq.model.login;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.logicq.logicq.common.criteriamanager.BaseEntity;

@Entity
@Table(name = "LOGIN")
public class Login extends BaseEntity implements LoginConstant,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6797621025593128500L;
	@Id
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	@Column(name = "password", unique = true, nullable = false)
	private String password;
	@Column(name = "phonnumber", unique = true, nullable = false)
	private String phonnumber;
	@Column(name = "lastlogindate", unique = true, nullable = false)
	private Date lastlogindate;
	@Column(name = "loginattempcounts", nullable = true)
	private Integer loginattempcounts;
	@Column(name = "ipaddress", unique = true, nullable = false)
	private String ipaddress;
	@Column(name = "userid", unique = true, nullable = false)
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


	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
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

	@Override
	public String toString() {

		return "Login [email="
		       + email
		       + ", password="
		       + password
		       + ", phonnumber="
		       + phonnumber
		       + ", lastlogindate="
		       + lastlogindate
		       + ", loginattempcounts="
		       + loginattempcounts
		       + ", ipaddress="
		       + ipaddress
		       + ", userid="
		       + userid
		       + "]";
	}
}
