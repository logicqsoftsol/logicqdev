package com.logicq.logicq.ui.user.vo;

import java.io.Serializable;

import com.logicq.logicq.common.ConvertClass;

@ConvertClass(enable=true)
public class RoleVO implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 8292094341328057739L;

	private Long roleid;
	
	private String role;

	public Long getRoleid() {
		return roleid;
	}

	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
