package com.logicq.mlm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.logicq.mlm.common.factory.LoginFactory;
import com.logicq.mlm.common.helper.PropertyHelper;
import com.logicq.mlm.common.helper.WalletAmountCalculator;
import com.logicq.mlm.model.admin.FeeSetup;
import com.logicq.mlm.model.admin.NetWorkTask;
import com.logicq.mlm.model.admin.TaskDetails;
import com.logicq.mlm.model.login.Login;
import com.logicq.mlm.model.profile.NetWorkDetails;
import com.logicq.mlm.model.profile.NetworkInfo;
import com.logicq.mlm.model.profile.UserProfile;
import com.logicq.mlm.model.profile.WalletDetails;
import com.logicq.mlm.model.wallet.WalletStatement;
import com.logicq.mlm.model.workflow.WorkFlow;
import com.logicq.mlm.service.networkdetails.INetworkDetailsService;
import com.logicq.mlm.service.networkdetails.INetworkTaskService;
import com.logicq.mlm.service.user.IUserService;
import com.logicq.mlm.service.wallet.IFeeSetupService;
import com.logicq.mlm.service.wallet.IWalletDetailsService;
import com.logicq.mlm.service.wallet.IWalletStmntService;
import com.logicq.mlm.service.workflow.IWorkFlowService;
import com.logicq.mlm.vo.EncashVO;
import com.logicq.mlm.vo.LoginVO;
import com.logicq.mlm.vo.StatusVO;
import com.logicq.mlm.vo.UserDetailsVO;

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
	INetworkTaskService networktaskservice;
	
	@Autowired
	IUserService userservice;
	
	@Autowired
	IWalletDetailsService walletDetailsService;
	
	@Autowired
	IFeeSetupService feeSetupService;

	ObjectMapper objectmapper = new ObjectMapper();

	@RequestMapping(value = "/updateAdminTask", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StatusVO> updateAdminTaskDetails(@RequestBody TaskDetails taskdetails) throws Exception {
		StatusVO statusvo = new StatusVO();
		if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
			if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof LoginVO) {
				WorkFlow workflow = workflowservice.getWorkFlowAccordingToWorkId(taskdetails.getTaskid());
				workflow.setStatus(Boolean.TRUE);
				workflow.setMessage(workflow.getWorktype()+" done sucessfully");
				workflowservice.updateWorkFlow(workflow);				
				if ("ENCASH_REQUEST".equals(workflow.getWorktype()) && workflow.getStatus()) {
					EncashVO encashvo = taskdetails.getEncashvo();//objectmapper.convertValue(new String(workflow.getWorktype()), EncashVO.class);
					encashvo.setRefrencenumber(taskdetails.getEncashvo().getRefrencenumber());
					encashvo.setEncashtype(taskdetails.getEncashvo().getEncashtype());
					// encashvo.setEncashamount(taskdetails.getEncashvo().getEncashamount());
					workflow.setWorkparameter(objectmapper.writeValueAsBytes(encashvo));
					List<WorkFlow> workflowlist = workflowservice
							.getWorkFlowForUserAccordingToWorkType("ENCASH_REQUEST", workflow.getAssignedto());
					if (!workflowlist.isEmpty()) {
						WorkFlow userworkflow = workflowlist.get(0);
						userworkflow.setStatus(Boolean.TRUE);
						userworkflow.setMessage("Encash Done by " + taskdetails.getEncashvo().getEncashtype()
								+ "with  ref no " + taskdetails.getEncashvo().getRefrencenumber());
						workflowservice.updateWorkFlow(userworkflow);
						UserProfile userprofile = userservice
								.fetchUserAccordingToProfileId(Long.valueOf(workflow.getProfileid()));
						if (userprofile.getWalletdetails().isIsactive()) {
							WalletStatement walletstmnt = new WalletStatement();
							walletstmnt.setWalletid(userprofile.getWalletdetails().getWalletid());
							walletstmnt = walletservice.fetchWalletStmnt(walletstmnt);
							walletstmnt = WalletAmountCalculator.calculateCurrentBalanceAfterEncashed(walletstmnt,
									taskdetails.getEncashvo().getEncashamount());
							walletservice.updateWalletStmnt(walletstmnt);
						}
					}
				}
				if ("ADMIN_VERIFICATION".equals(workflow.getWorktype()) && workflow.getStatus()) {
					// need to add this logic for each parent id
					UserProfile userprofile = userservice
							.fetchUserAccordingToProfileId(Long.valueOf(workflow.getProfileid()));
					userprofile.getWalletdetails().setIsactive(Boolean.TRUE);
					userprofile.getWalletdetails().setWalletactivedate(new Date());
					walletDetailsService.updateWalletDetails(userprofile.getWalletdetails());
					
					NetWorkDetails networkinfo = objectmapper
							.convertValue(userprofile.getNetworkinfo().getNetworkjson(), NetWorkDetails.class);
					NetworkInfo parentNetworkInfo = netWorkDetailsService
							.getNetworkDetails(userprofile.getNetworkinfo().getParentmemberid());
					
					NetWorkDetails parentNetworkdetails = PropertyHelper.convertJsonToNetworkInfo(parentNetworkInfo);
					
					if (null != parentNetworkdetails && null != parentNetworkdetails.getChildren()) {
						parentNetworkdetails.getChildren().add(networkinfo);
					}else{
						parentNetworkdetails.setChildren(new ArrayList<NetWorkDetails>());
						parentNetworkdetails.getChildren().add(networkinfo);
					}
					
					parentNetworkInfo.setNetworkjson(PropertyHelper.convertNetworkInfoToJson(parentNetworkdetails).getBytes());
					netWorkDetailsService.updateNetworkDetails(parentNetworkInfo);
		
					//Fee update
					UserProfile parentuserprofile = userservice.fetchUserAccordingToUserName(userprofile.getNetworkinfo().getParentmemberid());
					List<FeeSetup> feeDetails=feeSetupService.getFeeDetails();
					WalletStatement walletStatement=new WalletStatement();
					walletStatement.setWallet(parentuserprofile.getWalletdetails());
					walletStatement.setWalletid(parentuserprofile.getWalletdetails().getWalletid());
					walletStatement=walletservice.fetchWalletStmnt(walletStatement);
					for (FeeSetup fee : feeDetails) {
						if (fee.getApplyTo().equals("LEVEL1")) {
							walletservice.updateWalletStatementAccordingToFee(fee, walletStatement);
							break;
						}
					}

					//Create Network Task
					NetWorkTask networktask=new NetWorkTask();
					networktask.setMemberid(userprofile.getNetworkinfo().getMemberid());
					networktask.setParentid(userprofile.getNetworkinfo().getParentmemberid());
					networktask.setTaskcreationdate(new Date());
					networktask.setTaskStatus(Boolean.FALSE);
					networktaskservice.createNetworkTask(networktask);
				}

			}
		}
		return new ResponseEntity<StatusVO>(statusvo, HttpStatus.OK);
	}

	@RequestMapping(value = "/getTaskListDetails", method = RequestMethod.GET)
	public ResponseEntity<UserDetailsVO> getTaskListDetails() throws Exception {
		UserDetailsVO userdetailsvo = new UserDetailsVO();
		if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
			if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof LoginVO) {
				LoginVO login = (LoginVO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				UserProfile userdetails = new UserProfile();
				userdetails.setLogindetails(LoginFactory.createLoginDetails(login));
				String authorityname = null;
				List<GrantedAuthority> authorities = (List<GrantedAuthority>) login.getAuthorities();
				if (null != authorities && !authorities.isEmpty()) {
					authorityname = authorities.get(0).getAuthority();
				}
				if (authorityname.equals("ADMIN")) {
					List<WorkFlow> workflowlist = workflowservice.getPendingWorkFlowForAdmin(authorityname);
					List<TaskDetails> tasklist = new ArrayList<TaskDetails>();
					for (WorkFlow workflow : workflowlist) {
						TaskDetails task = new TaskDetails();
						task.setPriority("HIGH");
						task.setTaskassigneddate(workflow.getCreatetime());
						task.setTaskfor(workflow.getCreatedby());
						task.setTaskname(workflow.getWorktype());
						if (!workflow.getStatus()) {
							task.setTaskstatus("Pending");
						}
						task.setTasktype(workflow.getWorktype());
						task.setTaskid(workflow.getWorkid());
						tasklist.add(task);
					}
					userdetailsvo.setTasklist(tasklist);
				}
			}
		}
		return new ResponseEntity<UserDetailsVO>(userdetailsvo, HttpStatus.OK);
	}

}
