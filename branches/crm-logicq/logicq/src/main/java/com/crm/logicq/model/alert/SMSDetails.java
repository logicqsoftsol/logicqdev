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
	private SMSType type;
	
	@Column(name = "COMMENTS", nullable = true)
	private String comments;
	
	@Column(name = "TEXT", nullable = true)
	private String text;
	
	@Column(name = "SMS_DATE", nullable = true)
	private Date smsdate;
	
	@Column(name = "SMS_STATUS", nullable = true)
	private boolean status;

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

	public SMSType getType() {
		return type;
	}

	public void setType(SMSType type) {
		this.type = type;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "SMSDetails [mobileNumber=" + mobileNumber + ", contactType=" + contactType + ", type=" + type
				+ ", comments=" + comments + ", text=" + text + ", smsdate=" + smsdate + ", status=" + status + "]";
	}
	
	
	
	
}
