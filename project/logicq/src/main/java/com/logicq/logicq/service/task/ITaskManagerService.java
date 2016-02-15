package com.logicq.logicq.service.task;

import java.util.List;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.logicq.logicq.ui.task.vo.TaskVO;

public interface ITaskManagerService {
	
	
	@ExceptionHandler(Exception.class)
	 public void addTask(TaskVO task) ;
	 
	@ExceptionHandler(Exception.class)
	 public void updateTask(TaskVO task);
	 
	@ExceptionHandler(Exception.class)
	 public List<TaskVO> getAllTasks();
	 
	@ExceptionHandler(Exception.class)
	 public TaskVO getTaskById(int taskId);
	 
	@ExceptionHandler(Exception.class)
	 public void changeTaskStatus(int taskId,String status);
	 
	@ExceptionHandler(Exception.class)
	 public List<TaskVO> getAllTasks(TaskVO task);

}
