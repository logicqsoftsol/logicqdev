package com.crm.logicq.controller.admin.eventdetails;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crm.logicq.model.calnder.CalendarDetails;
import com.crm.logicq.model.event.EventDetails;

@RestController
@RequestMapping("/admin/calendar")
public class CalendarController {
	
	
	@RequestMapping(value = "/saveEventDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EventDetails>> saveEventDetails(@RequestBody EventDetails eventdteails) {
		List<EventDetails> eventdetails = new ArrayList<EventDetails>();
        System.out.println("saveEventDetails()");
		return new ResponseEntity<List<EventDetails>>(eventdetails, HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteEventDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EventDetails>> deleteEventDetails(@RequestBody EventDetails eventdteails) {
		List<EventDetails> eventdetails = new ArrayList<EventDetails>();
		System.out.println("deleteEventDetails()");
		return new ResponseEntity<List<EventDetails>>(eventdetails, HttpStatus.OK);
	}

	@RequestMapping(value = "/getAllEventDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EventDetails>> getAllEventDetails() {
		List<EventDetails> eventdetails = new ArrayList<EventDetails>();
		System.out.println("getAllEventDetails()");
		return new ResponseEntity<List<EventDetails>>(eventdetails, HttpStatus.OK);
	}

	
	
	@RequestMapping(value = "/getAllCalendarDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CalendarDetails>> getAllCalendarDetails() {
		List<CalendarDetails> calendardetails = new ArrayList<CalendarDetails>();
		System.out.println("getAllCalendarDetails()");
		return new ResponseEntity<List<CalendarDetails>>(calendardetails, HttpStatus.OK);
	}

	@RequestMapping(value = "/getCalendarDetailsforCriteria", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CalendarDetails>> getCalendarDetailsforCriteria() {
		List<CalendarDetails> calendardetails = new ArrayList<CalendarDetails>();
		System.out.println("getCalendarDetailsforCriteria()");
		return new ResponseEntity<List<CalendarDetails>>(calendardetails, HttpStatus.OK);
	}

	@RequestMapping(value = "/saveCalendarDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CalendarDetails>> saveCalendarDetails(@RequestBody CalendarDetails calendarDetails) {
		List<CalendarDetails> calendardetails = new ArrayList<CalendarDetails>();
		System.out.println("saveCalendarDetails()");
		return new ResponseEntity<List<CalendarDetails>>(calendardetails, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deleteCalendarDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CalendarDetails>> deleteCalendarDetails(@RequestBody CalendarDetails calendarDetails) {
		List<CalendarDetails> calendardetails = new ArrayList<CalendarDetails>();
		System.out.println("deleteCalendarDetails()");            
		return new ResponseEntity<List<CalendarDetails>>(calendardetails, HttpStatus.OK);
	}
}
