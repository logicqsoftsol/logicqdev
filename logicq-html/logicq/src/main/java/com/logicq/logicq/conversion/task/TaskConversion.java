package com.logicq.logicq.conversion.task;

import java.util.ArrayList;
import java.util.List;

import com.logicq.logicq.common.LogicqContextProvider;
import com.logicq.logicq.model.task.Task;
import com.logicq.logicq.ui.task.vo.TaskVO;


public class TaskConversion {

	private static TaskConversion instance;

	public static TaskConversion getInstance() {
		if (null == instance) {
			instance = new TaskConversion();
		}
		return instance;
	}


	public Task conversionFromVOtoEntity(TaskVO p_taskvo, Task p_task) {
		p_task.setName(p_taskvo.getName());
		p_task.setPriority(p_taskvo.getPriority());
		p_task.setDescription(p_taskvo.getDescription());
		p_task.setStatus(p_taskvo.getStatus());
		return p_task;
	}

	public TaskVO conversionFromEntitytoVO(Task p_task, TaskVO p_taskvo) {
		p_taskvo.setId(p_task.getId());
		p_taskvo.setName(p_task.getName());
		p_taskvo.setPriority(p_task.getPriority());
		p_taskvo.setDescription(p_task.getDescription());
		p_taskvo.setStatus(p_task.getStatus());
		return p_taskvo;
	}

	public Task handleConversionVOtoEntityWithContext(TaskVO p_taskvo) {
		Task taskentity = null;
		if (null != LogicqContextProvider.getApplicationContext()) {
			taskentity = LogicqContextProvider.getApplicationContext().getBean(
					Task.class);
		}
		if(null==taskentity){
			taskentity=new Task();
		}
		return conversionFromVOtoEntity(p_taskvo, taskentity);
	}

	public List<TaskVO> handleConversionForTaskList(List<Task> p_tasklist) {
		List<TaskVO> l_taskvolist = new ArrayList<TaskVO>();
		for (Task task : p_tasklist) {
			TaskVO l_taskvo = new TaskVO();
			l_taskvo = conversionFromEntitytoVO(task,l_taskvo);
			l_taskvolist.add(l_taskvo);
		}
		return l_taskvolist;
	}
	
	
	
	
	public TaskVO handleConversionEntitytoVOWithContext(Task p_task) {
		TaskVO l_taskvo = null;
		if (null != LogicqContextProvider.getApplicationContext()) {
			l_taskvo = LogicqContextProvider.getApplicationContext().getBean(
					TaskVO.class);
		}
		if(null==l_taskvo){
			l_taskvo=new TaskVO();
		}
		return conversionFromEntitytoVO(p_task, l_taskvo);
	}
	
}
