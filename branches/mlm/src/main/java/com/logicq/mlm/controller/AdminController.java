package com.logicq.mlm.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.logicq.mlm.common.helper.PropertyHelper;
import com.logicq.mlm.common.helper.WalletAmountCalculator;
import com.logicq.mlm.model.admin.TaskDetails;
import com.logicq.mlm.model.login.Login;
import com.logicq.mlm.model.profile.NetWorkDetails;
import com.logicq.mlm.model.profile.NetworkInfo;
import com.logicq.mlm.model.profile.UserProfile;
import com.logicq.mlm.model.profile.WalletDetails;
import com.logicq.mlm.model.wallet.WalletStatement;
import com.logicq.mlm.model.workflow.WorkFlow;
import com.logicq.mlm.service.networkdetails.INetworkDetailsService;
import com.logicq.mlm.service.user.IUserService;
import com.logicq.mlm.service.wallet.IWalletStmntService;
import com.logicq.mlm.service.workflow.IWorkFlowService;
import com.logicq.mlm.vo.LoginVO;
import com.logicq.mlm.vo.StatusVO;

@RestController
@RequestMapping("api/admin")
public class AdminController {
	
	@Autowired
	IWorkFlowService workflowservice;
	
	@Autowired
	IWalletStmntService walletservice;
	
	@Autowired
	INetworkDetailsService netWorkDetailsService;
	
	@Autowired
	IUserService userservice;
	

	

	@RequestMapping(value = "/updateAdminTask", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StatusVO> fetchUserDetails(@RequestBody TaskDetails taskdetails) throws Exception {
		StatusVO statusvo=new StatusVO();
		if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
			if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof LoginVO) {
				LoginVO admindetails=(LoginVO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				WorkFlow workflow=workflowservice.getWorkFlowAccordingToWorkId(taskdetails.getTaskid());
				workflow.setStatus(Boolean.TRUE);
				workflowservice.updateWorkFlow(workflow);
				if("ADMIN_VERIFICATION".equals(workflow.getWorktype())&& workflow.getStatus()){
				// need to add this logic for each parent id
					
					UserProfile userprofile=userservice.fetchUserAccordingToProfileId(Long.valueOf(workflow.getProfileid()));
					userprofile.getWalletdetails().setIsactive(Boolean.TRUE);
					userprofile.getWalletdetails().setWalletactivedate(new Date());
					UserProfile adminprofile=new UserProfile();
					adminprofile.setLogindetails(new Login());
					adminprofile.getLogindetails().setUsername(userprofile.getNetworkinfo().getParentmemberid());
					adminprofile=userservice.fetchUser(adminprofile);
					//Update wallet for level 1
					WalletStatement walletstmnt=new WalletStatement();
					walletstmnt.setWalletid(adminprofile.getWalletdetails().getWalletid());
					walletstmnt=walletservice.fetchWalletStmntAccordingToAggregartion(walletstmnt);
					walletstmnt=WalletAmountCalculator.calculateCurrentBalance(walletstmnt);
					walletservice.updateWalletStmnt(walletstmnt);
					
					
					//Update Parent JSON
					NetworkInfo parentnetworkinfo=netWorkDetailsService.getNetworkDetails(userprofile.getNetworkinfo().getParentmemberid());
					NetWorkDetails parentnetworkdetails=PropertyHelper.convertJsonToNetworkInfo(parentnetworkinfo);
					NetWorkDetails currentnetworkdetails=PropertyHelper.convertJsonToNetworkInfo(userprofile.getNetworkinfo());
					parentnetworkdetails.getChildren().add(currentnetworkdetails);
					String modifiedjson=PropertyHelper.convertNetworkInfoToJson(parentnetworkdetails);
					parentnetworkinfo.setNetworkjson(modifiedjson.getBytes());
					netWorkDetailsService.updateNetworkDetails(parentnetworkinfo);
				}
				
			}
		}
		return new ResponseEntity<StatusVO>(statusvo, HttpStatus.OK);
	}

}
