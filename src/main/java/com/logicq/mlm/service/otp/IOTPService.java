package com.logicq.mlm.service.otp;

public interface IOTPService {
	
	boolean sendOTP(String mobilenumber);
	
	boolean validateOTP(int otp,String mobilenumber);
	
	void sendServiceConfirmation(String mobilenumber,String reasone);

}
