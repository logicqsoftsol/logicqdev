package com.logicq.logicq.service.alert;

import com.logicq.logicq.ui.alert.vo.AlertDetailsInputVO;
import com.logicq.logicq.ui.alert.vo.AlertResponse;

public interface IAlertImplService {

	public AlertResponse sendAlert(AlertDetailsInputVO alertDetailsVO);
}
