package com.logicq.logicq.service.alert;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.logicq.ui.alert.vo.AlertDetailsInputVO;
import com.logicq.logicq.ui.alert.vo.AlertRegistrationVO;

@Service
@Transactional
public class AlertService implements IAlertService {

	public void registerAlert(AlertRegistrationVO registrationVO) {

	}

	public void sendAlert(AlertDetailsInputVO alertDetailsVO) {

		System.out.println("sending alert..");
		//validate
		// determine type
		//call respective impl service
		//log alert in table
	}
}
