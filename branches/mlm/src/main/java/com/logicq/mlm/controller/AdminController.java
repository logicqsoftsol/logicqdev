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
	IUserService userservice;

	ObjectMapper objectmapper = new ObjectMapper();

	@RequestMapping(value = "/updateAdminTask", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StatusVO> updateAdminTaskDetails(@RequestBody TaskDetails taskdetails) throws Exception {
		StatusVO statusvo = new StatusVO();
		if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
			if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof LoginVO) {
				LoginVO admindetails = (LoginVO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				WorkFlow workflow = workflowservice.getWorkFlowAccordingToWorkId(taskdetails.getTaskid());
				workflow.setStatus(Boolean.TRUE);
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
						WalletStatement walletstmnt = new WalletStatement();
						walletstmnt.setWalletid(userprofile.getWalletdetails().getWalletid());
						walletstmnt = walletservice.fetchWalletStmntAccordingToAggregartion(walletstmnt);
						walletstmnt = WalletAmountCalculator.calculateCurrentBalanceAfterEncashed(walletstmnt,
								taskdetails.getEncashvo().getEncashamount());
						walletservice.updateWalletStmnt(walletstmnt);
					}

				}
				workflowservice.updateWorkFlow(workflow);
				if ("ADMIN_VERIFICATION".equals(workflow.getWorktype()) && workflow.getStatus()) {
					// need to add this logic for each parent id
					UserProfile userprofile = userservice
							.fetchUserAccordingToProfileId(Long.valueOf(workflow.getProfileid()));
					userprofile.getWalletdetails().setIsactive(Boolean.TRUE);
					userprofile.getWalletdetails().setWalletactivedate(new Date());
					UserProfile adminprofile = new UserProfile();
					adminprofile.setLogindetails(new Login());
					adminprofile.getLogindetails().setUsername(userprofile.getNetworkinfo().getParentmemberid());
					adminprofile = userservice.fetchUser(adminprofile);
					// Update wallet for level 1
					WalletStatement walletstmnt = new WalletStatement();
					walletstmnt.setWalletid(adminprofile.getWalletdetails().getWalletid());
					walletstmnt = walletservice.fetchWalletStmntAccordingToAggregartion(walletstmnt);
					walletstmnt = WalletAmountCalculator.calculateCurrentBalance(walletstmnt);
					walletservice.updateWalletStmnt(walletstmnt);

					// Update Parent JSON
					NetworkInfo parentnetworkinfo = netWorkDetailsService
							.getNetworkDetails(userprofile.getNetworkinfo().getParentmemberid());
					NetWorkDetails parentnetworkdetails = PropertyHelper.convertJsonToNetworkInfo(parentnetworkinfo);
					NetWorkDetails currentnetworkdetails = PropertyHelper
							.convertJsonToNetworkInfo(userprofile.getNetworkinfo());
					parentnetworkdetails.getChildren().add(currentnetworkdetails);
					String modifiedjson = PropertyHelper.convertNetworkInfoToJson(parentnetworkdetails);
					parentnetworkinfo.setNetworkjson(modifiedjson.getBytes());
					netWorkDetailsService.updateNetworkDetails(parentnetworkinfo);
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
