package com.crm.logicq.controller.admin.message.sms;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crm.logicq.model.alert.SMSDetails;

@RestController
@RequestMapping("/admin/smstemplate")
public class SMSController {
	
	
	

	@RequestMapping(value = "/add", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SMSDetails> addSMSTemplate(@RequestBody SMSDetails smsdetails) {
	
		return new ResponseEntity<SMSDetails>(smsdetails, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SMSDetails> updateSMSTemplate(@RequestBody SMSDetails smsdetails ) {
		
		return new ResponseEntity<SMSDetails>(smsdetails, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SMSDetails> deleteSMSTemplate(@PathVariable String templateid) {
		SMSDetails smsdetails=new SMSDetails();
		return new ResponseEntity<SMSDetails>(smsdetails, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SMSDetails> searchSMSTemplate(@PathVariable String templateid) {
		SMSDetails smsdetails=new SMSDetails();
		return new ResponseEntity<SMSDetails>(smsdetails, HttpStatus.OK);
	}

}
