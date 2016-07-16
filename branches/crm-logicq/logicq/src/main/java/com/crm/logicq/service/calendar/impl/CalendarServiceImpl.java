package com.crm.logicq.service.calendar.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.crm.logicq.dao.eventdetails.IEventDetails;
import com.crm.logicq.model.event.EventDetails;
import com.crm.logicq.service.calendar.ICalendarService;

@Service
@Transactional
public class CalendarServiceImpl implements ICalendarService {

	@Autowired
	IEventDetails eventdetail;
	
	
	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<EventDetails> getAllEventDetails() throws Exception {
		return eventdetail.getAllEventDetails();
		
	}

	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void saveEventDetails(EventDetails eventdetails) throws Exception {
		eventdetail.saveEventDetails(eventdetails);
		
	}

	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void deleteEventDetails(EventDetails eventdetails) throws Exception {
		eventdetail.deleteEventDetails(eventdetails);
	}

}
