package com.logicq.logicq.ui.alert.vo;

import java.util.Map;

import com.logicq.logicq.constant.AlertCommunicationType;
import com.logicq.logicq.constant.AlertType;

public class AlertDetailsInputVO {

	private Map<String, Object> nameValuePair;
	private AlertType alertType;
	private AlertCommunicationType alertCommunicationType;
	private String serviceId;
	private Long userId;

	public Long getUserId() {

		return userId;
	}

	public void setUserId(Long userId) {

		this.userId = userId;
	}

	public String getServiceId() {

		return serviceId;
	}

	public void setServiceId(String serviceId) {

		this.serviceId = serviceId;
	}

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

	public Map<String, Object> getNameValuePair() {

		return nameValuePair;
	}

	public void setNameValuePair(Map<String, Object> nameValuePair) {

		this.nameValuePair = nameValuePair;
	}
}
