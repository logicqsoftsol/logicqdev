package com.logicq.logicq.model.task;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.logicq.logicq.common.criteriamanager.BaseEntity;
import com.logicq.logicq.model.login.LoginConstant;

@Entity
@Table(name = "TASK")
public class Task extends BaseEntity implements TaskConstant,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5273602336692056432L;
	@Id
    @Column(name="ID", unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="NAME", unique = true, nullable = false)
	private String name;
	@Column(name="DESCRIPTION", unique = true, nullable = false)
	private String description;
	
	@Column(name="PRIORITY", unique = true, nullable = false)
	private String priority;
	
	@Column(name="STATUS", unique = true, nullable = false)
	private String status;
	
	@Column(name="USERID", unique = true, nullable = false)
	private String userid;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	 
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	 
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	 
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}
