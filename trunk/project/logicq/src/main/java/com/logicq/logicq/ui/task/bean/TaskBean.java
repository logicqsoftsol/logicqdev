package com.logicq.logicq.ui.task.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlDataTable;

import com.logicq.logicq.common.LogicqContextProvider;
import com.logicq.logicq.ui.task.helper.TaskManagerHelper;
import com.logicq.logicq.ui.task.vo.TaskVO;

import net.bootsfaces.component.dataTable.DataTable;

@ManagedBean(name = "taskMB")
@ViewScoped
public class TaskBean {
	
	
	private int id;
	private String name;
	private String description;
	private String priority;
	private String status;
	private String newTask;
	private String closeTask;
	private String saveTask;
	private List<TaskVO> tasklist;
	private DataTable taskTable;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getNewTask() {
		return newTask;
	}

	public void setNewTask(String newTask) {
		this.newTask = newTask;
	}

	public String getCloseTask() {
		return closeTask;
	}

	public void setCloseTask(String closeTask) {
		this.closeTask = closeTask;
	}

	public String getSaveTask() {
		return saveTask;
	}

	public void setSaveTask(String saveTask) {
		this.saveTask = saveTask;
	}
	
	public List<TaskVO> getTasklist() {
		return tasklist;
	}

	public void setTasklist(List<TaskVO> tasklist) {
		this.tasklist = tasklist;
	}

	public DataTable getTaskTable() {
		return taskTable;
	}

	public void setTaskTable(DataTable taskTable) {
		this.taskTable = taskTable;
	}
 
	public String newTask() {
		TaskManagedBean taskManagedBean=LogicqContextProvider.getApplicationContext().getBean(TaskManagedBean.class);
		TaskVO l_taskvo=LogicqContextProvider.getApplicationContext().getBean(TaskVO.class);
		TaskManagerHelper taskhelper=LogicqContextProvider.getApplicationContext().getBean(TaskManagerHelper.class);
		taskhelper.conversionUItoVO(this, l_taskvo);
		taskManagedBean.newTask(l_taskvo);
		return "sucess";
	}

	public String saveTask() {
		//TaskManagedBean taskManagedBean=LogicqContextProvider.getApplicationContext().getBean(TaskManagedBean.class);
		//taskManagedBean.
		return "sucess";
	}

}
