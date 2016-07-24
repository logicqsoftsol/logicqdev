package com.crm.logicq.dao.message.notfication.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.crm.logicq.common.AbstractDAO;
import com.crm.logicq.dao.message.notfication.INotificationTemplateSetupDAO;
import com.crm.logicq.model.alert.NotificationSetupDetails;

@Repository
public class NotificationTemplateSetupDAO extends AbstractDAO<NotificationSetupDetails> implements INotificationTemplateSetupDAO{

	@Override
	public void saveNotificationTemplateSetup(NotificationSetupDetails notificationsetupdetails) throws Exception {
		saveOrUpdate(notificationsetupdetails);
	}

	@Override
	public void deleteNotificationTemplateSetup(NotificationSetupDetails notificationsetupdetails) throws Exception {
		
		delete(notificationsetupdetails);
	}

	@Override
	public List<NotificationSetupDetails> getNotificationSetupDetails() throws Exception {
		return (List<NotificationSetupDetails>) loadClass(NotificationSetupDetails.class);
	}

	

}
