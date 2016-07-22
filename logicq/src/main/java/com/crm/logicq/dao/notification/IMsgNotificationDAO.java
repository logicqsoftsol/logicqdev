package com.crm.logicq.dao.notification;

import java.util.List;

import com.crm.logicq.model.alert.NotificationSetupDetails;

/**
 * NIHAR 20-Jul-2016 11:44:33 pm
 */

public interface IMsgNotificationDAO {
	public List<NotificationSetupDetails> getMsgNotifyDetails() throws Exception;
}
