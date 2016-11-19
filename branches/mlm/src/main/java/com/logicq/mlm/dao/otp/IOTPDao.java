package com.logicq.mlm.dao.otp;

import com.logicq.mlm.model.sms.OTPDetails;

public interface IOTPDao {
	
	void saveOrUpdateOTPDetails(OTPDetails otpdetails);
	
	boolean validateOTP(int otp,String mobilenumber);

}
