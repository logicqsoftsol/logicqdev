package com.logicq.commonproject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTENT_DETAILS")
public class ContentDetails implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8460558880785591129L;

	@Id
	@Column(name = "CONTENT_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@Column(name = "CONTENT_FOR", nullable = true)
	private String name;
	
	@Column(name = "CONTENT_TYPE", nullable = true)
	private String type;
	
	@Column(name = "CONTENT_VALUE", nullable = true)
	private String value;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "ContentDetails [id=" + id + ", name=" + name + ", type=" + type + ", value=" + value + "]";
	}
	
	
	

}
