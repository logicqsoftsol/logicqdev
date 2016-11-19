package com.logicq.mlm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.logicq.mlm.model.sms.ServiceDetails;
import com.logicq.mlm.service.otp.IServiceRequestService;

@RestController
@RequestMapping("/admin/service")
public class ServiceRequestController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(ServiceRequestController.class);
	
	@Autowired
	IServiceRequestService contentmodificationservice;
	
	
	@RequestMapping(value = "/requestservice", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceDetails> userRegister(@RequestBody ServiceDetails contentDetails) throws Exception {
		if(null==contentmodificationservice){
		return 	new ResponseEntity<ServiceDetails>(contentDetails, HttpStatus.BAD_REQUEST);
		}
		if(null!=contentDetails){
			contentmodificationservice.saveorUpdateRequest(contentDetails);
		}
		return new ResponseEntity<ServiceDetails>(contentDetails, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/getTest/{data}", method = RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getTest(@PathVariable String data) throws Exception {
		System.out.println(" Test "+ data);
		return new ResponseEntity<String>(data, HttpStatus.OK);
	}
	
}
