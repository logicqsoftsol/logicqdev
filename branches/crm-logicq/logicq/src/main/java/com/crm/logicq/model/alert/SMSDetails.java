package com.crm.logicq.model.alert;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.crm.logicq.constant.ContactType;
import com.crm.logicq.constant.SMSType;

@Entity
@Table(name = "SMSDETAILS")
public class SMSDetails implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5128579721058235062L;
    @Id
	@Column(name = "MOBILE_NUMBER", nullable = false)
	private String mobileNumber;
	
	@Column(name = "CONTACT_TYPE", nullable = false)
	@Enumerated(EnumType.STRING)
	private ContactType contactType;
	
	@Column(name = "SMS_TYPE", nullable = false)
	@Enumerated(EnumType.STRING)
	private SMSType smsType;
	
	@Column(name = "IN_TIME", nullable = true)
	private Integer intime;
	
	@Column(name = "OUT_TIME", nullable = true)
	private Integer outtime;
	
	@Column(name = "COMMENTS", nullable = true)
	private String comments;
	
	@Column(name = "TEXT", nullable = true)
	private String text;
	
	@Column(name = "SMS_DATE", nullable = true)
	private Date smsdate;
	
	@Column(name = "FIRST_NAME", nullable = true)
	private String firstName;
	
	@Column(name = "LAST_NAME", nullable = true)
	private String lastName;
	
	
	public SMSType getSmsType() {
		return smsType;
	}
	public void setSmsType(SMSType smsType) {
		this.smsType = smsType;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public ContactType getContactType() {
		return contactType;
	}
	public void setContactType(ContactType contactType) {
		this.contactType = contactType;
	}
	
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getSmsdate() {
		return smsdate;
	}
	public void setSmsdate(Date smsdate) {
		this.smsdate = smsdate;
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
	public Integer getIntime() {
		return intime;
	}
	public void setIntime(Integer intime) {
		this.intime = intime;
	}
	public Integer getOuttime() {
		return outtime;
	}
	public void setOuttime(Integer outtime) {
		this.outtime = outtime;
	}
	@Override
	public String toString() {
		return "SMSDetails [mobileNumber=" + mobileNumber + ", contactType=" + contactType + ", smsType=" + smsType
				+ ", intime=" + intime + ", outtime=" + outtime + ", comments=" + comments + ", text=" + text
				+ ", smsdate=" + smsdate + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
	
	
}
