package com.logicq.mlm.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.logicq.mlm.common.helper.sms.MessageHelper;
import com.logicq.mlm.common.helper.sms.SMSHelper;
import com.logicq.mlm.model.message.EmailDetails;
import com.logicq.mlm.model.performance.UserPerformance;
import com.logicq.mlm.model.profile.NetWorkDetails;
import com.logicq.mlm.model.profile.NetworkInfo;
import com.logicq.mlm.model.profile.UserProfile;
import com.logicq.mlm.model.sms.SMSDetails;
import com.logicq.mlm.model.wallet.WalletStatement;
import com.logicq.mlm.model.workflow.WorkFlow;
import com.logicq.mlm.service.messaging.IEmailService;
import com.logicq.mlm.service.networkdetails.INetworkDetailsService;
import com.logicq.mlm.service.otp.IOTPService;
import com.logicq.mlm.service.otp.OTPService;
import com.logicq.mlm.service.performance.IUserPerformanceService;
import com.logicq.mlm.service.security.UserService;
import com.logicq.mlm.service.user.IUserService;
import com.logicq.mlm.service.wallet.IWalletStmntService;
import com.logicq.mlm.service.workflow.IWorkFlowService;
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
	
	@Autowired
	IWorkFlowService workflowservice;
	
	@Autowired
	IEmailService emailservice;
	
	@Autowired
	INetworkDetailsService networkservice;

	
	
	ObjectMapper objectmapper=new ObjectMapper();
	
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
	public ResponseEntity<UserDetailsVO> saveUserDetails(@RequestBody UserDetailsVO userdetailvo) throws Exception {
		if (null != userdetailvo.getUserprofile()) {
			//update newtork json
			String networkJson = objectmapper.writeValueAsString(userdetailvo.getNetworkjson());
			userdetailvo.getUserprofile().getNetworkinfo().setNetworkjson(networkJson.getBytes());
			
			//save user details
			userservice.saveUser(userdetailvo.getUserprofile());
	          	
			//workflow details
			List<WorkFlow> workflowlist=prepareWorkFlowDetails(userdetailvo);
	        workflowservice.createWorkFlowForListValidation(workflowlist);
			if (!workflowlist.isEmpty()) {
				for (WorkFlow workflow : workflowlist) {
					EmailDetails emailmessage = prepareEmail(workflow, userdetailvo);
					emailservice.sendEmail(emailmessage);
				}
			}
			//send SMS to user and admin
		     prepapreSMSDetailsAndSendSMS(userdetailvo);
		
			//update parent JSON
		}
		return new ResponseEntity<UserDetailsVO>(userdetailvo, HttpStatus.OK);
	}
	
	private void prepapreSMSDetailsAndSendSMS(UserDetailsVO userdetailvo) {
		SMSDetails usersmsdetails=new SMSDetails();
		usersmsdetails.setMessage(MessageHelper.generateUserRegistartionMessage(userdetailvo.getUserprofile().getLogindetails().getUsername(), userdetailvo.getUserprofile().getLogindetails().getPassword(), userdetailvo.getUserprofile().getFirstname(), userdetailvo.getUserprofile().getLastname()));
		usersmsdetails.setMobilenumber(userdetailvo.getUserprofile().getLogindetails().getMobilenumber());
		usersmsdetails.setMsgreasone("SMS For Registartion");
		SMSHelper.sendSMS(usersmsdetails);
		
		SMSDetails adminsmsdetails=new SMSDetails();
		adminsmsdetails.setMessage(MessageHelper.generateUserRegistartionMessageForAdmin(userdetailvo.getUserprofile().getLogindetails().getMobilenumber(), userdetailvo.getUserprofile().getLogindetails().getEmail()));
		adminsmsdetails.setMobilenumber("7057014118");
		adminsmsdetails.setMsgreasone("Notify Admin FOr new user Added");
		SMSHelper.sendSMS(adminsmsdetails);
	}


	private EmailDetails prepareEmail(WorkFlow workflow, UserDetailsVO userdetailvo) {
		EmailDetails emailMsg = new EmailDetails();
		emailMsg.setSendfrom("sudhanshu.lenka2008@gmail.com");
		emailMsg.setSendto(userdetailvo.getUserprofile().getLogindetails().getEmail());
		emailMsg.setSubject(workflow.getWorktype());
		emailMsg.setText(workflow.getMessage());
		return emailMsg;
	}


	private List<WorkFlow> prepareWorkFlowDetails(UserDetailsVO userdetailvo) {
		List<WorkFlow> workflowdetails=new ArrayList<>();
		if(!userdetailvo.isMobilenoVerified()){
			WorkFlow workflowmobile=new WorkFlow();
			workflowmobile.setAssignedto(userdetailvo.getUserprofile().getLogindetails().getUsername());
			workflowmobile.setMessage("Mobile Verification Pending");
			workflowmobile.setCreatedby(userdetailvo.getUserprofile().getLogindetails().getUsername());
			workflowmobile.setCreatetime(new Date());
			workflowmobile.setWorktype("MOBILE_VERIFICATION");
			workflowmobile.setStatus(false);
			workflowmobile.setProfileid(String.valueOf(userdetailvo.getUserprofile().getId()));
			workflowdetails.add(workflowmobile);
		}
		if(!userdetailvo.isEmailVerified()){
			WorkFlow workflowemail=new WorkFlow();
			workflowemail.setAssignedto(userdetailvo.getUserprofile().getLogindetails().getUsername());
			workflowemail.setMessage("EMail Verification Pending");
			workflowemail.setCreatedby(userdetailvo.getUserprofile().getLogindetails().getUsername());
			workflowemail.setCreatetime(new Date());
			workflowemail.setWorktype("EMAIL_VERIFICATION");
			workflowemail.setStatus(false);
			workflowemail.setProfileid(String.valueOf(userdetailvo.getUserprofile().getId()));
			workflowdetails.add(workflowemail);
		}	
		if(!userdetailvo.isAdminVerified()){
			WorkFlow workflowadmin=new WorkFlow();
			workflowadmin.setAssignedto("ADMIN");
			workflowadmin.setMessage("ADMIN Verification Pending");
			workflowadmin.setCreatedby(userdetailvo.getUserprofile().getLogindetails().getUsername());
			workflowadmin.setCreatetime(new Date());
			workflowadmin.setWorktype("ADMIN_VERIFICATION");
			workflowadmin.setStatus(false);
			workflowadmin.setProfileid(String.valueOf(userdetailvo.getUserprofile().getId()));
			workflowdetails.add(workflowadmin);
		}	
		return workflowdetails;
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
				NetworkInfo networkinfo=networkservice.getNetworkDetails(login.getUsername());
				NetWorkDetails networkdetails = mapper.readValue(new String(networkinfo.getNetworkjson()), NetWorkDetails.class);
				userdetailsvo.setNetworkjson(networkdetails);
				userdetailsvo.setUserperformance(userperformance);
				if (login.getUsername().equals(networkid)) {
					walletStatement.setWallet(userprofile.getWalletdetails());
					walletStatement.setWalletid(userprofile.getWalletdetails().getWalletid());
					walletStatementservice.fetchWalletStmntAccordingToAggregartion(walletStatement);
					userdetailsvo.setWalletStatement(walletStatement);
					userperformanceservice.fetchUserPerformanceAccordingToAggregation(userperformance);
				} else {
					userdetailsvo.setWalletStatement(walletStatement);
					userdetailsvo.setUserperformance(userperformance);
				}
			}
		}
		return new ResponseEntity<UserDetailsVO>(userdetailsvo, HttpStatus.OK);
	}
	
	
}
