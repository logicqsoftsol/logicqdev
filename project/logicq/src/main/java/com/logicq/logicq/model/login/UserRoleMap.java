package com.logicq.logicq.model.login;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="USER_ROLES_MAP")
public class UserRoleMap {
	@Column(name="user_id", nullable = false)
	private int userid;
	
	@Column(name="role_id", nullable = false)
	private int roleid;
	
    public int getUserid() {
    
    	return userid;
    }
	
    public void setUserid(int userid) {
    
    	this.userid = userid;
    }
	
    public int getRoleid() {
    
    	return roleid;
    }
	
    public void setRoleid(int roleid) {
    
    	this.roleid = roleid;
    }
	
}


/**
NIHAR
18-Jan-2016
1:38:06 am
*/