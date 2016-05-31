package com.logicq.logicq.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.logicq.logicq.security.service.TokenAuthenticationConstant;
import com.logicq.logicq.security.service.TokenAuthenticationService;
import com.logicq.logicq.security.service.UserService;
import com.logicq.logicq.service.user.IUserService;
import com.logicq.logicq.ui.login.vo.LoginVO;
import com.logicq.logicq.ui.user.vo.BasicUserVO;

@RestController
@RequestMapping("/api")
public class LoginController {

	@Autowired
	IUserService userservice;

	@Autowired
	TokenAuthenticationService tokenAuthenticationService;

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BasicUserVO> login() {
		LoginVO login = null;
	
		if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
			BasicUserVO basicuser=new BasicUserVO();
			if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof LoginVO) {
				login = (LoginVO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				String token=(String) SecurityContextHolder.getContext().getAuthentication().getCredentials();
				if (StringUtils.isEmpty(token)) {
					token = tokenAuthenticationService.getTokenHandler().createTokenForUser(login);
				} 
				login = tokenAuthenticationService.getTokenHandler().parseUserFromToken(token);
				if (null != login) {
					HttpHeaders headers = new HttpHeaders();
					headers.add(TokenAuthenticationConstant.AUTH_HEADER_NAME, token);
					basicuser.setEmail(login.getEmail());
					basicuser.setName(login.getUsername());
					basicuser.setPhone(login.getPhone());
					return new ResponseEntity<BasicUserVO>(basicuser, HttpStatus.OK);
				} else {
					return new ResponseEntity<BasicUserVO>(basicuser, HttpStatus.UNAUTHORIZED);
				}
			}

		}
		return null;
	}
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LoginVO> logout() {
		LoginVO login =null;
		if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
			if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof LoginVO) {
				login = (LoginVO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				String token=(String) SecurityContextHolder.getContext().getAuthentication().getCredentials();
				if (!StringUtils.isEmpty(token)) {
					LoginVO logindetails = tokenAuthenticationService.getTokenHandler().parseUserFromToken(token);
					UserService.removeUser(logindetails);
				} 
			
			}

		}
		return new ResponseEntity<LoginVO>(login, HttpStatus.OK);
	}


}
