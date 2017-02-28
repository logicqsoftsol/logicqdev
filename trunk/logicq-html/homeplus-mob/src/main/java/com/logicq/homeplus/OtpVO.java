package com.logicq.homeplus;

import java.io.Serializable;

public class OtpVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2397538735589994509L;
	
	private String mobileNumber;
	private  int otpCode;
	private boolean isOTPValidate;
	private String refrenceNumber;
	
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public int getOtpCode() {
		return otpCode;
	}
	public void setOtpCode(int otpCode) {
		this.otpCode = otpCode;
	}
	public boolean isOTPValidate() {
		return isOTPValidate;
	}
	public void setOTPValidate(boolean isOTPValidate) {
		this.isOTPValidate = isOTPValidate;
	}
	public String getRefrenceNumber() {
		return refrenceNumber;
	}
	public void setRefrenceNumber(String refrenceNumber) {
		this.refrenceNumber = refrenceNumber;
	}
	@Override
	public String toString() {
		return "OtpVO [mobileNumber=" + mobileNumber + ", otpCode=" + otpCode + ", isOTPValidate=" + isOTPValidate
				+ ", refrenceNumber=" + refrenceNumber + "]";
	}


}
