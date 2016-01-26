
package com.logicq.logicq.model.user;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.logicq.logicq.model.login.Role;

public class UserDTO {

	private int id;
	private String firstName;
	private String lastName;
	private String gender;
	private String mobileNo;
	private String emailId;
	private String dateOfBirth;
	private String password;
	
    public int getId() {
    
    	return id;
    }
	
    public void setId(int id) {
    
    	this.id = id;
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
	
    public String getGender() {
    
    	return gender;
    }
	
    public void setGender(String gender) {
    
    	this.gender = gender;
    }
	
    public String getMobileNo() {
    
    	return mobileNo;
    }
	
    public void setMobileNo(String mobileNo) {
    
    	this.mobileNo = mobileNo;
    }
	
    public String getEmailId() {
    
    	return emailId;
    }
	
    public void setEmailId(String emailId) {
    
    	this.emailId = emailId;
    }
	
    public String getDateOfBirth() {
    
    	return dateOfBirth;
    }
	
    public void setDateOfBirth(String dateOfBirth) {
    
    	this.dateOfBirth = dateOfBirth;
    }
	
    public String getPassword() {
    
    	return password;
    }
	
    public void setPassword(String password) {
    
    	this.password = password;
    }
	
    public Boolean getIsMobileVerified() {
    
    	return isMobileVerified;
    }
	
    public void setIsMobileVerified(Boolean isMobileVerified) {
    
    	this.isMobileVerified = isMobileVerified;
    }
	
    public Boolean getIsEmailVerified() {
    
    	return isEmailVerified;
    }
	
    public void setIsEmailVerified(Boolean isEmailVerified) {
    
    	this.isEmailVerified = isEmailVerified;
    }
	
    public Boolean getIsUserVerified() {
    
    	return isUserVerified;
    }
	
    public void setIsUserVerified(Boolean isUserVerified) {
    
    	this.isUserVerified = isUserVerified;
    }
	
    public Role getRole() {
    
    	return role;
    }
	
    public void setRole(Role role) {
    
    	this.role = role;
    }
	private Boolean isMobileVerified;
	private Boolean isEmailVerified;
	private Boolean isUserVerified;
	private Role role;
}
/**
 * NIHAR 18-Jan-2016 12:55:38 am
 */
