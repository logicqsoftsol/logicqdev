package com.logicq.logicq.service.alert.sms;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.logicq.ui.alert.vo.AlertDetailsInputVO;
import com.logicq.logicq.ui.alert.vo.AlertRegistrationVO;
import com.logicq.logicq.ui.alert.vo.AlertResponse;

@Service
@Transactional
public class SmsService implements ISMSService {

	public void registerAlert(AlertRegistrationVO alertRegistrationVO) {

		// TODO Auto-generated method stub
	}

	public AlertResponse sendAlert(AlertDetailsInputVO alertDetailsVO) {

		//validate input
		//build third party input
		// call thirdparty service
		//build response
		return null;
	}
}
