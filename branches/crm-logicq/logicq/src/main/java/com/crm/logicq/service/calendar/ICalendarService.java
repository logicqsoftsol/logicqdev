package com.crm.logicq.service.calendar;

import java.util.List;

import com.crm.logicq.model.calnder.CalendarDetails;
import com.crm.logicq.model.event.EventDetails;

public interface ICalendarService {

	public List<EventDetails> getAllEventDetails() throws Exception;

	public void saveEventDetails(EventDetails eventdetail) throws Exception;

	public void deleteEventDetails(EventDetails eventdetail) throws Exception;
	
	
	public List<CalendarDetails> getAllEventCalendarDetails() throws Exception;

	public void saveEventCalendarDetails(CalendarDetails eventcalendardetail) throws Exception;

	public void deleteEventCalendarDetails(CalendarDetails eventcalendardetail) throws Exception;
}
