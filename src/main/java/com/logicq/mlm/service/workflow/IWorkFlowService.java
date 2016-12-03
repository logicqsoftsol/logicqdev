package com.logicq.mlm.service.workflow;

import java.util.List;

import com.logicq.mlm.model.workflow.WorkFlow;

public interface IWorkFlowService {
	
	public void createWorkFlowForValidation(WorkFlow workflow)throws Exception;
	
	public void createWorkFlowForListValidation(List<WorkFlow> workflow)throws Exception;
	
	public void updateWorkFlow(WorkFlow workflow)throws Exception;
	
	public List<WorkFlow> getPendingWorkFlowForUser(String assignedto,String profileid)throws Exception;

}
