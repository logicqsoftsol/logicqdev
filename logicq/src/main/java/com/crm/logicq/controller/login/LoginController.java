package com.crm.logicq.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crm.logicq.security.service.UserService;
import com.crm.logicq.service.user.IUserService;
import com.crm.logicq.ui.security.LoginVO;

@RestController
@RequestMapping("/api")
public class LoginController {


	  @Autowired
	  IUserService userservice;

	  
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LoginVO> login() {
		LoginVO login = null;
	
		if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
			if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof LoginVO) {
				login=(LoginVO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				try {
					userservice.loadEmployees();
					userservice.loadStudents();
				} catch (Exception e) {
					return new ResponseEntity<LoginVO>(login, HttpStatus.INTERNAL_SERVER_ERROR);
				}

			}

		}
		return new ResponseEntity<LoginVO>(login, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LoginVO> logout() {
		LoginVO login =null;
		if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
			if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof LoginVO) {
				login = (LoginVO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				String token=(String) SecurityContextHolder.getContext().getAuthentication().getCredentials();
				if (!StringUtils.isEmpty(token)) {
					LoginVO logindetails =null; //tokenAuthenticationService.getTokenHandler().parseUserFromToken(token);
					UserService.removeUser(logindetails);
				} 
			
			}

		}
		return new ResponseEntity<LoginVO>(login, HttpStatus.OK);
	}

}
