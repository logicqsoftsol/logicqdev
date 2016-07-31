package com.crm.logicq.controller.admin.eventdetails;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crm.logicq.model.calnder.CalendarDetails;
import com.crm.logicq.model.common.CommonProperty;
import com.crm.logicq.model.event.EventDetails;
import com.crm.logicq.service.calendar.ICalendarService;
import com.crm.logicq.vo.event.CalendarCriteria;
import com.crm.logicq.vo.event.CalendarVO;
import com.crm.logicq.vo.event.EventCriteria;
import com.crm.logicq.vo.event.EventVO;

@RestController
@RequestMapping("/admin/calendar")
public class CalendarController {
	
	@Autowired
	ICalendarService calendarService;
	
	@RequestMapping(value = "/event/saveEventDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EventVO> saveEventDetails(@RequestBody EventDetails event) {
		EventVO eventvo=new EventVO();
		EventCriteria eventcriteria=new EventCriteria();
		eventcriteria.setPagesize(15);
		eventcriteria.setPagenumber(1);

		try {
			if(null!=event){
			calendarService.saveEventDetails(event);
			List<EventDetails> eventdetails=calendarService.getAllEventDetails(eventcriteria);
			eventvo.setEventdetails(eventdetails);
			eventvo.setEventcriteria(eventcriteria);
			}else{
				return	new ResponseEntity<EventVO>(eventvo, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception ex) {
			return new ResponseEntity<EventVO>(eventvo, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 
		
	
		return new ResponseEntity<EventVO>(eventvo, HttpStatus.OK);
	}

	@RequestMapping(value = "/event/deleteEventDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EventVO> deleteEventDetails(@RequestBody EventDetails event) {
		EventVO eventvo=new EventVO();
		EventCriteria eventcriteria=new EventCriteria();
		eventcriteria.setPagesize(15);
		eventcriteria.setPagenumber(1);
		try {
			if(null!=event){
			calendarService.deleteEventDetails(event);
			List<EventDetails> eventdetails=calendarService.getAllEventDetails(eventcriteria);
			eventvo.setEventdetails(eventdetails);
			eventvo.setEventcriteria(eventcriteria);
			}else{
				return	new ResponseEntity<EventVO>(eventvo, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception ex) {
			return new ResponseEntity<EventVO>(eventvo, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<EventVO>(eventvo, HttpStatus.OK);
	}

	@RequestMapping(value = "/event/getAllEventDetails/{pagesize}/{pageno}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EventVO> getAllEventDetails(@PathVariable int pagesize ,@PathVariable int pageno) {
		EventVO eventvo=new EventVO();
		EventCriteria eventcriteria=new EventCriteria();
		eventcriteria.setPagesize(pagesize);
		eventcriteria.setPagenumber(pageno);
		try {
			List<EventDetails> eventdetails = calendarService.getAllEventDetails(eventcriteria);
			eventvo.setEventdetails(eventdetails);
			eventvo.setEventcriteria(eventcriteria);
		} catch (Exception ex) {
			return new ResponseEntity<EventVO>(eventvo, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<EventVO>(eventvo, HttpStatus.OK);
	}

	
	
	@RequestMapping(value = "/getAllCalendarDetails/{pagesize}/{pageno}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CalendarVO> getAllCalendarDetails(@PathVariable int pagesize ,@PathVariable int pageno) {
		CalendarVO calendarvo=new CalendarVO();
		CalendarCriteria calendarcriteria=new CalendarCriteria();
		calendarcriteria.setPagesize(pagesize);
		calendarcriteria.setPagenumber(pageno);
		try {
			List<CalendarDetails>	calendardetailslist = calendarService.getAllEventCalendarDetails(calendarcriteria);
			calendarvo.setCalendardetailslist(calendardetailslist);
			calendarvo.setCalendarcriteria(calendarcriteria);
		} catch (Exception ex) {
			return new ResponseEntity<CalendarVO>(calendarvo, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<CalendarVO>(calendarvo, HttpStatus.OK);
	}

	@RequestMapping(value = "/saveCalendarDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CalendarVO> saveCalendarDetails(@RequestBody CalendarDetails calendarDetails) {
		CalendarVO calendarvo=new CalendarVO();
		CalendarCriteria calendarcriteria=new CalendarCriteria();
		calendarcriteria.setPagesize(15);
		calendarcriteria.setPagenumber(1);
		try {
			calendarService.saveEventCalendarDetails(calendarDetails);
			List<CalendarDetails>	calendardetails = calendarService.getAllEventCalendarDetails(calendarcriteria);
			calendarvo.setCalendardetailslist(calendardetails);
			calendarvo.setCalendarcriteria(calendarcriteria);
		} catch (Exception ex) {
			return new ResponseEntity<CalendarVO>(calendarvo, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<CalendarVO>(calendarvo, HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteCalendarDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CalendarVO> deleteCalendarDetails(@RequestBody CalendarDetails calendarDetails) {
		CalendarVO calendarvo=new CalendarVO();
		try {
		
			CalendarCriteria calendarcriteria=new CalendarCriteria();
			calendarcriteria.setPagesize(15);
			calendarcriteria.setPagenumber(1);
			calendarService.deleteEventCalendarDetails(calendarDetails);
			List<CalendarDetails>	calendardetails = calendarService.getAllEventCalendarDetails(calendarcriteria);
			calendarvo.setCalendardetailslist(calendardetails);
			calendarvo.setCalendarcriteria(calendarcriteria);
		} catch (Exception ex) {
			return new ResponseEntity<CalendarVO>(calendarvo, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<CalendarVO>(calendarvo, HttpStatus.OK);
	}
}
