package com.logicq.homeplus.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class OTPKey implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -8190795026188528215L;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATION_DATE", nullable = true)
	private Date creationdate;
	
	@Column(name = "OTP_NUMBER", nullable = false)
	private Integer otpnumber;
	
	@Column(name = "MOBILE_NUMBER", nullable = false)
	private String mobilenumber;

	public Date getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

	public Integer getOtpnumber() {
		return otpnumber;
	}

	public void setOtpnumber(Integer otpnumber) {
		this.otpnumber = otpnumber;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	@Override
	public String toString() {
		return "OTPKey [creationdate=" + creationdate + ", otpnumber=" + otpnumber + ", mobilenumber=" + mobilenumber
				+ "]";
	}


}
