package com.crm.logicq.dao.eventdetails;

import java.util.List;

import com.crm.logicq.model.event.EventDetails;

public interface IEventDetails {
	
	public List<EventDetails> getAllEventDetails() throws Exception;	
	
	public EventDetails getEventDetails(Long eventid) throws Exception;
	
	public void saveEventDetails(EventDetails eventdetails) throws Exception;

	public void deleteEventDetails(EventDetails eventdetails) throws Exception;

}
