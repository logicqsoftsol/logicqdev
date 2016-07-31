package com.crm.logicq.dao.eventdetails;

import java.util.List;

import com.crm.logicq.model.event.EventDetails;
import com.crm.logicq.vo.event.EventCriteria;

public interface IEventDetailsDAO {
	
	public List<EventDetails> getAllEventDetails(EventCriteria eventcriteria) throws Exception;	
	
	public EventDetails getEventDetails(Long eventid) throws Exception;
	
	public void saveEventDetails(EventDetails eventdetails) throws Exception;

	public void deleteEventDetails(EventDetails eventdetails) throws Exception;

}
