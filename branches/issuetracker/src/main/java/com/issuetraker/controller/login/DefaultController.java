package com.issuetraker.controller.login;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prelogin")
public class DefaultController {




	@RequestMapping(value = "/loadDefaultUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> loadDefaultUsers() {
	
			System.out.println("Test pre login");
		return new ResponseEntity<String>("done", HttpStatus.OK);
	}
	
	
	
}
