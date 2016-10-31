package com.logicq.commonproject.dao;

import java.util.List;

import com.logicq.commonproject.model.EventDetails;

public interface IEventDetailsDAO {
	
	List<EventDetails> getEventDetails();
	
	void saveEvent(EventDetails eventdetails);
	void updateEvent(EventDetails eventdetails);
	void deleteEvent(EventDetails eventdetails);

}
