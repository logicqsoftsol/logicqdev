package com.logicq.commonproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.logicq.commonproject.service.ILoginService;

/**
 * NIHAR 15-Oct-2016 6:04:20 pm
 */
@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	ILoginService loginService;
	@RequestMapping(value = "/loginuser/{username}/{password}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean loginUser(@PathVariable("username") String username, @PathVariable("password") String password) {

		return loginService.validateUser(username, password);
	}
}
