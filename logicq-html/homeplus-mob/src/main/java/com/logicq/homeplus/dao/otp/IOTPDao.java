package com.logicq.homeplus.dao.otp;

import com.logicq.homeplus.model.OTPDetails;

public interface IOTPDao {
	
	void saveOrUpdateOTPDetails(OTPDetails otpdetails);
	OTPDetails  validateOTPForMobileNumber(int otp,String mobilenumber);
	

}
