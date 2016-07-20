package com.crm.logicq.dao.message.notfication;

import java.util.List;

import com.crm.logicq.model.alert.NotificationSetupDetails;

public interface INotificationTemplateSetupDAO {
	
	public void saveNotificationTemplateSetup(NotificationSetupDetails notificationsetupdetails) throws Exception;
	
	public void deleteNotificationTemplateSetup(NotificationSetupDetails notificationsetupdetails)throws Exception;
	
	public List<NotificationSetupDetails> getNotificationSetupDetails()throws Exception;

}
