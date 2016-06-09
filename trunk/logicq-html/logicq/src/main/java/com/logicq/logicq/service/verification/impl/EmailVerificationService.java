package com.logicq.logicq.service.verification.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.logicq.logicq.model.alert.Alert;
import com.logicq.logicq.service.alert.IAlertService;
import com.logicq.logicq.ui.verification.vo.UserVerificationDTO;

public class EmailVerificationService {

	@Autowired
	IAlertService alertService;

	public Boolean verifyEmail(UserVerificationDTO userVerificationDTO) {

		Map<String, Object> nameValuePair = userVerificationDTO.getNameValuePair();
		Integer emailOtp = Integer.valueOf(nameValuePair.get("emailOtp").toString());
		Long userId = userVerificationDTO.getUserId();
		Alert alert = alertService.fetchAlert(userId);
		if (alert.getEmailOtp().equals(emailOtp)) {
			return true;
		}
		return false;
	}
}
