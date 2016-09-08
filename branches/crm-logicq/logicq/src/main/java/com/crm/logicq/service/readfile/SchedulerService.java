package com.crm.logicq.service.readfile;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.crm.logicq.constant.DAYConstant;
import com.crm.logicq.constant.DAYEnum;
import com.crm.logicq.dao.notification.IMsgNotificationDAO;
import com.crm.logicq.dao.readfile.IReadFileDAO;
import com.crm.logicq.model.alert.NotificationSetupDetails;
import com.crm.logicq.service.notification.SendMsgService;
import com.crm.logicq.service.user.IUserService;
import com.crm.logicq.vo.event.EventDetailsVO;

/**
 * @author Nihar
 */
@Service("ScheduleService")
public class SchedulerService  {

	@Autowired
	IMsgNotificationDAO msgNotificationDAO;
	@Autowired
	IReadFileDAO readFileDAO;
	@Autowired
	IUserService userservice;
    public static boolean startscheduler=false;
	

	@ExceptionHandler(Exception.class)
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public void performTask() throws Exception {
		List<NotificationSetupDetails> notificationList = msgNotificationDAO.getMsgNotifyDetails();
		for (NotificationSetupDetails notificationSetupDetails : notificationList) {
			int msgSendTime = notificationSetupDetails.getMsgsendingtime();
			int startTimeHr = msgSendTime / 100;
			int startTimeMin = msgSendTime % 100;
			setScheduler(notificationSetupDetails.getDaylist());
			if (startscheduler) {
				EventDetailsVO eventDetailsVO = new EventDetailsVO();
				eventDetailsVO.setEventID(notificationSetupDetails.getNotificationtemplate().getEventdetails().getEventid());
				eventDetailsVO.setEventtype(notificationSetupDetails.getNotificationtemplate().getEventdetails().getEventtype());
				eventDetailsVO.setTemplatetext(notificationSetupDetails.getNotificationtemplate().getTemplatetext());
				eventDetailsVO.setEventName(notificationSetupDetails.getNotificationtemplate().getEventdetails().getEventname());
				eventDetailsVO.setApplicablefor(notificationSetupDetails.getNotificationtemplate().getEventdetails().getApplicablefor());
				prepareCornJOB(startTimeHr, startTimeMin, eventDetailsVO);
			}
		}
	}

	public void prepareCornJOB(int hr, int min, EventDetailsVO eventDetailsVO) {
		TimeZone timeZoneIndia = TimeZone.getTimeZone("Asia/Kolkata");
		Calendar today = Calendar.getInstance();
		today.setTimeZone(timeZoneIndia);
		today.set(Calendar.HOUR_OF_DAY, hr);
		today.set(Calendar.MINUTE, min);
		today.set(Calendar.SECOND, 0);
		TimerTask task = new SendMsgService(eventDetailsVO);
		Timer timer = new Timer();
		timer.schedule(task, today.getTime());
	}

	public void setScheduler(String dayslist) {

		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		String today = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());
		if (dayslist.contains(DAYConstant.EACHDAY)) {
			startscheduler = true;
		}
		else {
			 if (dayslist.contains(DAYConstant.WEEKDAYS)) {
				if (Calendar.getInstance().get(Calendar.DAY_OF_WEEK) >= DAYEnum.MONDAY.value
				    && Calendar.getInstance().get(Calendar.DAY_OF_WEEK) <= DAYEnum.FRIDAY.value) {
					startscheduler = true;
				}
			 } else {
				if (dayslist.contains(today)) {
					startscheduler = true;
				}
			 }
			 if (dayslist.contains(DAYConstant.WEEKENDS)) {
				if (Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == DAYEnum.SATURDAY.value
				    || Calendar.getInstance().get(Calendar.DAY_OF_WEEK) == DAYEnum.SUNDAY.value) {
					startscheduler = true;
				}
			 }
		   }
	}
}