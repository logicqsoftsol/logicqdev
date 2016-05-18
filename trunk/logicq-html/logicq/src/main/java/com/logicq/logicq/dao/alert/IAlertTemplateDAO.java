package com.logicq.logicq.dao.alert;

import java.util.List;

import com.logicq.logicq.model.alert.AlertTemplate;

public interface IAlertTemplateDAO {

	public void addAlertTemplate(AlertTemplate alertTemplate);

	public void getAlertTemplate(AlertTemplate alertTemplate);

	public void getAlertTemplateById(String templateId);

	public List<AlertTemplate> getAlertTemplateByServiceId(String serviceId);
}
