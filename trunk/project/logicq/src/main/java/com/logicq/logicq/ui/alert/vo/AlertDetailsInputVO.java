package com.logicq.logicq.ui.alert.vo;

import java.util.Map;

import com.logicq.logicq.constant.AlertCommunicationType;
import com.logicq.logicq.constant.AlertType;

public class AlertDetailsInputVO {

	private Map<Object, Object> nameValuePair;
	private AlertType alertType;
	private AlertCommunicationType alertCommunicationType;

	public AlertCommunicationType getAlertCommunicationType() {

		return alertCommunicationType;
	}

	public void setAlertCommunicationType(AlertCommunicationType alertCommunicationType) {

		this.alertCommunicationType = alertCommunicationType;
	}

	public AlertType getAlertType() {

		return alertType;
	}

	public void setAlertType(AlertType alertType) {

		this.alertType = alertType;
	}

	public Map<Object, Object> getNameValuePair() {

		return nameValuePair;
	}

	public void setNameValuePair(Map<Object, Object> nameValuePair) {

		this.nameValuePair = nameValuePair;
	}
}
