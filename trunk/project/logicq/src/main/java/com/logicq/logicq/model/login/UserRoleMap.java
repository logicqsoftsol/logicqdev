package com.logicq.logicq.model.login;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.logicq.logicq.common.criteriamanager.BaseEntity;

@Entity
@Table(name="USER_ROLES_MAP")
public class UserRoleMap extends BaseEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2853249268915521274L;
    @Id
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