package com.crm.logicq.model.alert;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.crm.logicq.model.event.EventDetails;

@Entity
@Table(name = "NOTIFICATION_TEMPLATE")
public class NotificationTemplate {

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long templateid;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="EVENT_ID")
	private EventDetails eventdetails;
	
	@Column(name = "TEMPLATE_TEXT")
	private String templatetext;

	public Long getTemplateid() {
		return templateid;
	}

	public void setTemplateid(Long templateid) {
		this.templateid = templateid;
	}

	public EventDetails getEventdetails() {
		return eventdetails;
	}

	public void setEventdetails(EventDetails eventdetails) {
		this.eventdetails = eventdetails;
	}

	public String getTemplatetext() {
		return templatetext;
	}

	public void setTemplatetext(String templatetext) {
		this.templatetext = templatetext;
	}

	
	@Override
	public String toString() {
		return "NotificationTemplate [templateid=" + templateid + ", eventdetails=" + eventdetails + ", templatetext="
				+ templatetext + "]";
	}
	
	

}
