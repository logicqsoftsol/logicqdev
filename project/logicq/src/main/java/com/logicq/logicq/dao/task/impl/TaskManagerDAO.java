package com.logicq.logicq.dao.task.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.logicq.logicq.common.LogicqContextProvider;
import com.logicq.logicq.common.criteriamanager.DataFetchType;
import com.logicq.logicq.common.criteriamanager.LogicqCriteriaHandler;
import com.logicq.logicq.common.criteriamanager.LogicqQueryHandler;
import com.logicq.logicq.common.criteriamanager.LogicqRestrictions;
import com.logicq.logicq.dao.AbstractDAO;
import com.logicq.logicq.dao.task.ITaskManagerDAO;
import com.logicq.logicq.dao.task.TaskFilter;
import com.logicq.logicq.model.task.Task;

@Repository
public class TaskManagerDAO extends AbstractDAO<Task> implements ITaskManagerDAO {

	public void addTask(Task task) {
		save(task);
	}

	public void updateTask(Task task) {
		update(task);
	}

	public List<Task> getAllTasks(Task task) {
		LogicqCriteriaHandler l_crietria = new LogicqCriteriaHandler();
		List<TaskFilter> l_criterialist = formFilterCriteria(task);
		return (List<Task>) l_crietria.executeCriteriaDetails(l_criterialist,
				DataFetchType.LIST_RECORD,
				l_crietria.createCriteria(getSession(), Task.class));
	}

	private List<TaskFilter> formFilterCriteria(Task task) {
		TaskFilter l_criteria=new TaskFilter();
		List<TaskFilter> l_criterialist = new ArrayList<TaskFilter>();
		l_criteria.setFieldname(Task.USERID);
		l_criteria.setFieldvalue(task.getUserid());
		l_criterialist.add(l_criteria);
		return l_criterialist;
	}

	public Task getTaskById(int taskId) {
		LogicqQueryHandler logicqQueryHandler = new LogicqQueryHandler();
		Task l_task = LogicqContextProvider.getApplicationContext().getBean(Task.class);
		String p_query = " from TASK";
		List<TaskFilter> l_criterialist = formFilterCriteria(l_task);
		List<Task> tasklist = (List<Task>) logicqQueryHandler
				.executeQueryForSelect(logicqQueryHandler.createCriteria(getSession(), p_query), l_criterialist);
		return tasklist.get(0);
	}


	public List<Task> getAllTasks() {
		LogicqCriteriaHandler l_crietria = new LogicqCriteriaHandler();
		Task l_task=new Task();
		getAllTasks(l_task);
		return null;
	}

}
