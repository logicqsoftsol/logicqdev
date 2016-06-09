package com.logicq.logicq.ui.verification.vo;

import java.util.Map;

public class UserVerificationDTO {

	private Long userId;
	private Map<String, Object> nameValuePair;

	public Long getUserId() {

		return userId;
	}

	public Map<String, Object> getNameValuePair() {

		return nameValuePair;
	}

	public void setUserId(Long userId) {

		this.userId = userId;
	}

	public void setNameValuePair(Map<String, Object> nameValuePair) {

		this.nameValuePair = nameValuePair;
	}
}
