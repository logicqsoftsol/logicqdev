package com.logicq.logicq.model.alert;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import com.logicq.logicq.common.criteriamanager.BaseEntity;
import com.logicq.logicq.constant.AlertType;

@Entity
@Table(name = "ALERT_LOG")
@NamedQueries({ @NamedQuery(name = Alert.GET_ALERT_BY_USER_ID, query = Alert.GET_ALERT_BY_USER_ID_QRY) })
public class Alert extends BaseEntity implements Serializable, AlertConstants {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7087659491456021215L;
	@Id
	@Column(name = "ALERT_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long alertId;
	@Column(name = "ALERT_NAME", unique = true, nullable = false)
	private String alertName;
	@Column(name = "ALERT_TYPE", unique = true, nullable = false)
	@Enumerated(EnumType.STRING)
	private AlertType alertType;
	@Column(name = "USER_ID", unique = true, nullable = false)
	private Long userId;
	@Column(name = "ALERT_STATUS", unique = true, nullable = false)
	private String alertStatus;
	@Column(name = "SERVICE_ID", unique = true, nullable = false)
	private String serviceId;
	@Column(name = "EMAIL_OTP", unique = true, nullable = false)
	private Integer emailOtp;
	@Column(name = "SMS_OTP", unique = true, nullable = false)
	private Integer smsOtp;
	@Column(name = "MESSAGE", unique = true, nullable = false)
	private String message;

	public Integer getEmailOtp() {

		return emailOtp;
	}

	public Integer getSmsOtp() {

		return smsOtp;
	}

	public String getMessage() {

		return message;
	}

	public void setEmailOtp(Integer emailOtp) {

		this.emailOtp = emailOtp;
	}

	public void setSmsOtp(Integer smsOtp) {

		this.smsOtp = smsOtp;
	}

	public void setMessage(String message) {

		this.message = message;
	}

	public String getServiceId() {

		return serviceId;
	}

	public void setServiceId(String serviceId) {

		this.serviceId = serviceId;
	}

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
