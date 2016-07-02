package com.crm.logicq.dao.alert.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.crm.logicq.common.AbstractDAO;
import com.crm.logicq.dao.alert.IAlertDAO;
import com.crm.logicq.model.alert.Alert;

@Repository
public class AlertDAO extends AbstractDAO<Alert> implements IAlertDAO{
	
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

	public Alert fetchAlertByReasonId(String reasonId) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("reasonId", reasonId);
		List<Alert> alerts = (List<Alert>) executeNamedQuery(Alert.GET_ALERT_BY_REASON_ID, params);
		if (alerts != null && !alerts.isEmpty() && (alerts.size() > 0)) {
			return alerts.get(0);
		}
		return null;
	}

}
