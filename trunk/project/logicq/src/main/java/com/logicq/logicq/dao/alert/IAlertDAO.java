package com.logicq.logicq.dao.alert;

import com.logicq.logicq.model.alert.Alert;

public interface IAlertDAO {

	public void addAlert(Alert alert);

	public void deleteAlert(Alert alert);

	public void updateAlert(Alert alert);

	public void getAlert(Alert alert);
}
