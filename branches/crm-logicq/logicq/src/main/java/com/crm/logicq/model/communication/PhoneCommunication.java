package com.crm.logicq.model.communication;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.crm.logicq.constant.ContactType;


@Entity
@Table(name = "PHONE_DETAILS")
public class PhoneCommunication {
	
	@Id
	@Column(name = "MOBILE_NUMBER", unique = true, nullable = false)
	private String mobilenumber;
	
	@Column(name = "CONTACT_TYPE", nullable = true)
	@Enumerated(EnumType.STRING)
	private ContactType contactType;
	
	private boolean isActive;
	
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public ContactType getContactType() {
		return contactType;
	}
	public void setContactType(ContactType contactType) {
		this.contactType = contactType;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	@Override
	public String toString() {
		return "PhoneCommunication [mobilenumber=" + mobilenumber + ", contactType=" + contactType + ", isActive="
				+ isActive + "]";
	}
	
}
