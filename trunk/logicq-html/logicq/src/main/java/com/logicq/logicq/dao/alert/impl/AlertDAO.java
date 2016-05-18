package com.logicq.logicq.dao.alert.impl;

import org.springframework.stereotype.Repository;

import com.logicq.logicq.dao.AbstractDAO;
import com.logicq.logicq.dao.alert.IAlertDAO;
import com.logicq.logicq.model.alert.Alert;

@Repository
public class AlertDAO extends AbstractDAO<Alert> implements IAlertDAO {

	public void addAlert(Alert alert) {

		save(alert);
	}

	public void deleteAlert(Alert alert) {

		// TODO Auto-generated method stub
	}

	public void updateAlert(Alert alert) {

		// TODO Auto-generated method stub
	}

	public void getAlert(Alert alert) {

		// TODO Auto-generated method stub
	}
}
