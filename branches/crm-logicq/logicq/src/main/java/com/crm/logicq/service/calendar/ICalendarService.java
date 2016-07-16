package com.crm.logicq.service.calendar;

import java.util.List;

import com.crm.logicq.model.event.EventDetails;

public interface ICalendarService {

	public List<EventDetails> getAllEventDetails() throws Exception;

	public void saveEventDetails(EventDetails eventdetail) throws Exception;

	public void deleteEventDetails(EventDetails eventdetail) throws Exception;
}
