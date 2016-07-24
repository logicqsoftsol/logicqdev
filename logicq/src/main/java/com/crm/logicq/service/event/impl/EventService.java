package com.crm.logicq.service.event.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.logicq.service.event.IEventService;
import com.crm.logicq.vo.event.EventDetailsVO;

@Service("eventService")
@Transactional
public class EventService implements IEventService {

	@Override
	public void triggerEvent(EventDetailsVO eventDetailsVO) {

		System.out.println("event id"+eventDetailsVO.getEventID());
		System.out.println("event type"+eventDetailsVO.getEventtype());
		System.out.println("temp text"+eventDetailsVO.getTemplatetext());
		 
	}
}
