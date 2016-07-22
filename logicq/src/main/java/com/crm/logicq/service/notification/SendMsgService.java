package com.crm.logicq.service.notification;

import java.util.TimerTask;

import org.springframework.stereotype.Service;

/**
 * NIHAR 21-Jul-2016 2:09:01 am
 */
@Service
public class SendMsgService extends TimerTask {

	long eventId;

	public SendMsgService() {

	}

	public SendMsgService(long eventId) {

		this.eventId = eventId;
	}

	@Override
	public void run() {

		System.out.println("SendMsgService" + eventId);
	}
}
