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
import com.logicq.logicq.ui.login.vo.LoginVO;
import com.logicq.logicq.ui.security.LoginUserVO;
import com.logicq.logicq.ui.user.vo.UserVO;

@RestController
@RequestMapping("/api")
public class LoginController {
	
	
	@Autowired
	IUserService userservice;
	
	@Autowired
	TokenAuthenticationService tokenAuthenticationService;	
	
@RequestMapping(value = "/login", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes= MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<LoginVO> login() {
		
		
	LoginVO login=null;
		if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
			if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof LoginVO) {
				login = (LoginVO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				if (StringUtils.isEmpty(login.getToken())) {
					String token = tokenAuthenticationService.getTokenHandler().createTokenForUser(login);
					login.setToken(token);
				} else {
					login = tokenAuthenticationService.getTokenHandler().parseUserFromToken(login.getToken());
				}
				//userdetailsvo = userservice.getUserIdFromEmailOrMobile(login.getEmail());
			}

		}
		return new ResponseEntity<LoginVO>(login, HttpStatus.OK);
	}

}
