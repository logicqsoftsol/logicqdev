package com.crm.logicq.dao.notification.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.crm.logicq.common.AbstractDAO;
import com.crm.logicq.dao.notification.IMsgNotificationDAO;
import com.crm.logicq.model.alert.NotificationSetupDetails;

/**
 * NIHAR 20-Jul-2016 11:46:09 pm
 */
@Repository
public class MsgNotificationDAO extends AbstractDAO<NotificationSetupDetails> implements IMsgNotificationDAO {

	@Override
	public List<NotificationSetupDetails> getMsgNotifyDetails() throws Exception {

		Session session = getCurrentSession();
		String hql = "FROM NotificationSetupDetails nsd WHERE SYSDATE() BETWEEN nsd.msgsendfromdate and nsd.msgsendtodate ";
		Query query = session.createQuery(hql);
		List<NotificationSetupDetails> results = query.list();
		return results;
	}
}
