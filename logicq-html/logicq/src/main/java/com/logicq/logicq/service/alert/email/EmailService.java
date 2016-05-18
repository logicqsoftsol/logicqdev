package com.logicq.logicq.service.alert.email;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.logicq.model.alert.AlertTemplate;
import com.logicq.logicq.model.alert.AlertTemplateDetails;
import com.logicq.logicq.service.alert.IAlertService;
import com.logicq.logicq.ui.alert.vo.AlertDetailsCompleteResponse;
import com.logicq.logicq.ui.alert.vo.AlertDetailsInputVO;
import com.logicq.logicq.ui.alert.vo.AlertRegistrationVO;
import com.logicq.logicq.ui.alert.vo.AlertResponse;

@Service
@Transactional
public class EmailService implements IEmailService {

	@Autowired
	IAlertService alertService;

	public void registerAlert(AlertRegistrationVO alertRegistrationVO) {

	}

	public AlertResponse sendAlert(AlertDetailsInputVO alertDetailsVO) {

		AlertResponse alertResponse = new AlertResponse();
		Map<String, Object> alertDetails = alertDetailsVO.getNameValuePair();
		String emailId = alertDetails.get("emailId").toString();
		String to = "nayak.rakesh007@gmail.com";
		String serviceId = alertDetailsVO.getServiceId();
		AlertDetailsCompleteResponse alertDetailsCompleteResponse = alertService.getAlertDetails(serviceId);
		String alertMessageBody = buildAlertMessage(alertDetailsCompleteResponse, alertDetailsVO);
		AlertTemplate alertTemplate = alertDetailsCompleteResponse.getAlertTemplate().get(0);
		String subject = alertTemplate.getSubject();
		String from = "logicqsolutions@gmail.com";
		final String userName = "logicqsolutions";
		final String password = "Error@123";
		Properties props = System.getProperties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.socketFactory.port", "465");
		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		try {
			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {

				protected PasswordAuthentication getPasswordAuthentication() {

					return new PasswordAuthentication(userName, password);
				}
			});
			Message message = new MimeMessage(session);
			message.setSubject(subject);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(RecipientType.TO, InternetAddress.parse(to));
			message.setText(alertMessageBody);
			Transport.send(message);
			alertResponse.setAlertName(alertTemplate.getTemplateId());
			alertResponse.setAlertMessage(alertMessageBody);
			alertResponse.setInputDetailsVO(alertDetailsVO);
			if (alertDetails != null && alertDetails.get("otpValue") != null) {
				alertResponse.setEmailOtp(Integer.valueOf(alertDetails.get("otpValue").toString()));
			}
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alertResponse;
	}

	private String buildAlertMessage(AlertDetailsCompleteResponse alertDetailsCompleteResponse, AlertDetailsInputVO alertDetailsVO) {

		AlertTemplate template = alertDetailsCompleteResponse.getAlertTemplate().get(0);
		String templateMessage = template.getTemplateValue();
		Map<String, Object> nameValuePair = alertDetailsVO.getNameValuePair();
		//String 
		List<AlertTemplateDetails> alertTemplateDetailsList = alertDetailsCompleteResponse.getAlertTemplateDetails();
		for (AlertTemplateDetails detail : alertTemplateDetailsList) {
			String attribute = detail.getAttribute();
			templateMessage = templateMessage.replace("$" + attribute, nameValuePair.get(attribute).toString());
		}
		return templateMessage;
	}
}
