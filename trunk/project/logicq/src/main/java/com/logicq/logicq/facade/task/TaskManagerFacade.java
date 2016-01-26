package com.logicq.logicq.facade.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.logicq.model.task.Task;
import com.logicq.logicq.service.task.ITaskManagerService;
import com.logicq.logicq.ui.task.vo.TaskVO;

public class TaskManagerFacade implements ITaskManagerFacade{
       
	@Autowired
	ITaskManagerService taskManagerService;
	
	public ITaskManagerService getTaskManagerService() {
		return taskManagerService;
	}

	public void setTaskManagerService(ITaskManagerService taskManagerService) {
		this.taskManagerService = taskManagerService;
	}

	@Transactional(readOnly=false)
	public void addTask(TaskVO task) {
		taskManagerService.addTask(task);
	}

	@Transactional(readOnly = false)
	public void updateTask(TaskVO task) {
		taskManagerService.updateTask(task);
	}

	@Transactional(readOnly = true)
	public List<TaskVO> getAllTasks() {
		
		return taskManagerService.getAllTasks();
	}

	@Transactional(readOnly = true)
	public TaskVO getTaskById(int taskId) {
		return taskManagerService.getTaskById(taskId);
	}

	@Transactional(readOnly = false)
	public void changeTaskStatus(int taskId, String status) {
		taskManagerService.changeTaskStatus(taskId, status);
	}

	@Transactional(readOnly = true)
	public List<TaskVO> getAllTasks(TaskVO task) {
		return taskManagerService.getAllTasks(task);
	}

	

}
