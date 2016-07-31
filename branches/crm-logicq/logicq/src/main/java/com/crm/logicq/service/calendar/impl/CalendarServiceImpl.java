package com.crm.logicq.service.calendar.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.crm.logicq.dao.calendar.ICalendarDAO;
import com.crm.logicq.dao.eventdetails.IEventDetailsDAO;
import com.crm.logicq.model.calnder.CalendarDetails;
import com.crm.logicq.model.event.EventDetails;
import com.crm.logicq.service.calendar.ICalendarService;
import com.crm.logicq.vo.event.CalendarCriteria;
import com.crm.logicq.vo.event.EventCriteria;

@Service
@Transactional
public class CalendarServiceImpl implements ICalendarService {

	@Autowired
	IEventDetailsDAO eventdetailDAO;
	
	@Autowired
	ICalendarDAO calendarDAO;
	
	
	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<EventDetails> getAllEventDetails(EventCriteria eventcriteria) throws Exception {
		return eventdetailDAO.getAllEventDetails(eventcriteria);
		
	}

	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void saveEventDetails(EventDetails eventdetails) throws Exception {
		eventdetailDAO.saveEventDetails(eventdetails);
		
	}

	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void deleteEventDetails(EventDetails eventdetails) throws Exception {
		eventdetailDAO.deleteEventDetails(eventdetails);
	}

	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<CalendarDetails> getAllEventCalendarDetails(CalendarCriteria calendarcriteria) throws Exception {
		
		return calendarDAO.getAllEventCalendarDetails(calendarcriteria);
	}

	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void saveEventCalendarDetails(CalendarDetails eventcalendardetail) throws Exception {
		calendarDAO.saveEventCalendarDetails(eventcalendardetail);
		
	}

	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void deleteEventCalendarDetails(CalendarDetails eventcalendardetail) throws Exception {
		calendarDAO.deleteEventCalendarDetails(eventcalendardetail);
	}

}
