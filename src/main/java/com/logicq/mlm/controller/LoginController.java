package com.logicq.mlm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.logicq.mlm.common.factory.LoginFactory;
import com.logicq.mlm.model.performance.UserPerformance;
import com.logicq.mlm.model.profile.UserProfile;
import com.logicq.mlm.model.wallet.WalletStatement;
import com.logicq.mlm.service.performance.IUserPerformanceService;
import com.logicq.mlm.service.performance.UserPerformanceService;
import com.logicq.mlm.service.security.UserService;
import com.logicq.mlm.service.user.IUserService;
import com.logicq.mlm.service.wallet.IWalletStmntService;
import com.logicq.mlm.service.wallet.WalletStmntService;
import com.logicq.mlm.vo.LoginVO;
import com.logicq.mlm.vo.UserDetailsVO;

@RestController
@RequestMapping("/api")
public class LoginController {

	@Autowired
	IUserService userservice;
	
	@Autowired
	IWalletStmntService walletStatementservice;
	
	@Autowired
    IUserPerformanceService userperformanceservice;
	
	  
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDetailsVO> login() {
		UserDetailsVO userdetailsvo=new UserDetailsVO();
		UserProfile userprofile = new UserProfile();
		WalletStatement walletStatement=new WalletStatement();
		UserPerformance userperformance=new UserPerformance();
		if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
			if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof LoginVO) {
				LoginVO login=(LoginVO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				try {
					userprofile.setLogindetails(LoginFactory.createLoginDetails(login));
					userprofile=userservice.fetchUser(userprofile);
					userdetailsvo.setUserprofile(userprofile);
					walletStatementservice.fetchWalletStmntAccordingToAggregartion(walletStatement);
					userdetailsvo.setWalletStatement(walletStatement);
					userperformanceservice.fetchUserPerformanceAccordingToAggregation(userperformance);
					userdetailsvo.setUserperformance(userperformance);
				} catch (Exception e) {
					return new ResponseEntity<UserDetailsVO>(userdetailsvo, HttpStatus.INTERNAL_SERVER_ERROR);
				}

			}

		}
		return new ResponseEntity<UserDetailsVO>(userdetailsvo, HttpStatus.OK);
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
