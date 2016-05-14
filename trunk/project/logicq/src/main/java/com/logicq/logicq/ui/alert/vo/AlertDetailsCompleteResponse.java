package com.logicq.logicq.ui.alert.vo;

import java.util.List;

import com.logicq.logicq.model.alert.AlertTemplate;
import com.logicq.logicq.model.alert.AlertTemplateDetails;

public class AlertDetailsCompleteResponse {

	private List<AlertTemplate> alertTemplate;
	private List<AlertTemplateDetails> alertTemplateDetails;

	public List<AlertTemplate> getAlertTemplate() {

		return alertTemplate;
	}

	public List<AlertTemplateDetails> getAlertTemplateDetails() {

		return alertTemplateDetails;
	}

	public void setAlertTemplate(List<AlertTemplate> alertTemplate) {

		this.alertTemplate = alertTemplate;
	}

	public void setAlertTemplateDetails(List<AlertTemplateDetails> alertTemplateDetails) {

		this.alertTemplateDetails = alertTemplateDetails;
	}
}
