package com.crm.logicq.controller.admin.classessetup;

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

import com.crm.logicq.model.classsetup.ClassSetup;
import com.crm.logicq.model.classsetup.ClassSubjectSetup;
import com.crm.logicq.model.classsetup.Subject;

@RestController
@RequestMapping("/api/admin/classessetup")
public class ClassesSetupController {

	//@Autowired
	//INotificationService notificationservice;

	@RequestMapping(value = "/saveSubject", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Subject>> saveNotificationTemplate(
			@RequestBody Subject newsubject) {
		List<Subject> subjectlist=new ArrayList<Subject>();
		
	
		return new ResponseEntity<List<Subject>>(subjectlist, HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteSubject", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Subject>> deleteNotificationTemplate(
			@RequestBody Subject notificationtemplate) {
		List<Subject> subjectlist=new ArrayList<Subject>();
		
		return new ResponseEntity<List<Subject>>(subjectlist, HttpStatus.OK);
	}

	@RequestMapping(value = "/getSubjectList/{pagesize}/{pageno}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Subject>> getNotificationTemplates(@PathVariable int pagesize,@PathVariable int pageno) {
		List<Subject> subjectlist=new ArrayList<Subject>();
		return new ResponseEntity<List<Subject>>(subjectlist, HttpStatus.OK);
	}

	@RequestMapping(value = "/saveClasses", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ClassSetup>> saveNotificationTemplateSetup(
			@RequestBody ClassSetup classes) {
		List<ClassSetup> classessetuplist=new ArrayList<ClassSetup>();
	
		return new ResponseEntity<List<ClassSetup>>(classessetuplist, HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteClassesSetup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ClassSetup>> deleteNotificationTemplate(
			@RequestBody ClassSetup classesetup) {
	
		List<ClassSetup> classessetuplist=new ArrayList<ClassSetup>();
		
		return new ResponseEntity<List<ClassSetup>>(classessetuplist, HttpStatus.OK);
	}

	@RequestMapping(value = "/getClasseslist/{pagesize}/{pageno}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ClassSetup>> getClassesSetupDetails(@PathVariable int pagesize,@PathVariable int pageno) {
		List<ClassSetup> classessetuplist=new ArrayList<ClassSetup>(); 
		return new ResponseEntity<List<ClassSetup>>(classessetuplist, HttpStatus.OK);
	}

	@RequestMapping(value = "/saveClassSubjectSetup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ClassSubjectSetup>> saveNotificationTemplateSetup(
			@RequestBody ClassSubjectSetup classsubject) {
		List<ClassSubjectSetup> classSubjectlist=new ArrayList<ClassSubjectSetup>();
	
		return new ResponseEntity<List<ClassSubjectSetup>>(classSubjectlist, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deleteClassSubjectSetup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ClassSubjectSetup>> deleteNotificationTemplate(
			@RequestBody ClassSubjectSetup classesetup) {
	
		List<ClassSubjectSetup> classSubjectlist=new ArrayList<ClassSubjectSetup>();
		
		return new ResponseEntity<List<ClassSubjectSetup>>(classSubjectlist, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getClassSubjectlist/{pagesize}/{pageno}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ClassSubjectSetup>> getNotificationSetupDetails(@PathVariable int pagesize,@PathVariable int pageno) {
		List<ClassSubjectSetup> classSubjectSetuplist=new ArrayList<ClassSubjectSetup>(); 
		return new ResponseEntity<List<ClassSubjectSetup>>(classSubjectSetuplist, HttpStatus.OK);
	}


}
