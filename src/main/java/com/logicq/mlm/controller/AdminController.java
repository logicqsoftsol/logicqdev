package com.logicq.mlm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.logicq.mlm.model.sms.OTPDetails;
import com.logicq.mlm.model.sms.ServiceDetails;
import com.logicq.mlm.service.otp.IServiceRequestService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	

	
	@Autowired
	IServiceRequestService servicerequestservice;
	
	
	@RequestMapping(value = "/generateotp/{mobilenumber}", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> generateOTP(@PathVariable String mobilenumber) throws Exception {
		//otpservice.sendOTP(mobilenumber);
		return new ResponseEntity<String>(mobilenumber, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/requestservice", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceDetails> userRegister(@RequestBody ServiceDetails servicedetails) throws Exception {
		try {
//			if (otpservice.sendOTP(servicedetails.getCustomermob())) {
//				servicerequestservice.saveorUpdateRequest(servicedetails);
//			}
		} catch (Exception ex) {
			return new ResponseEntity<ServiceDetails>(servicedetails, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<ServiceDetails>(servicedetails, HttpStatus.OK);
	}

	

	@RequestMapping(value = "/validateOTP/{servicename}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> userRegister(@RequestBody OTPDetails otpdetails, @PathVariable String servicename)
			throws Exception {
		Boolean isotpvalidate = false;
		try {
//			if (otpservice.validateOTP(otpdetails.getOtpnumber(), otpdetails.getMobilenumber())) {
//				otpservice.sendServiceConfirmation(otpdetails.getMobilenumber(), servicename);
//			} else {
//				return new ResponseEntity<Boolean>(isotpvalidate, HttpStatus.BAD_REQUEST);
//			}
		} catch (Exception ex) {
			return new ResponseEntity<Boolean>(isotpvalidate, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Boolean>(isotpvalidate, HttpStatus.OK);
	}
	
}
