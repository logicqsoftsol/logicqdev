package com.crm.logicq.model.alert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "ALERT_TEMPLATE")
@NamedQueries({ @NamedQuery(name = AlertTemplate.GET_ALERT_TEMPLATE_BY_REASON_ID, query = AlertTemplate.GET_ALERT_TEMPLATE_BY_REASON_ID_QRY) })
public class AlertTemplate implements AlertConstants{
	@Id
	@Column(name = "TEMPLATE_ID", unique = true, nullable = false)
	private String templateId;
	@Column(name = "TEMPLATE_VALUE", unique = true, nullable = false)
	private String templateValue;
	@Column(name = "REASON_ID", unique = true, nullable = false)
	private String reasonId;
	@Column(name = "SUBJECT", unique = true, nullable = false)
	private String subject;

	public String getSubject() {

		return subject;
	}

	public void setSubject(String subject) {

		this.subject = subject;
	}

	public String getReasonId() {

		return reasonId;
	}

	public void setReasonId(String reasonId) {

		this.reasonId = reasonId;
	}

	public String getTemplateId() {

		return templateId;
	}

	public String getTemplateValue() {

		return templateValue;
	}

	public void setTemplateId(String templateId) {

		this.templateId = templateId;
	}

	public void setTemplateValue(String templateValue) {

		this.templateValue = templateValue;
	}

}
