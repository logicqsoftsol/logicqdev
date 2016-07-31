package com.crm.logicq.vo.notificationtemplate;

import java.io.Serializable;
import java.util.List;

import com.crm.logicq.model.alert.NotificationTemplate;

public class NotificationTemplateVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1170175286536631005L;
	
	private List<NotificationTemplate> notificationtemplatelist;
	
	private NotificationTemplateCriteria notificationtemplatecriteria;

	public List<NotificationTemplate> getNotificationtemplatelist() {
		return notificationtemplatelist;
	}

	public void setNotificationtemplatelist(List<NotificationTemplate> notificationtemplatelist) {
		this.notificationtemplatelist = notificationtemplatelist;
	}

	public NotificationTemplateCriteria getNotificationtemplatecriteria() {
		return notificationtemplatecriteria;
	}

	public void setNotificationtemplatecriteria(NotificationTemplateCriteria notificationtemplatecriteria) {
		this.notificationtemplatecriteria = notificationtemplatecriteria;
	}

	
	@Override
	public String toString() {
		return "NotificationTemplateVO [notificationtemplatelist=" + notificationtemplatelist
				+ ", notificationtemplatecriteria=" + notificationtemplatecriteria + "]";
	}
	

}
