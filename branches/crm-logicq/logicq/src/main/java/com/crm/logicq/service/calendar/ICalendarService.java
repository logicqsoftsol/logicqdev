package com.crm.logicq.service.calendar;

import java.util.List;

import com.crm.logicq.model.calnder.CalendarDetails;
import com.crm.logicq.model.event.EventDetails;
import com.crm.logicq.vo.event.CalendarCriteria;
import com.crm.logicq.vo.event.EventCriteria;

public interface ICalendarService {

	public List<EventDetails> getAllEventDetails(EventCriteria eventcriteria) throws Exception;

	public void saveEventDetails(EventDetails eventdetail) throws Exception;

	public void deleteEventDetails(EventDetails eventdetail) throws Exception;
	
	
	public List<CalendarDetails> getAllEventCalendarDetails(CalendarCriteria calendarcriteria) throws Exception;

	public void saveEventCalendarDetails(CalendarDetails eventcalendardetail) throws Exception;

	public void deleteEventCalendarDetails(CalendarDetails eventcalendardetail) throws Exception;
}
