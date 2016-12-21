package com.logicq.mlm.service.workflow;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.logicq.mlm.dao.workflow.IWorkFlowDAO;
import com.logicq.mlm.model.profile.UserProfile;
import com.logicq.mlm.model.workflow.WorkFlow;
import com.logicq.mlm.service.messaging.IEmailService;
import com.logicq.mlm.vo.EncashVO;

@Service
@Transactional
public class WorkFlowService  implements IWorkFlowService{

	@Autowired
	IWorkFlowDAO workflowdao;
	
	@Autowired
	IEmailService emailservice;
	
	@Override
	public void createWorkFlowForValidation(WorkFlow workflow) throws Exception {
		workflowdao.createWorkFlowForValidation(workflow);
	}

	@Override
	public void createWorkFlowForListValidation(List<WorkFlow> workflow) throws Exception {
		workflowdao.createWorkFlowForListValidation(workflow);
		
	}

	@Override
	public void updateWorkFlow(WorkFlow workflow) throws Exception {
		workflowdao.updateWorkFlow(workflow);
	}

	@Override
	public List<WorkFlow> getPendingWorkFlowForUser(String assignedto, String profileid) throws Exception {
		return workflowdao.getPendingWorkFlowForUser(assignedto, profileid);
	}

	@Override
	public List<WorkFlow> getPendingWorkFlowForAdmin(String assignedto) throws Exception {
		
		return workflowdao.getPendingWorkFlowForAdmin(assignedto);
	}

	@Override
	public WorkFlow getWorkFlowAccordingToWorkId(Long workid) throws Exception {
		return workflowdao.getWorkFlowAccordingToWorkId(workid);
	}

	@Override
	public List<WorkFlow> getPendingWorkFlowAccordingToProfile(String profileid) {
		return workflowdao.getPendingWorkFlowAccordingToProfile(profileid);
	}

	@Override
	public void createWorkFlowForEncashRequest(EncashVO encashvo,UserProfile userprofile) throws Exception {
		WorkFlow workflow=new WorkFlow();
		workflow.setAssignedto("ADMIN");
		workflow.setCreatedby(userprofile.getLogindetails().getUsername());
		workflow.setCreatetime(new Date());
		workflow.setMessage("Encash Request Pending");
		workflow.setProfileid(String.valueOf(userprofile.getId()));
		workflow.setStatus(Boolean.FALSE);
		workflow.setWorktype("ENCASH_REQUEST");
		byte[] encashparameter=prepareWorkFlowParameter(encashvo);
		workflow.setWorkparameter(encashparameter);
		workflowdao.createWorkFlowForValidation(workflow);
		//Send email to admin and user for encash request with request id
		//emailservice.sendEmail(emaildetails)
	}

	private byte[] prepareWorkFlowParameter(EncashVO encashvo) throws Exception {
		ObjectMapper objectmapper=new ObjectMapper();
		return objectmapper.writeValueAsBytes(encashvo);
	}

}
