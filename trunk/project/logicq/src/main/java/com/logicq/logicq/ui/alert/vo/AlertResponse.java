package com.logicq.logicq.ui.alert.vo;

public class AlertResponse {

	private AlertDetailsInputVO inputDetailsVO;
	private Integer emailOtp;
	private Integer smsOtp;
	private String alertMessage;
	private String alertName;

	public String getAlertName() {

		return alertName;
	}

	public void setAlertName(String alertName) {

		this.alertName = alertName;
	}

	public AlertDetailsInputVO getInputDetailsVO() {

		return inputDetailsVO;
	}

	public Integer getEmailOtp() {

		return emailOtp;
	}

	public Integer getSmsOtp() {

		return smsOtp;
	}

	public String getAlertMessage() {

		return alertMessage;
	}

	public void setInputDetailsVO(AlertDetailsInputVO inputDetailsVO) {

		this.inputDetailsVO = inputDetailsVO;
	}

	public void setEmailOtp(Integer emailOtp) {

		this.emailOtp = emailOtp;
	}

	public void setSmsOtp(Integer smsOtp) {

		this.smsOtp = smsOtp;
	}

	public void setAlertMessage(String alertMessage) {

		this.alertMessage = alertMessage;
	}
}
