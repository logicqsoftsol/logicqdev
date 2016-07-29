package com.crm.logicq.model.alert;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @Column(name = "ID",unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "MOBILE_NUMBER", nullable = false)
	private String mobileNumber;
	

	@Column(name = "SMS_TYPE", nullable = false)
	@Enumerated(EnumType.STRING)
	private SMSType type;
	
	@Column(name = "STATUS_CODE", nullable = true)
	private String statuscode;
	
	@Column(name = "TEXT", nullable = true)
	private String text;
	
	@Column(name = "SMS_DATE", nullable = true)
	private Date smsdate;
	
	@Column(name = "SMS_STATUS", nullable = true)
	private String status;

	
	
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public SMSType getType() {
		return type;
	}

	public void setType(SMSType type) {
		this.type = type;
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

	public String getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(String statuscode) {
		this.statuscode = statuscode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "SMSDetails [id=" + id + ", mobileNumber=" + mobileNumber + ", type=" + type + ", statuscode="
				+ statuscode + ", text=" + text + ", smsdate=" + smsdate + ", status=" + status + "]";
	}

	

	
}
