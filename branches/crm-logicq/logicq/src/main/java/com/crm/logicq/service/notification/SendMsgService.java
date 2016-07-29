package com.crm.logicq.service.notification;

import java.util.TimerTask;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.logicq.common.LogicqContextProvider;
import com.crm.logicq.dao.readfile.IReadFileDAO;
import com.crm.logicq.dao.readfile.ReadFileDAO;
import com.crm.logicq.security.service.UserService;
import com.crm.logicq.service.event.IEventService;
import com.crm.logicq.service.event.impl.EventService;
import com.crm.logicq.service.user.IUserService;
import com.crm.logicq.vo.event.EventDetailsVO;

/**
 * NIHAR 21-Jul-2016 2:09:01 am
 */
@Service
@Transactional
public class SendMsgService extends TimerTask {
	
	private final static Logger logger = Logger.getLogger(SendMsgService.class);
	
	
	EventDetailsVO eventDetailsVO;

	public SendMsgService() {

	}

	public SendMsgService(EventDetailsVO eventDetailsVO) {

		this.eventDetailsVO = eventDetailsVO;
	}

	@Override
	public void run() {

		try {
			ApplicationContext context = LogicqContextProvider.getApplicationContext();
			IEventService eventService = (IEventService) context.getBean("eventService");
			eventService.triggerEvent(eventDetailsVO);
		} catch (Exception ex) {
			logger.error(" IEventService :"+ex.getMessage(),ex);
		}
	}
}
