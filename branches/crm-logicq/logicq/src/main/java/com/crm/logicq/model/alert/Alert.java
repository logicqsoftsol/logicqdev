package com.crm.logicq.model.alert;

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

import com.crm.logicq.constant.alert.AlertType;
import com.crm.logicq.model.common.BaseEntity;




@Entity
@Table(name = "ALERT_LOG")
@NamedQueries({ @NamedQuery(name = Alert.GET_ALERT_BY_REASON_ID, query = Alert.GET_ALERT_BY_REASON_QRY) })
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
	@Column(name = "MOBILE_NO", unique = true, nullable = false)
	private Long mobileNo;
	@Column(name = "ALERT_STATUS", unique = true, nullable = false)
	private String alertStatus;
	@Column(name = "ALERT_REASON", unique = true, nullable = false)
	private String alertReason;
	@Column(name = "MESSAGE", unique = true, nullable = false)
	private String message;

		public String getMessage() {

		return message;
	}

	public void setMessage(String message) {

		this.message = message;
	}

	
	public String getAlertReason() {
		return alertReason;
	}

	public void setAlertReason(String alertReason) {
		this.alertReason = alertReason;
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

	public Long getMobileNo() {

		return mobileNo;
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

	public void setMobileNo(Long mobileNo) {

		this.mobileNo = mobileNo;
	}

	public void setAlertStatus(String alertStatus) {

		this.alertStatus = alertStatus;
	}
}
