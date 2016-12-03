package com.logicq.mlm.dao.workflow;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.logicq.mlm.dao.AbstractDAO;
import com.logicq.mlm.model.workflow.WorkFlow;

@Repository
public class WorkFlowDAO extends AbstractDAO<WorkFlow> implements IWorkFlowDAO {

	@Override
	public void createWorkFlowForValidation(WorkFlow workflow) {
		save(workflow);
	}

	@Override
	public void updateWorkFlow(WorkFlow workflow) throws Exception {
		update(workflow);	
	}

	@Override
	public void createWorkFlowForListValidation(List<WorkFlow> workflow) throws Exception {
		saveList(workflow);
	}

	@Override
	public List<WorkFlow> getPendingWorkFlowForUser(String assignedto, String profileid) throws Exception {
		 StringBuilder query=new StringBuilder();
		 query.append(" from WorkFlow wf where wf.assignedto='"+assignedto+"'"+" and wf.profileid ='"+profileid+"'"+" and status=0");
		return  (List<WorkFlow>) execcuteQuery(query.toString());
	}

}
