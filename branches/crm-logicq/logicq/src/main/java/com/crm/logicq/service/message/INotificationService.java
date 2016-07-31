package com.crm.logicq.service.message;

import java.util.List;

import com.crm.logicq.model.alert.NotificationSetupDetails;
import com.crm.logicq.model.alert.NotificationTemplate;
import com.crm.logicq.vo.notificationtemplate.NotificationTemplateCriteria;
import com.crm.logicq.vo.notificationtemplate.NotificationTemplateSetupCriteria;

public interface INotificationService {
	
	public void saveNotificationTemplate(NotificationTemplate notificationtemplate) throws Exception;
	
	public void deleteNotificationTemplate(NotificationTemplate notificationtemplate)throws Exception;
	
	public List<NotificationTemplate> getNotificationTemplates(NotificationTemplateCriteria notificationtemplatecriteria)throws Exception;
	
	public List<NotificationTemplate> getNotificationTemplatesForEntity(String entitytype) throws Exception;
	
	public void saveNotificationTemplateSetup(NotificationSetupDetails notificationsetupdetails) throws Exception;
	
	public void deleteNotificationTemplateSetup(NotificationSetupDetails notificationsetupdetails)throws Exception;
	
	public List<NotificationSetupDetails> getNotificationSetupDetails(NotificationTemplateSetupCriteria notitempsetupcriteria)throws Exception;
	
	public List<NotificationSetupDetails> getNotificationSetupDetailsForEntity(String entitytype)throws Exception;

}
