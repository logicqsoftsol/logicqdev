package com.crm.logicq.vo.user;

import com.crm.logicq.constant.EntityType;

public class UserVO {

	private String idetificationid;

	private String userid;

	private String firstName;

	private String lastName;

	private String mobilenumber;

	private String email;

	private String gender;

	private EntityType entityType;
	
	private String name;
	

	
	public String getIdetificationid() {
		return idetificationid;
	}
	public void setIdetificationid(String idetificationid) {
		this.idetificationid = idetificationid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public EntityType getEntityType() {
		return entityType;
	}
	public void setEntityType(EntityType entityType) {
		this.entityType = entityType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return "UserVO [idetificationid=" + idetificationid + ", userid=" + userid + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", mobilenumber=" + mobilenumber + ", email=" + email + ", gender="
				+ gender + ", entityType=" + entityType + ", name=" + name + "]";
	}



	
	

}
