package com.crm.logicq.dao.alert.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.crm.logicq.common.AbstractDAO;
import com.crm.logicq.dao.alert.IAlertTemplateDAO;
import com.crm.logicq.model.alert.AlertConstants;
import com.crm.logicq.model.alert.AlertTemplate;

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

	public List<AlertTemplate> getAlertTemplateByReasonId(String reasonId) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("reasonId", reasonId);
		List<AlertTemplate> alertTemplates = (List<AlertTemplate>) executeNamedQuery(AlertConstants.GET_ALERT_TEMPLATE_BY_REASON_ID, params);
		return alertTemplates;
	}
}
