package com.crm.logicq.dao.message.notfication.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.crm.logicq.common.AbstractDAO;
import com.crm.logicq.dao.message.notfication.INotificationTemplateSetupDAO;
import com.crm.logicq.model.alert.NotificationSetupDetails;
import com.crm.logicq.model.attendance.AttendanceDetails;
import com.crm.logicq.vo.notificationtemplate.NotificationTemplateSetupCriteria;

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
	public List<NotificationSetupDetails> getNotificationSetupDetails(NotificationTemplateSetupCriteria notitempsetupcriteria) throws Exception {
		String query=" from NotificationSetupDetails ";
		if (1 == notitempsetupcriteria.getPagenumber()) {
			Long recordcount=getRecordCount(NotificationSetupDetails.class);
			notitempsetupcriteria.setTotalrecordcount(recordcount.intValue());
		}
		
		return executeQueryWithPagination(query, notitempsetupcriteria.getPagenumber(), notitempsetupcriteria.getPagesize());
	}

	

}
