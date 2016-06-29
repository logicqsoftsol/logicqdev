package com.crm.logicq.dao.alert;

import java.util.List;

import com.crm.logicq.model.alert.AlertTemplateDetails;

public interface IAlertTemplateDetailsDAO {
	
	public List<AlertTemplateDetails> getAlertTemplateDetailsById(String templateId);

}
