package com.crm.logicq.ui.alert;

import java.util.Map;

import com.crm.logicq.constant.alert.AlertType;

public class AlertDetailsInputVO {
	
	private Map<String, Object> nameValuePair;
	private AlertType alertType;
	private String alertReason;
	public Map<String, Object> getNameValuePair() {
		return nameValuePair;
	}
	public void setNameValuePair(Map<String, Object> nameValuePair) {
		this.nameValuePair = nameValuePair;
	}
	public AlertType getAlertType() {
		return alertType;
	}
	public void setAlertType(AlertType alertType) {
		this.alertType = alertType;
	}
	public String getAlertReason() {
		return alertReason;
	}
	public void setAlertReason(String alertReason) {
		this.alertReason = alertReason;
	}
	
	

}
