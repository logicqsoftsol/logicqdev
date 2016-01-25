package com.logicq.logicq.ui.task.bean;

import com.logicq.logicq.common.LogicqContextProvider;
import com.logicq.logicq.ui.task.helper.TaskManagerHelper;
import com.logicq.logicq.ui.task.vo.TaskVO;

public class TaskManagedBean {
	
	public String newTask(TaskVO p_task) {
		TaskManagerHelper taskbeanhelper=LogicqContextProvider.getApplicationContext().getBean(TaskManagerHelper.class);
		taskbeanhelper.newtask(p_task);
		return "sucess";
	}

	
	public String closeTask(TaskVO p_task) {
		TaskManagerHelper taskbeanhelper=LogicqContextProvider.getApplicationContext().getBean(TaskManagerHelper.class);
		taskbeanhelper.newtask(p_task);
		return "sucess";
	}

}
