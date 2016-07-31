package com.crm.logicq.dao.message.notfication.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.crm.logicq.common.AbstractDAO;
import com.crm.logicq.dao.message.notfication.INotificationTemplateDAO;
import com.crm.logicq.model.alert.NotificationTemplate;
import com.crm.logicq.model.attendance.AttendanceDetails;
import com.crm.logicq.vo.notificationtemplate.NotificationTemplateCriteria;

@Repository
public class NotificationTemplateDAO  extends AbstractDAO<NotificationTemplate> implements INotificationTemplateDAO{

	@Override
	public void saveNotificationTemplate(NotificationTemplate notificationtemplate) throws Exception {
		saveOrUpdate(notificationtemplate);
	}

	@Override
	public void deleteNotificationTemplate(NotificationTemplate notificationtemplate) throws Exception {
		delete(notificationtemplate);
		
	}

	@Override
	public List<NotificationTemplate> getNotificationTemplates(NotificationTemplateCriteria notificationtemplatecriteria) throws Exception {
		String query=" from NotificationTemplate ";
		if (1 == notificationtemplatecriteria.getPagenumber()) {
			Long recordcount=getRecordCount(AttendanceDetails.class);
			notificationtemplatecriteria.setTotalrecordcount(recordcount.intValue());
		}
		return executeQueryWithPagination(query, notificationtemplatecriteria.getPagenumber(), notificationtemplatecriteria.getPagesize());
	}

	@Override
	public List<NotificationTemplate> getNotificationTemplatesForEntity(String entitytype) throws Exception {
		String query=" from NotificationTemplate notitemp where notitemp.eventdetails.applicablefor='"+entitytype+"'";
		return executeQuery(query);
	}

}
