package com.logicq.commonproject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * NIHAR 15-Oct-2016 6:09:24 pm
 */
@Entity
@Table(name = "LOGIN_USER")
public class Login implements Serializable{
private static final long serialVersionUID = -2967666181595376776L;
	
	@Id
	@Column(name = "LOGIN_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "USERNAME", nullable = true)
	private String username;

	@Column(name = "PASSWORD", nullable = true)
	private String password;

	
    public String getUsername() {
    
    	return username;
    }

	
    public void setUsername(String username) {
    
    	this.username = username;
    }

	
    public String getPassword() {
    
    	return password;
    }

	
    public void setPassword(String password) {
    
    	this.password = password;
    }
 
}
 
