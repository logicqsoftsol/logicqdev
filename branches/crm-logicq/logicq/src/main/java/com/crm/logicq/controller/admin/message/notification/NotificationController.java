package com.crm.logicq.controller.admin.message.notification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crm.logicq.model.alert.NotificationSetupDetails;
import com.crm.logicq.model.alert.NotificationTemplate;
import com.crm.logicq.service.message.INotificationService;

@RestController
@RequestMapping("/admin/notification")
public class NotificationController {

	@Autowired
	INotificationService notificationservice;

	@RequestMapping(value = "/saveNotificationTemplate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<NotificationTemplate>> saveNotificationTemplate(
			@RequestBody NotificationTemplate notificationtemplate) {
		List<NotificationTemplate> notificationtemplatelist = new ArrayList<NotificationTemplate>();
		try {
			notificationservice.saveNotificationTemplate(notificationtemplate);
			notificationtemplatelist = notificationservice.getNotificationTemplates();
		} catch (Exception ex) {
			return new ResponseEntity<List<NotificationTemplate>>(notificationtemplatelist,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<List<NotificationTemplate>>(notificationtemplatelist, HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteNotificationTemplate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<NotificationTemplate>> deleteNotificationTemplate(
			@RequestBody NotificationTemplate notificationtemplate) {
		List<NotificationTemplate> notificationtemplatelist = new ArrayList<NotificationTemplate>();
		try {
			notificationservice.deleteNotificationTemplate(notificationtemplate);
			notificationtemplatelist = notificationservice.getNotificationTemplates();
		} catch (Exception ex) {
			return new ResponseEntity<List<NotificationTemplate>>(notificationtemplatelist,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<List<NotificationTemplate>>(notificationtemplatelist, HttpStatus.OK);
	}

	@RequestMapping(value = "/getNotificationTemplates", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<NotificationTemplate>> getNotificationTemplates() {
		List<NotificationTemplate> notificationtemplatelist = new ArrayList<NotificationTemplate>();
		try {
			notificationtemplatelist = notificationservice.getNotificationTemplates();
		} catch (Exception ex) {
			return new ResponseEntity<List<NotificationTemplate>>(notificationtemplatelist,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<List<NotificationTemplate>>(notificationtemplatelist, HttpStatus.OK);
	}

	@RequestMapping(value = "/saveNotificationTemplateSetup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<NotificationSetupDetails>> saveNotificationTemplateSetup(
			@RequestBody NotificationSetupDetails notificationsetupdetails) {
		List<NotificationSetupDetails> notificationtemplatesetuplist = new ArrayList<NotificationSetupDetails>();
		try {
			notificationservice.saveNotificationTemplateSetup(notificationsetupdetails);
			notificationtemplatesetuplist = notificationservice.getNotificationSetupDetails();
		} catch (Exception ex) {
			return new ResponseEntity<List<NotificationSetupDetails>>(notificationtemplatesetuplist,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<NotificationSetupDetails>>(notificationtemplatesetuplist, HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteNotificationTemplateSetup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<NotificationSetupDetails>> deleteNotificationTemplate(
			@RequestBody NotificationSetupDetails notificationsetupdetails) {
		List<NotificationSetupDetails> notificationtemplatesetuplist = new ArrayList<NotificationSetupDetails>();
		try {
			notificationservice.deleteNotificationTemplateSetup(notificationsetupdetails);
			notificationtemplatesetuplist = notificationservice.getNotificationSetupDetails();
		} catch (Exception ex) {
			return new ResponseEntity<List<NotificationSetupDetails>>(notificationtemplatesetuplist,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<NotificationSetupDetails>>(notificationtemplatesetuplist, HttpStatus.OK);
	}

	@RequestMapping(value = "/getNotificationSetupDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<NotificationSetupDetails>> getNotificationSetupDetails() {
		List<NotificationSetupDetails> notificationtemplatesetuplist = new ArrayList<NotificationSetupDetails>();
		try {
			notificationtemplatesetuplist = notificationservice.getNotificationSetupDetails();
		} catch (Exception ex) {
			return new ResponseEntity<List<NotificationSetupDetails>>(notificationtemplatesetuplist,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<NotificationSetupDetails>>(notificationtemplatesetuplist, HttpStatus.OK);
	}

}
