package com.logicq.logicq.service.alert;

import com.logicq.logicq.ui.alert.vo.AlertDetailsInputVO;
import com.logicq.logicq.ui.alert.vo.AlertRegistrationVO;

public class AlertApplicationService implements IAlertApplicationService {

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
