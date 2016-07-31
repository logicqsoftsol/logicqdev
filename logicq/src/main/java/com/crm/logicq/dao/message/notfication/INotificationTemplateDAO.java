package com.crm.logicq.dao.message.notfication;

import java.util.List;

import com.crm.logicq.model.alert.NotificationTemplate;
import com.crm.logicq.vo.notificationtemplate.NotificationTemplateCriteria;

public interface INotificationTemplateDAO {
	
	
	public void saveNotificationTemplate(NotificationTemplate notificationtemplate) throws Exception;
	
	public void deleteNotificationTemplate(NotificationTemplate notificationtemplate)throws Exception;
	
	public List<NotificationTemplate> getNotificationTemplates(NotificationTemplateCriteria notificationtemplatecriteria)throws Exception;
	
	public List<NotificationTemplate> getNotificationTemplatesForEntity(String entitytype) throws Exception;

}
