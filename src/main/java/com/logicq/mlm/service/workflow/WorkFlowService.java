package com.logicq.mlm.service.workflow;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logicq.mlm.dao.workflow.IWorkFlowDAO;
import com.logicq.mlm.model.workflow.WorkFlow;

@Service
@Transactional
public class WorkFlowService  implements IWorkFlowService{

	@Autowired
	IWorkFlowDAO workflowdao;
	
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

}
