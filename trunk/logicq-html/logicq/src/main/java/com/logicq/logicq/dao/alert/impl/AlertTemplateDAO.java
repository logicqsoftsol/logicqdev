package com.logicq.logicq.dao.alert.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.logicq.logicq.dao.AbstractDAO;
import com.logicq.logicq.dao.alert.IAlertTemplateDAO;
import com.logicq.logicq.model.alert.AlertConstants;
import com.logicq.logicq.model.alert.AlertTemplate;

@Repository
public class AlertTemplateDAO extends AbstractDAO<AlertTemplate> implements IAlertTemplateDAO {

	public void addAlertTemplate(AlertTemplate alertTemplate) {

		// TODO Auto-generated method stub
	}

	public void getAlertTemplate(AlertTemplate alertTemplate) {

		// TODO Auto-generated method stub
	}

	public void getAlertTemplateById(String templateId) {

		// TODO Auto-generated method stub
	}

	public List<AlertTemplate> getAlertTemplateByServiceId(String serviceId) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("serviceId", serviceId);
		List<AlertTemplate> alertTemplates = (List<AlertTemplate>) executeNamedQuery(AlertConstants.GET_ALERT_TEMPLATE_BY_SERVICE_ID, params);
		return alertTemplates;
	}
}
