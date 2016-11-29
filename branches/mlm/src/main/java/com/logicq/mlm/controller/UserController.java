package com.logicq.mlm.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.logicq.mlm.common.factory.LoginFactory;
import com.logicq.mlm.model.performance.UserPerformance;
import com.logicq.mlm.model.profile.NetWorkDetails;
import com.logicq.mlm.model.profile.UserProfile;
import com.logicq.mlm.model.wallet.WalletStatement;
import com.logicq.mlm.service.performance.IUserPerformanceService;
import com.logicq.mlm.service.user.IUserService;
import com.logicq.mlm.service.wallet.IWalletStmntService;
import com.logicq.mlm.vo.LoginVO;
import com.logicq.mlm.vo.UserDetailsVO;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	IUserService userservice;
	
	@Autowired
	IWalletStmntService walletStatementservice;
	
	@Autowired
    IUserPerformanceService userperformanceservice;
	
	@RequestMapping(value = "/fetchUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDetailsVO> fetchUserDetails() throws Exception {
		UserDetailsVO userdetailsvo=new UserDetailsVO();
		if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
			if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof LoginVO) {
				LoginVO login = (LoginVO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				UserProfile userdetails = new UserProfile();
				userdetails.setLogindetails(LoginFactory.createLoginDetails(login));
				userservice.fetchUser(userdetails);
			}
		}
		return new ResponseEntity<UserDetailsVO>(userdetailsvo, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserProfile> saveUserDetails(@RequestBody UserProfile userdetails) throws Exception {
		if (null != userdetails) {
			userservice.saveUser(userdetails);
		}
		return new ResponseEntity<UserProfile>(userdetails, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserProfile> deleteUserDetails(@RequestBody UserProfile userdetails) throws Exception {
		if (null != userdetails) {
			userservice.deleteUser(userdetails);
		}
		return new ResponseEntity<UserProfile>(userdetails, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/editUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserProfile> editUserDetails(@RequestBody UserProfile userdetails) throws Exception {
		if (null != userdetails) {
			userservice.updateUser(userdetails);
		}
		return new ResponseEntity<UserProfile>(userdetails, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/fetchUserProfileDetails/{networkid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDetailsVO> fetchUserProfileDetails(@PathVariable String networkid) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		UserDetailsVO userdetailsvo = new UserDetailsVO();
		UserProfile userprofile = new UserProfile();
		WalletStatement walletStatement = new WalletStatement();
		UserPerformance userperformance = new UserPerformance();
		if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
			if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof LoginVO) {
				LoginVO login = (LoginVO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				userprofile.setLogindetails(LoginFactory.createLoginDetails(login));
				userprofile = userservice.fetchUser(userprofile);
				userdetailsvo.setUserprofile(userprofile);
				NetWorkDetails networkdetails = mapper
						.readValue(new File("C:\\Users\\SudhanshuLenka\\Desktop\\network.json"), NetWorkDetails.class);
				userdetailsvo.setNetworkjson(networkdetails);
				if (login.getUsername().equals(networkid)) {
					walletStatementservice.fetchWalletStmntAccordingToAggregartion(walletStatement);
					userdetailsvo.setWalletStatement(walletStatement);
					userperformanceservice.fetchUserPerformanceAccordingToAggregation(userperformance);
					userdetailsvo.setUserperformance(userperformance);
				} else {
					userdetailsvo.setWalletStatement(walletStatement);
					userdetailsvo.setUserperformance(userperformance);
				}
			}
		}
		return new ResponseEntity<UserDetailsVO>(userdetailsvo, HttpStatus.OK);
	}
	
	
}
