package com.logicq.commonproject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author SudhanshuLenka
 *
 */
@Entity
@Table(name = "EVENT_DETAILS")
public class EventDetails implements Serializable{
private static final long serialVersionUID = -2967666181595376776L;
	
	@Id
	@Column(name = "EVENTID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "EVENT_NAME", nullable = true)
	private String eventname;

	@Column(name = "START_DATE", nullable = true)
	private String startdate;
	
	@Column(name = "END_DATE", nullable = true)
	private String enddate;
	
	@Column(name = "DESCRIPTION", nullable = true)
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEventname() {
		return eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "EventDetails [id=" + id + ", eventname=" + eventname + ", startdate=" + startdate + ", enddate="
				+ enddate + ", description=" + description + "]";
	}
 
}
 
