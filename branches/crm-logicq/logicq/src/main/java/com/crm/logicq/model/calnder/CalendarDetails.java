package com.crm.logicq.model.calnder;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.crm.logicq.model.event.EventDetails;
import com.crm.logicq.model.user.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "CALENDAR_DETAILS")
public class CalendarDetails {
	

	@Id
    @Column(name = "ID",unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long calendarid;
	

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="EVENT_ID")
	private EventDetails eventdetails;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "EVENT_START_DATE")
	private  Date  eventstartdate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "EVENT_END_DATE")
	private  Date  eventenddate;
	
	@Column(name = "COMMENTS")
	private String comments;

	public Long getCalendarid() {
		return calendarid;
	}

	public void setCalendarid(Long calendarid) {
		this.calendarid = calendarid;
	}


	public Date getEventstartdate() {
		return eventstartdate;
	}

	public void setEventstartdate(Date eventstartdate) {
		this.eventstartdate = eventstartdate;
	}

	public Date getEventenddate() {
		return eventenddate;
	}

	public void setEventenddate(Date eventenddate) {
		this.eventenddate = eventenddate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public EventDetails getEventdetails() {
		return eventdetails;
	}

	public void setEventdetails(EventDetails eventdetails) {
		this.eventdetails = eventdetails;
	}

	@Override
	public String toString() {
		return "CalendarDetails [calendarid=" + calendarid + ", eventdetails=" + eventdetails + ", eventstartdate="
				+ eventstartdate + ", eventenddate=" + eventenddate + ", comments=" + comments + "]";
	}
		
}