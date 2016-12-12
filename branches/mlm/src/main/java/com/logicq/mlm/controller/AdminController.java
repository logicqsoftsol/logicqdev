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

import com.logicq.mlm.model.admin.TaskDetails;
import com.logicq.mlm.model.profile.WalletDetails;
import com.logicq.mlm.model.workflow.WorkFlow;
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
	

	

	@RequestMapping(value = "/updateAdminTask", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StatusVO> fetchUserDetails(@RequestBody TaskDetails taskdetails) throws Exception {
		StatusVO statusvo=new StatusVO();
		if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
			if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof LoginVO) {
				WorkFlow workflow=workflowservice.getWorkFlowAccordingToWorkId(taskdetails.getTaskid());
				workflow.setStatus(Boolean.TRUE);
				workflowservice.updateWorkFlow(workflow);
				if("ADMIN_VERIFICATION".equals(workflow.getWorktype())&& workflow.getStatus()){
				//fetch wallet details for specific profile id
					WalletDetails walletdetails=new WalletDetails();
					walletdetails.setIsactive(Boolean.TRUE);
					walletdetails.setWalletactivedate(new Date());
				 
				}
			}
		}
		return new ResponseEntity<StatusVO>(statusvo, HttpStatus.OK);
	}

}
