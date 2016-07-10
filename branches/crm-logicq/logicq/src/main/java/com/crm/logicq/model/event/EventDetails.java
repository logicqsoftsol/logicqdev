package com.crm.logicq.model.event;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.crm.logicq.constant.EntityType;
import com.crm.logicq.constant.EventType;

@Entity
@Table(name = "EVENT")
public class EventDetails {
	
	@Id
    @Column(name = "ID",unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventid;

    @Column(name = "NAME", length = 40, unique = true)
    @NotNull
    @Size( max = 40)
    private String eventname;

	@Column(name = "EVENT_TYPE", nullable = true)
	@Enumerated(EnumType.STRING)
	private EventType eventtype;
	
	@Column(name = "APPLICABLE_FOR", nullable = true)
	@Enumerated(EnumType.STRING)
	private EntityType applicablefor;

	public Long getEventid() {
		return eventid;
	}

	public void setEventid(Long eventid) {
		this.eventid = eventid;
	}

	public String getEventname() {
		return eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public EventType getEventtype() {
		return eventtype;
	}

	public void setEventtype(EventType eventtype) {
		this.eventtype = eventtype;
	}

	public EntityType getApplicablefor() {
		return applicablefor;
	}

	public void setApplicablefor(EntityType applicablefor) {
		this.applicablefor = applicablefor;
	}
	

	@Override
	public String toString() {
		return "EventDetails [eventid=" + eventid + ", eventname=" + eventname + ", eventtype=" + eventtype
				+ ", applicablefor=" + applicablefor + "]";
	}
    
	


	
}
