package com.logicq.logicq.communication.model;

import java.util.Map;

public class LogicqCommunicationTemplate {
	
	private String templateid;
	
	private String templateName;
	
	private Map<String,Object> templateAttribute;
	
	private boolean isValidateTemplate;
	
	private TemplateType templateType;

	public String getTemplateid() {
		return templateid;
	}

	public void setTemplateid(String templateid) {
		this.templateid = templateid;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public Map<String, Object> getTemplateAttribute() {
		return templateAttribute;
	}

	public void setTemplateAttribute(Map<String, Object> templateAttribute) {
		this.templateAttribute = templateAttribute;
	}

	public boolean isValidateTemplate() {
		return isValidateTemplate;
	}

	public void setValidateTemplate(boolean isValidateTemplate) {
		this.isValidateTemplate = isValidateTemplate;
	}

	public TemplateType getTemplateType() {
		return templateType;
	}

	public void setTemplateType(TemplateType templateType) {
		this.templateType = templateType;
	}

}
