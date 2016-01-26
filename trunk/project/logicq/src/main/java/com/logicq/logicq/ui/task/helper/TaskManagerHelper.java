package com.logicq.logicq.ui.task.helper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.logicq.logicq.common.LogicqContextProvider;
import com.logicq.logicq.facade.task.ITaskManagerFacade;
import com.logicq.logicq.ui.task.bean.TaskBean;
import com.logicq.logicq.ui.task.vo.TaskVO;

public class TaskManagerHelper {
	
    @Autowired
	ITaskManagerFacade taskManagerFacade;

	public ITaskManagerFacade getTaskManagerFacade() {
		return taskManagerFacade;
	}

	public void setTaskManagerFacade(ITaskManagerFacade taskManagerFacade) {
		this.taskManagerFacade = taskManagerFacade;
	}


	public void newtask(TaskVO p_task) {
		taskManagerFacade.addTask(p_task);
	}

	public void closetask(TaskVO p_task) {
		taskManagerFacade.changeTaskStatus(p_task.getId(), p_task.getStatus());
	}

	public List<TaskVO> fetchAllTask(TaskVO p_task){
		return taskManagerFacade.getAllTasks(p_task);
	}
	
	public TaskVO conversionUItoVO(TaskBean p_taskbean, TaskVO p_taskvo) {
		p_taskvo.setId(p_taskbean.getId());
		p_taskvo.setName(p_taskbean.getName());
		p_taskvo.setPriority(p_taskbean.getPriority());
		p_taskvo.setStatus(p_taskbean.getStatus());
		p_taskvo.setDescription(p_taskbean.getDescription());
		return p_taskvo;
	}

	public TaskBean conversionVOtoUI(TaskVO p_taskvo, TaskBean p_taskbean) {
		p_taskbean.setId(p_taskvo.getId());
		p_taskbean.setName(p_taskvo.getName());
		p_taskbean.setPriority(p_taskvo.getPriority());
		p_taskbean.setStatus(p_taskvo.getStatus());
		p_taskbean.setDescription(p_taskvo.getDescription());
		return p_taskbean;
	}
	
	public void displayTaskList(List<TaskVO> tasllist){
		for(TaskVO taskVO:tasllist){
			taskVO=taskManagerFacade.getTaskById(taskVO.getId());
		}
		TaskBean l_taskbean=	LogicqContextProvider.getApplicationContext().getBean(TaskBean.class);
		l_taskbean.setTasklist(tasllist);
	}
}
