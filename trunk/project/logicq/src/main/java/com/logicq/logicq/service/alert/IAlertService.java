package com.logicq.logicq.service.alert;

import com.logicq.logicq.ui.alert.vo.AlertDetailsInputVO;
import com.logicq.logicq.ui.alert.vo.AlertRegistrationVO;

public interface IAlertService {

	public void registerAlert(AlertRegistrationVO alertRegistrationVO);

	public void sendAlert(AlertDetailsInputVO alertDetailsVO);
}
