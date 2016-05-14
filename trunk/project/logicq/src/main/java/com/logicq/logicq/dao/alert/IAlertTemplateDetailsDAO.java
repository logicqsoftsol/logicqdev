package com.logicq.logicq.dao.alert;

import java.util.List;

import com.logicq.logicq.dao.alert.impl.AlertTemplateDetailsDAO;
import com.logicq.logicq.model.alert.AlertTemplateDetails;

public interface IAlertTemplateDetailsDAO {

	public void addAlertTemplateDetails(AlertTemplateDetailsDAO alertTemplateDetailsDAO);

	public void getAlertTemplateDetails(AlertTemplateDetailsDAO alertTemplateDetailsDAO);

	public List<AlertTemplateDetails> getAlertTemplateDetailsById(String templateId);
}
