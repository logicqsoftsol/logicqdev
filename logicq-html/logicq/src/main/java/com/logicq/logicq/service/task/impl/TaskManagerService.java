package com.logicq.logicq.service.task.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.logicq.common.LogicqContextProvider;
import com.logicq.logicq.communication.messagesender.jms.LogicqMessageSender;
import com.logicq.logicq.conversion.task.TaskConversion;
import com.logicq.logicq.dao.task.ITaskManagerDAO;
import com.logicq.logicq.model.task.Task;
import com.logicq.logicq.service.task.ITaskManagerService;
import com.logicq.logicq.ui.task.vo.TaskVO;

@Service
@Transactional
public class TaskManagerService implements ITaskManagerService {
    
	ITaskManagerDAO taskManagerDAO;
	TaskConversion taskconversion=TaskConversion.getInstance();
	
	public ITaskManagerDAO getTaskManagerDAO() {
		return taskManagerDAO;
	}

	public void setTaskManagerDAO(ITaskManagerDAO taskManagerDAO) {
		this.taskManagerDAO = taskManagerDAO;
	}

	
	public void addTask(TaskVO p_taskvo) {
		Task l_task=taskconversion.handleConversionVOtoEntityWithContext(p_taskvo);
		taskManagerDAO.addTask(l_task);
		//LogicqContextProvider.getApplicationmap().put(String.valueOf(l_task.getId()) , l_task);
	}

	
	public void updateTask(TaskVO p_taskvo) {
		Task l_task=taskconversion.handleConversionVOtoEntityWithContext(p_taskvo);
		taskManagerDAO.updateTask(l_task);
		//LogicqContextProvider.getApplicationmap().remove(l_task.getId());
	}

	public List<TaskVO> getAllTasks() {
		// TODO Auto-generated method stub
		return null;
	}

	public TaskVO getTaskById(int taskId) {
		Task l_task = getTaskEntityForTaskId(taskId);
		TaskVO l_taskvo = taskconversion
				.handleConversionEntitytoVOWithContext(l_task);
		return l_taskvo;
	}

	public Task getTaskEntityForTaskId(int taskId) {
		
		return taskManagerDAO.getTaskById(taskId);
	}
	
	public void changeTaskStatus(int taskId, String status) {
		Task l_task = getTaskEntityForTaskId(taskId);
		l_task.setStatus(status);
		TaskVO l_taskvo = taskconversion
				.handleConversionEntitytoVOWithContext(l_task);
		updateTask(l_taskvo);
		//LogicqContextProvider.getApplicationmap().remove(l_task.getId());
	}

	public List<TaskVO> getAllTasks(TaskVO task) {
		Task l_task=taskconversion.handleConversionVOtoEntityWithContext(task);
		List<Task> l_tasklist=taskManagerDAO.getAllTasks(l_task);
		return taskconversion.handleConversionForTaskList(l_tasklist);
	}

}
