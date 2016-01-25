package com.logicq.logicq.ui.notification.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.logicq.logicq.common.LogicqContextProvider;
import com.logicq.logicq.ui.task.helper.TaskManagerHelper;
import com.logicq.logicq.ui.task.vo.TaskVO;

@ManagedBean(name = "notificationMB")
@SessionScoped
public class NotificationBean implements Serializable{
	private static final long serialVersionUID = 9075985674980431309L;
	
	private String notificationcount;
    private Integer count=0;
    List<TaskVO> tasklist=null; 
	public String getNotificationcount() {
		return notificationcount;
	}

	public void setNotificationcount(String notificationcount) {
		this.notificationcount = notificationcount;
	}

	public void pollNotification(){
		if(LogicqContextProvider.getApplicationmap().size()>0){
		count= LogicqContextProvider.getApplicationmap().size();
		}
		notificationcount=String.valueOf(count);
	}
	
	public void notificationdetailsAction(){
		TaskManagerHelper l_taskHelper=LogicqContextProvider.getApplicationContext().getBean(TaskManagerHelper.class);
		 Map<String, Object> l_notificationMap=LogicqContextProvider.getApplicationmap();
		 tasklist=new ArrayList<TaskVO>();
		 for (Map.Entry<String, Object> entry : l_notificationMap.entrySet())
		 {
			TaskVO l_taskvo=new TaskVO(); 
			l_taskvo.setId(Integer.valueOf(entry.getKey() ));
			tasklist.add(l_taskvo);
		 }
		 
		l_taskHelper.displayTaskList(tasklist);
		
	}
}
