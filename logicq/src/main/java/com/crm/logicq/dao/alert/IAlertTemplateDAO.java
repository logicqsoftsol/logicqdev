package com.crm.logicq.dao.alert;

import java.util.List;

import com.crm.logicq.model.alert.AlertTemplate;

public interface IAlertTemplateDAO {
	public List<AlertTemplate> getAlertTemplateByReasonId(String reasonId);

}
