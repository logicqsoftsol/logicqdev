package com.logicq.logicq.ui.user.vo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.logicq.logicq.common.ConvertClass;

@ConvertClass(enable=true)
public class BasicUserVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4568463902972085039L;

	@NotNull
	private String email;
	
	@NotNull
	private String phone;
	
	@NotNull
	private String name;
	
	@NotNull
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "BasicUserVO [email=" + email + ", phone=" + phone + ", name=" + name + ", password=" + password + "]";
	}
	
	

}
