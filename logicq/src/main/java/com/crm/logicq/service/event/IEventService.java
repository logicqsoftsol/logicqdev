package com.crm.logicq.service.event;

import com.crm.logicq.vo.event.EventDetailsVO;

/**
 * NIHAR 24-Jul-2016 1:35:22 am
 */

public interface IEventService {
	public void triggerEvent(EventDetailsVO eventDetailsVO) throws Exception;
	
}
