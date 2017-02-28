package com.logicq.homeplus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SMS_DETAIL")
public class SMSDetails {
	
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "MOBILE_NUMBER", nullable = true)
	private String mobilenumber;
	
	@Column(name = "MSG_SERVICE", nullable = true)
	private String msgreasone;
	
	@Column(name = "MESSAGE", nullable = true)
	private String message;
	
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getMsgreasone() {
		return msgreasone;
	}
	public void setMsgreasone(String msgreasone) {
		this.msgreasone = msgreasone;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "SMSDetails [id=" + id + ", mobilenumber=" + mobilenumber + ", msgreasone=" + msgreasone + ", message="
				+ message + "]";
	}
	
	
}
