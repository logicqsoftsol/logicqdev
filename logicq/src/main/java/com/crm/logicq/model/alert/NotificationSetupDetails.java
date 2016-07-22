package com.crm.logicq.model.alert;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "NOTIFICATION_SETUP")
public class NotificationSetupDetails {

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long setupid;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="NOTIFICATION_TEMPLATE_ID")
	private NotificationTemplate notificationtemplate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MSG_SEND_START_DATE")
	private  Date  msgsendfromdate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MSG_SEND_END_DATE")
	private  Date  msgsendtodate;
	
	@Column(name = "MSG_SENDING_TIME")
	private int msgsendingtime;

	public Long getSetupid() {
		return setupid;
	}

	public void setSetupid(Long setupid) {
		this.setupid = setupid;
	}

	public NotificationTemplate getNotificationtemplate() {
		return notificationtemplate;
	}

	public void setNotificationtemplate(NotificationTemplate notificationtemplate) {
		this.notificationtemplate = notificationtemplate;
	}

	public Date getMsgsendfromdate() {
		return msgsendfromdate;
	}

	public void setMsgsendfromdate(Date msgsendfromdate) {
		this.msgsendfromdate = msgsendfromdate;
	}

	public Date getMsgsendtodate() {
		return msgsendtodate;
	}

	public void setMsgsendtodate(Date msgsendtodate) {
		this.msgsendtodate = msgsendtodate;
	}

	public int getMsgsendingtime() {
		return msgsendingtime;
	}

	public void setMsgsendingtime(int msgsendingtime) {
		this.msgsendingtime = msgsendingtime;
	}

	@Override
	public String toString() {
		return "NotificationSetupDetails [setupid=" + setupid + ", notificationtemplate=" + notificationtemplate
				+ ", msgsendfromdate=" + msgsendfromdate + ", msgsendtodate=" + msgsendtodate + ", msgsendingtime="
				+ msgsendingtime + "]";
	}
	
	
}
