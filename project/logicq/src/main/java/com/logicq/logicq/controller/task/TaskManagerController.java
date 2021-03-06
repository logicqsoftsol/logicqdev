package com.logicq.logicq.controller.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.logicq.logicq.service.task.ITaskManagerService;
import com.logicq.logicq.ui.task.vo.TaskVO;


//@RestController
public class TaskManagerController {
	
   @Autowired
	ITaskManagerService taskManagerFacade;

	 @RequestMapping(value="/tasks",method = RequestMethod.GET,headers="Accept=application/json")
	 public List<TaskVO> getAllTasks() {	 
	  List<TaskVO> tasks=taskManagerFacade.getAllTasks();
	  return tasks;
	
	 }
	
	 
	 @RequestMapping(value="/tasks/{taskvo}",method = RequestMethod.POST,headers="Accept=application/json")
	 public List<TaskVO> changeTaskStatus(@PathVariable TaskVO taskvo)  {	
		 taskManagerFacade.changeTaskStatus(taskvo.getId(),taskvo.getStatus());		 
		 return taskManagerFacade.getAllTasks();
		 
	 }
	 
	 @RequestMapping(value="/tasks/insert/{taskvo}",method = RequestMethod.POST,headers="Accept=application/json")
	 public List<TaskVO> addTask(@PathVariable TaskVO taskvo)  {	
		 taskManagerFacade.addTask(taskvo);
		return taskManagerFacade.getAllTasks();
		 
	 }	 	 	
}
