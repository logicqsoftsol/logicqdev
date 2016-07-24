package com.crm.logicq.service.readfile;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.crm.logicq.dao.notification.IMsgNotificationDAO;
import com.crm.logicq.dao.readfile.IReadFileDAO;
import com.crm.logicq.model.alert.NotificationSetupDetails;
import com.crm.logicq.model.user.CardReadDetails;
import com.crm.logicq.service.notification.SendMsgService;
import com.crm.logicq.service.user.IUserService;
import com.crm.logicq.vo.event.EventDetailsVO;

/**
 * @author Nihar
 */
@Service("ScheduleService")
public class SchedulerService {

	@Autowired
	IMsgNotificationDAO msgNotificationDAO;
	@Autowired
	IReadFileDAO readFileDAO;
	@Autowired
	IUserService userservice;

	@ExceptionHandler(Exception.class)
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public void readAccessFile() throws Exception {

		List<CardReadDetails> userCardDeatils = readFileDAO.readAccessFile();
		userservice.triggerSMS(userCardDeatils);
	}

	@ExceptionHandler(Exception.class)
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public void performTask() throws Exception {

		System.out.println("performTask");
		List<NotificationSetupDetails> notificationList = msgNotificationDAO.getMsgNotifyDetails();
		for (NotificationSetupDetails notificationSetupDetails : notificationList) {
			int msgSendTime = notificationSetupDetails.getMsgsendingtime();
			int startTimeHr = msgSendTime / 100;
			int startTimeMin = msgSendTime % 100;
			EventDetailsVO eventDetailsVO = new EventDetailsVO();
			eventDetailsVO.setEventID(notificationSetupDetails.getNotificationtemplate().getEventdetails().getEventid());
			eventDetailsVO.setEventtype(notificationSetupDetails.getNotificationtemplate().getEventdetails().getEventtype());
			eventDetailsVO.setTemplatetext(notificationSetupDetails.getNotificationtemplate().getTemplatetext());
			eventDetailsVO.setEventName(notificationSetupDetails.getNotificationtemplate().getEventdetails().getEventname());
			prepareCornJOB(startTimeHr, startTimeMin, eventDetailsVO);
		}
	}

	public void prepareCornJOB(int hr, int min, EventDetailsVO eventDetailsVO) {

		System.out.println("prepare cron job");
		Calendar today = Calendar.getInstance();
		today.set(Calendar.HOUR_OF_DAY, hr);
		today.set(Calendar.MINUTE, min);
		today.set(Calendar.SECOND, 0);
		TimerTask task = new SendMsgService(eventDetailsVO);
		Timer timer = new Timer();
		timer.schedule(task, today.getTime());
	}
}