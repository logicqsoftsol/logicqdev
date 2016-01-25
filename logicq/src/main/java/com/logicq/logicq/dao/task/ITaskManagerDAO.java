package com.logicq.logicq.dao.task;

import java.util.List;

import com.logicq.logicq.model.task.Task;

public interface ITaskManagerDAO {

	
	 public void addTask(Task task) ;
	 
	 public void updateTask(Task task);
	 
	 public List<Task> getAllTasks();
	 
	 public Task getTaskById(int taskId);
	 
	 public List<Task> getAllTasks(Task task);
	 
}
