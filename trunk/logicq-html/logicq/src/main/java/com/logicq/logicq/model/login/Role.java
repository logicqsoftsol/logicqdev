package com.logicq.logicq.model.login;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.logicq.logicq.common.ConvertClass;
import com.logicq.logicq.common.criteriamanager.BaseEntity;

@ConvertClass(enable=true)
@Entity
@Table(name = "USER_ROLES")
public class Role extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2781440756615459557L;
	@Id 
	@Column(name = "role_id", unique = true, nullable = false)
	private Long roleid;
	@Column(name = "role", unique = true, nullable = false)
	private String role;

	public Long getRoleid() {

		return roleid;
	}

	public String getRole() {

		return role;
	}

	public void setRole(String role) {

		this.role = role;
	}

	public void setRoleid(Long roleid) {

		this.roleid = roleid;
	}
	//	 @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)  
	//    @JoinTable(name="user_roles_map",  
	//    joinColumns={@JoinColumn(name="role_id")},  
	//    inverseJoinColumns={@JoinColumn(name="id", referencedColumnName="user_id")})  
	//    private List<Login> userList;
	//	public List<Login> getUserList() {
	//		return userList;
	//	}
	//	public void setUserList(List<Login> userList) {
	//		this.userList = userList;
	//	}
}
