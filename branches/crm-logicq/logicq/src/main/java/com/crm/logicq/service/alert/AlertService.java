package com.crm.logicq.service.alert;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.logicq.constant.alert.AlertType;
import com.crm.logicq.dao.alert.IAlertDAO;
import com.crm.logicq.dao.alert.IAlertTemplateDAO;
import com.crm.logicq.dao.alert.IAlertTemplateDetailsDAO;
import com.crm.logicq.model.alert.Alert;
import com.crm.logicq.model.alert.AlertTemplate;
import com.crm.logicq.model.alert.AlertTemplateDetails;
import com.crm.logicq.service.alert.impl.sms.ISMSService;
import com.crm.logicq.ui.alert.AlertDetailsInputVO;

@Service
@Transactional
public class AlertService implements IAlertService{
	
	@Autowired
	IAlertDAO alertDAO;
	@Autowired
	IAlertTemplateDAO alertTemplateDAO;
	@Autowired
	IAlertTemplateDetailsDAO alertTemplateDetailsDAO;
	@Autowired
	ISMSService smsService;

	
	public String buildAlert(AlertDetailsInputVO alertDetailsVO) {

		Map<String, Object> nameValuePair = alertDetailsVO.getNameValuePair();
		String alertMessage = buildAlertToSend(alertDetailsVO);
		Alert alert = new Alert();
		alert.setAlertStatus("success");
		alert.setAlertType(alertDetailsVO.getAlertType());
		alert.setAlertReason(alertDetailsVO.getAlertReason());
		alert.setMobileNo((Long)nameValuePair.get("mobileNo"));
		alert.setMessage(alertMessage);
		alert.setAlertName(nameValuePair.get("desc").toString());
		alertDAO.addAlert(alert);
		return alert.getMessage();
	}

	public void sendAlert(AlertDetailsInputVO alertDetailsVO) {

		//System.out.println("sending alert..");
		//validate
		// determine type
		AlertType alertType = alertDetailsVO.getAlertType();
		IAlertImplService service = determineAlertImpl(alertType);
		//call respective impl service
		//AlertResponse alertResponse = service.sendAlert(alertDetailsVO);
		
	}

	private String buildAlertToSend(AlertDetailsInputVO alertDetailsVO){
		
		List<AlertTemplate> alertTemplates = alertTemplateDAO.getAlertTemplateByReasonId(alertDetailsVO.getAlertReason());
		AlertTemplate alertTemplate = alertTemplates.get(0);
		List<AlertTemplateDetails> alertTemplateDetails = alertTemplateDetailsDAO.getAlertTemplateDetailsById(alertTemplate.getTemplateId());
		String templateMessage = alertTemplate.getTemplateValue();
		Map<String, Object> nameValuePair = alertDetailsVO.getNameValuePair();
		//String 
		for (AlertTemplateDetails detail : alertTemplateDetails) {
			String attribute = detail.getAttribute();
			templateMessage = templateMessage.replace("$" + attribute, nameValuePair.get(attribute).toString());
		}
		return templateMessage;
	
	}
	
	private IAlertImplService determineAlertImpl(AlertType alertType) {

		if (AlertType.EMAIL.equals(alertType)) {
			return null;
		} else if (AlertType.SMS.equals(alertType)) {
			return smsService;
		}
		return smsService;
	}

	public Alert fetchAlert(String reasonId) {

		Alert alert = alertDAO.fetchAlertByReasonId(reasonId);
		return alert;
	}}
