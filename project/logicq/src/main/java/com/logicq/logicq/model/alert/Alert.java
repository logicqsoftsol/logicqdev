package com.logicq.logicq.model.alert;

import java.io.Serializable;

import com.logicq.logicq.common.criteriamanager.BaseEntity;
import com.logicq.logicq.constant.AlertType;

public class Alert extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7087659491456021215L;
	private Long alertId;
	private String alertName;
	private AlertType alertType;
	private Long userId;
	private String alertStatus;

	public Long getAlertId() {

		return alertId;
	}

	public String getAlertName() {

		return alertName;
	}

	public AlertType getAlertType() {

		return alertType;
	}

	public Long getUserId() {

		return userId;
	}

	public String getAlertStatus() {

		return alertStatus;
	}

	public void setAlertId(Long alertId) {

		this.alertId = alertId;
	}

	public void setAlertName(String alertName) {

		this.alertName = alertName;
	}

	public void setAlertType(AlertType alertType) {

		this.alertType = alertType;
	}

	public void setUserId(Long userId) {

		this.userId = userId;
	}

	public void setAlertStatus(String alertStatus) {

		this.alertStatus = alertStatus;
	}
}
