package com.crm.logicq.service.message.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.crm.logicq.dao.message.notfication.INotificationTemplateDAO;
import com.crm.logicq.dao.message.notfication.INotificationTemplateSetupDAO;
import com.crm.logicq.model.alert.NotificationSetupDetails;
import com.crm.logicq.model.alert.NotificationTemplate;
import com.crm.logicq.service.message.INotificationService;

@Service
@Transactional
public class NotificationServiceImpl implements INotificationService {
	
	@Autowired
	INotificationTemplateDAO notificationTemplateDAO;
	
	@Autowired
	INotificationTemplateSetupDAO notificationTemplateSetupDAO;

	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void saveNotificationTemplate(NotificationTemplate notificationtemplate) throws Exception {
		notificationTemplateDAO.saveNotificationTemplate(notificationtemplate);
	}

	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void deleteNotificationTemplate(NotificationTemplate notificationtemplate) throws Exception {
		notificationTemplateDAO.deleteNotificationTemplate(notificationtemplate);
	}

	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<NotificationTemplate> getNotificationTemplates() throws Exception {
		return notificationTemplateDAO.getNotificationTemplates();
	}

	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void saveNotificationTemplateSetup(NotificationSetupDetails notificationsetupdetails) throws Exception {
		notificationTemplateSetupDAO.saveNotificationTemplateSetup(notificationsetupdetails);
		
	}

	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void deleteNotificationTemplateSetup(NotificationSetupDetails notificationsetupdetails) throws Exception {
		notificationTemplateSetupDAO.deleteNotificationTemplateSetup(notificationsetupdetails);
		
	}

	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<NotificationSetupDetails> getNotificationSetupDetails() throws Exception {
		return notificationTemplateSetupDAO.getNotificationSetupDetails();
	}

}
