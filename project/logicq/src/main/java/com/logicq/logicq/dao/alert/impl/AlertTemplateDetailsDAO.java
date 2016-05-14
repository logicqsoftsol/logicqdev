package com.logicq.logicq.dao.alert.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.logicq.logicq.dao.AbstractDAO;
import com.logicq.logicq.dao.alert.IAlertTemplateDetailsDAO;
import com.logicq.logicq.model.alert.AlertConstants;
import com.logicq.logicq.model.alert.AlertTemplateDetails;

@Repository
public class AlertTemplateDetailsDAO extends AbstractDAO<AlertTemplateDetails> implements IAlertTemplateDetailsDAO {

	public void addAlertTemplateDetails(AlertTemplateDetailsDAO alertTemplateDetailsDAO) {

		// TODO Auto-generated method stub
	}

	public void getAlertTemplateDetails(AlertTemplateDetailsDAO alertTemplateDetailsDAO) {

		// TODO Auto-generated method stub
	}

	public List<AlertTemplateDetails> getAlertTemplateDetailsById(String templateId) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("templateId", templateId);
		List<AlertTemplateDetails> alertTemplateDetails = (List<AlertTemplateDetails>) executeNamedQuery(AlertConstants.GET_ALERT_TEMPLATE_DETAILS_BY_TEMPLATE_ID,
		                                                                                                 params);
		return alertTemplateDetails;
	}
}
