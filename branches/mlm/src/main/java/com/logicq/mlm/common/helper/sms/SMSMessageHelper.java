package com.logicq.mlm.common.helper.sms;

public class SMSMessageHelper {
	
	public static String generateOTPMessage(int otp) {

		return " Your OTP is " + otp + "\n" + "\n" + " Your Service Patner " + "\n" + "HomePlus Service";
	}

	public static String generateMessageForServiceConfirmation(String servicename) {

		return " Thanks for your " + servicename + " service request We will get back to you soon" + "\n" + "\n"
				+ " Your Service Patner " + "\n" + "HomePlus Service ";
	}

	public static String generateMessageForAdmin(String mobilenumber,String servicename) {
		return " Customer "+mobilenumber+" request for service "+servicename;
	}
	
	public static String getAdminMobileNumber() {
		return "07873735566";
	}
	
}
