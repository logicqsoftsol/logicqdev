package com.crm.logicq.model.alert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.crm.logicq.constant.SMSType;
import com.crm.logicq.model.event.EventDetails;

@Entity
@Table(name = "SMS_TEMPLATE")
public class SMSTemplate {
	
	@Id
    @Column(name = "ID",unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long smstemplateid;
	
	@OneToOne(fetch = FetchType.EAGER)
	private EventDetails eventdetails;
	
	@Column(name = "SMS_TYPE", nullable = true)
	@Enumerated(EnumType.STRING)
	private SMSType smstype;

    @Column(name = "SMS_MESSAGE", length = 300, unique = true)
    @NotNull
    @Size( min = 10)
	private String smsmessage;

	public Long getSmstemplateid() {
		return smstemplateid;
	}

	public void setSmstemplateid(Long smstemplateid) {
		this.smstemplateid = smstemplateid;
	}

	public EventDetails getEventdetails() {
		return eventdetails;
	}

	public void setEventdetails(EventDetails eventdetails) {
		this.eventdetails = eventdetails;
	}

	public SMSType getSmstype() {
		return smstype;
	}

	public void setSmstype(SMSType smstype) {
		this.smstype = smstype;
	}

	public String getSmsmessage() {
		return smsmessage;
	}

	public void setSmsmessage(String smsmessage) {
		this.smsmessage = smsmessage;
	}

	@Override
	public String toString() {
		return "SMSTemplate [smstemplateid=" + smstemplateid + ", eventdetails=" + eventdetails + ", smstype=" + smstype
				+ ", smsmessage=" + smsmessage + "]";
	} 
    
    

}
