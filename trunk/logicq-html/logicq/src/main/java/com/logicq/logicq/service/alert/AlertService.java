package com.logicq.logicq.service.alert;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.logicq.constant.AlertType;
import com.logicq.logicq.dao.alert.IAlertDAO;
import com.logicq.logicq.dao.alert.IAlertTemplateDAO;
import com.logicq.logicq.dao.alert.IAlertTemplateDetailsDAO;
import com.logicq.logicq.model.alert.Alert;
import com.logicq.logicq.model.alert.AlertTemplate;
import com.logicq.logicq.model.alert.AlertTemplateDetails;
import com.logicq.logicq.service.alert.email.IEmailService;
import com.logicq.logicq.service.alert.sms.ISMSService;
import com.logicq.logicq.ui.alert.vo.AlertDetailsCompleteResponse;
import com.logicq.logicq.ui.alert.vo.AlertDetailsInputVO;
import com.logicq.logicq.ui.alert.vo.AlertRegistrationVO;
import com.logicq.logicq.ui.alert.vo.AlertResponse;

@Service
@Transactional
public class AlertService implements IAlertService {

	@Autowired
	IAlertDAO alertDAO;
	@Autowired
	IAlertTemplateDAO alertTemplateDAO;
	@Autowired
	IAlertTemplateDetailsDAO alertTemplateDetailsDAO;
	@Autowired
	IEmailService emailService;
	@Autowired
	ISMSService smsService;

	public void registerAlert(AlertRegistrationVO registrationVO) {

	}

	public void sendAlert(AlertDetailsInputVO alertDetailsVO) {

		//System.out.println("sending alert..");
		//validate
		// determine type
		AlertType alertType = alertDetailsVO.getAlertType();
		IAlertImplService service = determineAlertImpl(alertType);
		//call respective impl service
		AlertResponse alertResponse = service.sendAlert(alertDetailsVO);
		//log alert in table
		Alert alert = buildAlert(alertResponse, alertDetailsVO);
		alertDAO.addAlert(alert);
	}

	private Alert buildAlert(AlertResponse alertResponse, AlertDetailsInputVO alertDetailsVO) {

		Alert alert = new Alert();
		alert.setAlertStatus("success");
		alert.setAlertType(alertDetailsVO.getAlertType());
		alert.setServiceId(alertDetailsVO.getServiceId());
		alert.setUserId(alertDetailsVO.getUserId());
		alert.setEmailOtp(alertResponse.getEmailOtp());
		alert.setMessage(alertResponse.getAlertMessage());
		alert.setAlertName(alertResponse.getAlertName());
		return alert;
	}

	public AlertDetailsCompleteResponse getAlertDetails(String serviceId) {

		AlertDetailsCompleteResponse alertDetailsCompleteResponse = new AlertDetailsCompleteResponse();
		List<AlertTemplate> alertTemplates = alertTemplateDAO.getAlertTemplateByServiceId(serviceId);
		AlertTemplate alertTemplate = alertTemplates.get(0);
		List<AlertTemplateDetails> alertTemplateDetails = alertTemplateDetailsDAO.getAlertTemplateDetailsById(alertTemplate.getTemplateId());
		alertDetailsCompleteResponse.setAlertTemplate(alertTemplates);
		alertDetailsCompleteResponse.setAlertTemplateDetails(alertTemplateDetails);
		return alertDetailsCompleteResponse;
	}

	private IAlertImplService determineAlertImpl(AlertType alertType) {

		if (AlertType.EMAIL.equals(alertType)) {
			return emailService;
		} else if (AlertType.SMS.equals(alertType)) {
			return smsService;
		}
		return emailService;
	}
}