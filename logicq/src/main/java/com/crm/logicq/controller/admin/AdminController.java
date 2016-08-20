package com.crm.logicq.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crm.logicq.service.login.IloginService;


@RestController
@RequestMapping("/admin")
public class AdminController {


	
	@Autowired
	IloginService loginservice;
	


	@RequestMapping(value = "/login/loadDefaultUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity loadloginuser() {
		loginservice.loadloginUser();		
		return new ResponseEntity(true, HttpStatus.OK);
	}
	



}
