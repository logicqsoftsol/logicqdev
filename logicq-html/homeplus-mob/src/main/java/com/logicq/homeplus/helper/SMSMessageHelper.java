package com.logicq.homeplus.helper;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormatter;

public class SMSMessageHelper {
	 private static final String DATE_FORMAT = "dd-MM-yyyy hh:mm";
	 private static SecureRandom random = new SecureRandom();

	 
	public static String generateOTPMessage(int otp) {

		return " Your OTP is " + otp + "\n" + "\n" + " Your Service Patner " + "\n" + "HomePlus Service";
	}

	public static String generateMessageForServiceRequest(String servicename) {
		DateTimeZone timeZone = DateTimeZone.forID( "Asia/Kolkata" );
        LocalDateTime dateTime=LocalDateTime.now(timeZone);
        SimpleDateFormat dateFormat=new SimpleDateFormat(DATE_FORMAT);
		String date=dateFormat.format(dateTime.toDate());
        return "Dear Sir/Madam, We have recived your "+servicename+" order   on date : "+date+". Your service patner HomePlus Service,BLS";
	}

	public static String generateMessageForAdmin(String mobilenumber,String servicename, Date serviceDate,String serviceTime) {
		return "Dear Admin , Customer "+mobilenumber+" request for service "+servicename+" for service date : "+serviceDate+" and service time : "+serviceTime;
	}
	

	public static String generateMessageForOTPRequest(String otp) {
		   return " Your OTP Code  "+otp+" for mobile number verification .Your service patner HomePlus Service,BLS";
	}
	
	public static int generateOTP() {
		Random r = new Random( System.currentTimeMillis() );
	    int otp=((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
	    return otp;
	}
	
	 public static String nextRefrenceNumber() {
		    return new BigInteger(30, random).toString();
		  }
}
