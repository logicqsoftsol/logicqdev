package com.crm.logicq.dao.notification.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
		int cur_time = Integer.valueOf((sdf.format(cal.getTime())).toString());
		cal.add(Calendar.MINUTE, 15);
		int added_time = Integer.valueOf((sdf.format(cal.getTime())).toString());
		Session session = getCurrentSession();
		String hql = "FROM NotificationSetupDetails nsd WHERE DATE_FORMAT(NOW(),'%Y-%m-%d') BETWEEN nsd.msgsendfromdate and nsd.msgsendtodate and nsd.msgsendingtime BETWEEN "+cur_time+" AND "+added_time;
        Query query = session.createQuery(hql);
		List<NotificationSetupDetails> results = query.list();
		return results;
	}
}
