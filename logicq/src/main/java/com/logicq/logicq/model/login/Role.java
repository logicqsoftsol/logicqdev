package com.logicq.logicq.model.login;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ROLES")
public class Role {

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
