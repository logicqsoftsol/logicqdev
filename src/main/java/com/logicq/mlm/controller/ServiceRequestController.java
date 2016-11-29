package com.logicq.mlm.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.logicq.mlm.model.message.EmailDetails;
import com.logicq.mlm.model.sms.OTPDetails;
import com.logicq.mlm.service.messaging.IEmailService;
import com.logicq.mlm.service.otp.IOTPService;
import com.logicq.mlm.service.user.IUserService;

@RestController
@RequestMapping("/admin/service")
public class ServiceRequestController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(ServiceRequestController.class);
	
	@Autowired
	IEmailService emailservice;
	
	@Autowired
	IOTPService otpservice;
	


	
	
	@RequestMapping(value = "/otpSend", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> sendOTP(@RequestBody OTPDetails otpdetails) throws Exception {
		
		if(!StringUtils.isEmpty(otpdetails.getReciveremailid())){
			EmailDetails emaildetail=new EmailDetails();
			emaildetail.setSenddate(new Date());
			emaildetail.setSendto(otpdetails.getReciveremailid());
			emailservice.sendEmail(emaildetail);
		}
		if(!StringUtils.isEmpty(otpdetails.getMobilenumber())){
			otpservice.sendOTP(otpdetails.getMobilenumber());
		}

	
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/otpValidateForMobileNumber", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> validateOTPForMobilenumber(@RequestBody OTPDetails otpdetails) throws Exception {
		otpservice.validateOTPForMobile(otpdetails.getOtpnumber(), otpdetails.getMobilenumber());
		//if OTP true check for pending approval if not than fetch details of logined user
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/otpValidateForEmail", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> validateOTPForEmail(@RequestBody OTPDetails otpdetails) throws Exception {
		otpservice.validateOTPForEMail(otpdetails.getOtpnumber(), otpdetails.getReciveremailid());
		//if OTP true check for pending approval if not than fetch details of logined user
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

}
