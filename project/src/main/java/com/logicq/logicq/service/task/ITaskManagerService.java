package com.logicq.logicq.service.task;

import java.util.List;

import com.logicq.logicq.model.task.Task;
import com.logicq.logicq.ui.task.vo.TaskVO;

public interface ITaskManagerService {
	
	 public void addTask(TaskVO task) ;
	 
	 public void updateTask(TaskVO task);
	 
	 public List<TaskVO> getAllTasks();
	 
	 public TaskVO getTaskById(int taskId);
	 
	 public void changeTaskStatus(int taskId,String status);
	 
	 public List<TaskVO> getAllTasks(TaskVO task);

}
