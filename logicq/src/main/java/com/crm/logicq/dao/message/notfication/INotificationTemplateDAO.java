package com.crm.logicq.dao.message.notfication;

import java.util.List;

import com.crm.logicq.model.alert.NotificationTemplate;

public interface INotificationTemplateDAO {
	
	
	public void saveNotificationTemplate(NotificationTemplate notificationtemplate) throws Exception;
	
	public void deleteNotificationTemplate(NotificationTemplate notificationtemplate)throws Exception;
	
	public List<NotificationTemplate> getNotificationTemplates()throws Exception;
	
	public List<NotificationTemplate> getNotificationTemplatesForEntity(String entitytype) throws Exception;

}
