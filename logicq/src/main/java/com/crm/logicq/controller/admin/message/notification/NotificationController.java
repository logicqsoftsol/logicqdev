package com.crm.logicq.controller.admin.message.notification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crm.logicq.model.alert.NotificationSetupDetails;
import com.crm.logicq.model.alert.NotificationTemplate;
import com.crm.logicq.service.message.INotificationService;
import com.crm.logicq.vo.notificationtemplate.NotificationTemplateCriteria;
import com.crm.logicq.vo.notificationtemplate.NotificationTemplateSetupCriteria;
import com.crm.logicq.vo.notificationtemplate.NotificationTemplateSetupVO;
import com.crm.logicq.vo.notificationtemplate.NotificationTemplateVO;

@RestController
@RequestMapping("/admin/notification")
public class NotificationController {

	@Autowired
	INotificationService notificationservice;

	@RequestMapping(value = "/saveNotificationTemplate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NotificationTemplateVO> saveNotificationTemplate(
			@RequestBody NotificationTemplate notificationtemplate) {
		NotificationTemplateVO notitemplatevo=new NotificationTemplateVO();
		NotificationTemplateCriteria notificationtemplatecriteria=new NotificationTemplateCriteria();
		notificationtemplatecriteria.setPagesize(15);	
		notificationtemplatecriteria.setPagenumber(1);
		try {
			notificationservice.saveNotificationTemplate(notificationtemplate);
			List<NotificationTemplate> notificationtemplatelist=notificationservice.getNotificationTemplates(notificationtemplatecriteria);
			notitemplatevo.setNotificationtemplatelist(notificationtemplatelist);
			notitemplatevo.setNotificationtemplatecriteria(notificationtemplatecriteria);
		} catch (Exception ex) {
			return new ResponseEntity<NotificationTemplateVO>(notitemplatevo,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<NotificationTemplateVO>(notitemplatevo, HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteNotificationTemplate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NotificationTemplateVO> deleteNotificationTemplate(
			@RequestBody NotificationTemplate notificationtemplate) {
		NotificationTemplateVO notitemplatevo=new NotificationTemplateVO();
		NotificationTemplateCriteria notificationtemplatecriteria=new NotificationTemplateCriteria();
		notificationtemplatecriteria.setPagesize(15);	
		notificationtemplatecriteria.setPagenumber(1);
		try {
			notificationservice.deleteNotificationTemplate(notificationtemplate);
			List<NotificationTemplate> notificationtemplatelist  = notificationservice.getNotificationTemplates(notificationtemplatecriteria);
			notitemplatevo.setNotificationtemplatelist(notificationtemplatelist);
			notitemplatevo.setNotificationtemplatecriteria(notificationtemplatecriteria);
		} catch (Exception ex) {
			return new ResponseEntity<NotificationTemplateVO>(notitemplatevo,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<NotificationTemplateVO>(notitemplatevo, HttpStatus.OK);
	}

	@RequestMapping(value = "/getNotificationTemplates/{pagesize}/{pageno}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NotificationTemplateVO> getNotificationTemplates(@PathVariable int pagesize,@PathVariable int pageno) {
		NotificationTemplateVO notitemplatevo=new NotificationTemplateVO();
		NotificationTemplateCriteria notificationtemplatecriteria=new NotificationTemplateCriteria();
		notificationtemplatecriteria.setPagesize(15);	
		notificationtemplatecriteria.setPagenumber(1);
		try {
			List<NotificationTemplate> notificationtemplatelist = notificationservice.getNotificationTemplates(notificationtemplatecriteria);
			notitemplatevo.setNotificationtemplatelist(notificationtemplatelist);
			notitemplatevo.setNotificationtemplatecriteria(notificationtemplatecriteria);
		} catch (Exception ex) {
			return new ResponseEntity<NotificationTemplateVO>(notitemplatevo,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<NotificationTemplateVO>(notitemplatevo, HttpStatus.OK);
	}

	@RequestMapping(value = "/saveNotificationTemplateSetup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NotificationTemplateSetupVO> saveNotificationTemplateSetup(
			@RequestBody NotificationSetupDetails notificationsetupdetails) {
		NotificationTemplateSetupVO notitempsetupvo=new NotificationTemplateSetupVO();
		NotificationTemplateSetupCriteria notitempsetupcriteria= new NotificationTemplateSetupCriteria();
		notitempsetupcriteria.setPagenumber(1);
		notitempsetupcriteria.setPagesize(15);
		try {
			notificationservice.saveNotificationTemplateSetup(notificationsetupdetails);
			List<NotificationSetupDetails> notificationtemplatesetuplist = notificationservice.getNotificationSetupDetails(notitempsetupcriteria);
			notitempsetupvo.setNotisendingdetails(notificationtemplatesetuplist);
			notitempsetupvo.setNotisendingdetailscriteria(notitempsetupcriteria);
		} catch (Exception ex) {
			return new ResponseEntity<NotificationTemplateSetupVO>(notitempsetupvo,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<NotificationTemplateSetupVO>(notitempsetupvo, HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteNotificationTemplateSetup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NotificationTemplateSetupVO> deleteNotificationTemplate(
			@RequestBody NotificationSetupDetails notificationsetupdetails) {
		NotificationTemplateSetupVO notitempsetupvo=new NotificationTemplateSetupVO();
		NotificationTemplateSetupCriteria notitempsetupcriteria= new NotificationTemplateSetupCriteria();
		notitempsetupcriteria.setPagenumber(1);
		notitempsetupcriteria.setPagesize(15);
		try {
			notificationservice.deleteNotificationTemplateSetup(notificationsetupdetails);
			List<NotificationSetupDetails> notificationtemplatesetuplist = notificationservice.getNotificationSetupDetails(notitempsetupcriteria);
			notitempsetupvo.setNotisendingdetails(notificationtemplatesetuplist);
			notitempsetupvo.setNotisendingdetailscriteria(notitempsetupcriteria);
		} catch (Exception ex) {
			return new ResponseEntity<NotificationTemplateSetupVO>(notitempsetupvo,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<NotificationTemplateSetupVO>(notitempsetupvo, HttpStatus.OK);
	}

	@RequestMapping(value = "/getNotificationSetupDetails/{pagesize}/{pageno}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<NotificationTemplateSetupVO> getNotificationSetupDetails(@PathVariable int pagesize,@PathVariable int pageno) {
		NotificationTemplateSetupVO notitempsetupvo=new NotificationTemplateSetupVO();
		NotificationTemplateSetupCriteria notitempsetupcriteria= new NotificationTemplateSetupCriteria();
		notitempsetupcriteria.setPagenumber(pageno);
		notitempsetupcriteria.setPagesize(pagesize);

		try {
			List<NotificationSetupDetails> notificationtemplatesetuplist = notificationservice.getNotificationSetupDetails(notitempsetupcriteria);
			notitempsetupvo.setNotisendingdetails(notificationtemplatesetuplist);
			notitempsetupvo.setNotisendingdetailscriteria(notitempsetupcriteria);
		} catch (Exception ex) {
			return new ResponseEntity<NotificationTemplateSetupVO>(notitempsetupvo,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<NotificationTemplateSetupVO>(notitempsetupvo, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getNotificationDetailsForEntity/{entitytype}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<NotificationTemplate>> getNotificationDetailsForEntity(@PathVariable String entitytype) {
		List<NotificationTemplate> notificationtemplatelist = new ArrayList<NotificationTemplate>();
		try {
			notificationtemplatelist = notificationservice.getNotificationTemplatesForEntity(entitytype);
		} catch (Exception ex) {
			return new ResponseEntity<List<NotificationTemplate>>(notificationtemplatelist,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<NotificationTemplate>>(notificationtemplatelist, HttpStatus.OK);
	}


}
