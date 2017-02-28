package com.logicq.homeplus.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "OTP_DETAIL")
public class OTPDetails implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8319479465268667179L;

	@EmbeddedId
	private OTPKey  key;
	
	
	@Column(name = "IS_VALIDATE", nullable = false)
	private boolean otpvalidate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "VALIDATION_DATE", nullable = true)
	private Date otpvalidationdate;

	public OTPKey getKey() {
		return key;
	}

	public void setKey(OTPKey key) {
		this.key = key;
	}

	public boolean isOtpvalidate() {
		return otpvalidate;
	}

	public void setOtpvalidate(boolean otpvalidate) {
		this.otpvalidate = otpvalidate;
	}

	public Date getOtpvalidationdate() {
		return otpvalidationdate;
	}

	public void setOtpvalidationdate(Date otpvalidationdate) {
		this.otpvalidationdate = otpvalidationdate;
	}

	@Override
	public String toString() {
		return "OTPDetails [key=" + key + ", otpvalidate=" + otpvalidate + ", otpvalidationdate=" + otpvalidationdate
				+ "]";
	}
	

	
	
}
