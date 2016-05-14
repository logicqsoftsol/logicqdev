package com.logicq.logicq.model.alert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "ALERT_TEMPLATE_DETAILS")
@NamedQueries({ @NamedQuery(name = AlertTemplateDetails.GET_ALERT_TEMPLATE_DETAILS_BY_TEMPLATE_ID, query = AlertTemplateDetails.GET_ALERT_TEMPLATE_DETAILS_BY_TEMPLATE_ID_QRY) })
public class AlertTemplateDetails implements AlertConstants {

	@Id
	@Column(name = "TEMPLATE_DETAILS_ID", unique = true, nullable = false)
	private String templateDetailsId;
	@Column(name = "TEMPLATE_ID", unique = true, nullable = false)
	private String templateId;
	@Column(name = "ATTRIBUTE_NAME", unique = true, nullable = false)
	private String attribute;

	public String getTemplateDetailsId() {

		return templateDetailsId;
	}

	public void setTemplateDetailsId(String templateDetailsId) {

		this.templateDetailsId = templateDetailsId;
	}

	public String getTemplateId() {

		return templateId;
	}

	public String getAttribute() {

		return attribute;
	}

	public void setTemplateId(String templateId) {

		this.templateId = templateId;
	}

	public void setAttribute(String attribute) {

		this.attribute = attribute;
	}
}
