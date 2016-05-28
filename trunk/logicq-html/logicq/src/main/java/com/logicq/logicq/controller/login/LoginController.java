package com.logicq.logicq.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.logicq.logicq.security.service.TokenAuthenticationService;
import com.logicq.logicq.service.user.IUserService;
import com.logicq.logicq.service.user.impl.UserService;
import com.logicq.logicq.ui.security.LoginUserVO;
import com.logicq.logicq.ui.user.vo.UserVO;

@RestController
@RequestMapping("/api")
public class LoginController {
	
	
	@Autowired
	IUserService userservice;
	
	@Autowired
	TokenAuthenticationService tokenAuthenticationService;	
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserVO> login() {
		UserVO userdetailsvo=null;
		if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
			if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof LoginUserVO) {
				LoginUserVO	login = (LoginUserVO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				if (StringUtils.isEmpty(login.getToken())) {
					String token = tokenAuthenticationService.getTokenHandler().createTokenForUser(login);
					login.setToken(token);
				} else {
					login = tokenAuthenticationService.getTokenHandler().parseUserFromToken(login.getToken());
				}
				userdetailsvo=userservice.getUserById(login.getId());
			}
			
		}
		return new ResponseEntity<UserVO>(userdetailsvo, HttpStatus.OK);
	}

}
