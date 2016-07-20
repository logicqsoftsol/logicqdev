package com.crm.logicq.service.message;

import java.util.List;

import com.crm.logicq.model.alert.NotificationSetupDetails;
import com.crm.logicq.model.alert.NotificationTemplate;

public interface INotificationService {
	
	public void saveNotificationTemplate(NotificationTemplate notificationtemplate) throws Exception;
	
	public void deleteNotificationTemplate(NotificationTemplate notificationtemplate)throws Exception;
	
	public List<NotificationTemplate> getNotificationTemplates()throws Exception;
	
	public void saveNotificationTemplateSetup(NotificationSetupDetails notificationsetupdetails) throws Exception;
	
	public void deleteNotificationTemplateSetup(NotificationSetupDetails notificationsetupdetails)throws Exception;
	
	public List<NotificationSetupDetails> getNotificationSetupDetails()throws Exception;

}
