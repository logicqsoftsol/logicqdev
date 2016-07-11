package com.crm.logicq.vo.user;

import java.util.Date;

public class BasicRegistrationVO{
	
	private String id;
	
	private String name;
	
	private Date date;
	
	private String type;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "EmployeeVO [id=" + id + ", name=" + name + ", date=" + date + ", type=" + type + "]";
	}
	
	

}
