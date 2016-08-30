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
import com.crm.logicq.service.classessetup.IClassesSetupService;
import com.crm.logicq.vo.classessetup.ClassSetupCriteria;
import com.crm.logicq.vo.classessetup.ClassSetupVO;
import com.crm.logicq.vo.classessetup.ClassSubjectSetupVO;
import com.crm.logicq.vo.classessetup.SubjectVO;

@RestController
@RequestMapping("/api/admin/classessetup")
public class ClassesSetupController {

	private static final String SUBJECTOPTIONAL = "OPTIONAL";
	private static final String SUBJECTCOMPULSORY = "COMPULSORY";
	@Autowired
	IClassesSetupService classessetupservices;
/**
 * 
 * @param newsubject
 * @return
 */
	@RequestMapping(value = "/saveSubject", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SubjectVO> saveNotificationTemplate(
			@RequestBody Subject newsubject) {
		SubjectVO subjectvo=new SubjectVO();
		try {
			if(null!=newsubject){
			classessetupservices.saveSubjectDetails(newsubject);
			}else{
				return	new ResponseEntity<SubjectVO>(subjectvo, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			ClassSetupCriteria classsetupcriteria=new ClassSetupCriteria();
			classsetupcriteria.setPagenumber(1);
			classsetupcriteria.setPagesize(15);
			List<Subject> subjectlist=classessetupservices.getSubjectDetails(classsetupcriteria);
			subjectvo.setSubjectcriteria(classsetupcriteria);
			subjectvo.setSubjectlist(subjectlist);
		} catch (Exception e) {
			return	new ResponseEntity<SubjectVO>(subjectvo, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
		return new ResponseEntity<SubjectVO>(subjectvo, HttpStatus.OK);
	}
/**
 * 
 * @param subjectdetails
 * @return
 */
	@RequestMapping(value = "/deleteSubject", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SubjectVO> deleteNotificationTemplate(
			@RequestBody Subject subjectdetails) {
		SubjectVO subjectvo=new SubjectVO();
		try {
			if(null!=subjectdetails){
			classessetupservices.deleteSubject(subjectdetails);
			}else{
				return	new ResponseEntity<SubjectVO>(subjectvo, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			ClassSetupCriteria classsetupcriteria=new ClassSetupCriteria();
			classsetupcriteria.setPagenumber(1);
			classsetupcriteria.setPagesize(15);
			List<Subject> subjectlist=classessetupservices.getSubjectDetails(classsetupcriteria);
			subjectvo.setSubjectcriteria(classsetupcriteria);
			subjectvo.setSubjectlist(subjectlist);
		} catch (Exception e) {
			return	new ResponseEntity<SubjectVO>(subjectvo, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<SubjectVO>(subjectvo, HttpStatus.OK);
	}
/**
 * 
 * @param pagesize
 * @param pageno
 * @return
 */
	@RequestMapping(value = "/getSubjectList/{pagesize}/{pageno}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SubjectVO> getSubjectList(@PathVariable int pagesize,@PathVariable int pageno) {
		SubjectVO subjectvo=new SubjectVO();
		try {
			ClassSetupCriteria classsetupcriteria=new ClassSetupCriteria();
			classsetupcriteria.setPagenumber(pageno);
			classsetupcriteria.setPagesize(pagesize);
			List<Subject> subjectlist = classessetupservices.getSubjectDetails(classsetupcriteria);
			subjectvo.setSubjectcriteria(classsetupcriteria);
			subjectvo.setSubjectlist(subjectlist);
		} catch (Exception e) {
			return	new ResponseEntity<SubjectVO>(subjectvo, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<SubjectVO>(subjectvo, HttpStatus.OK);
	}
	
	
	/**
	 * 
	 * @param pagesize
	 * @param pageno
	 * @return
	 */
		@RequestMapping(value = "/getAllSubjectList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<SubjectVO> getAllSubjectList() {
		SubjectVO subjectvo = new SubjectVO();
		try {
			List<Subject> complsorysubjectlist = new ArrayList<Subject>();
			List<Subject> optionalsubjectlist = new ArrayList<Subject>();
			List<Subject> subjectlist = classessetupservices.getAllSubjectDetails();
			for (Subject subject : subjectlist) {
				if (SUBJECTCOMPULSORY.equals(subject.getType())) {
					complsorysubjectlist.add(subject);
				} else if (SUBJECTOPTIONAL.equals(subject.getType())) {
					optionalsubjectlist.add(subject);
				} else {
					complsorysubjectlist.add(subject);
					optionalsubjectlist.add(subject);
				}
			}
			subjectvo.setComplsorysubjectlist(complsorysubjectlist);
			subjectvo.setOptionalsubjectlist(optionalsubjectlist);
		} catch (Exception e) {
			return new ResponseEntity<SubjectVO>(subjectvo, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<SubjectVO>(subjectvo, HttpStatus.OK);
		}
	
	
/**
 * 
 * @param classsetup
 * @return
 */
	@RequestMapping(value = "/saveClass", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClassSetupVO> saveNotificationTemplateSetup(
			@RequestBody ClassSetup classsetup) {
		ClassSetupVO classsetupvo=new ClassSetupVO();
		try {
			if(null!=classsetup){
			classessetupservices.saveClassesDetails(classsetup);
			}else{
				return	new ResponseEntity<ClassSetupVO>(classsetupvo, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			ClassSetupCriteria classsetupcriteria=new ClassSetupCriteria();
			classsetupcriteria.setPagenumber(1);
			classsetupcriteria.setPagesize(15);
			List<ClassSetup> classlist=classessetupservices.getClassesDetails(classsetupcriteria);
			classsetupvo.setClasssetupcriteria(classsetupcriteria);
			classsetupvo.setClasssetup(classlist);
		} catch (Exception e) {
			return	new ResponseEntity<ClassSetupVO>(classsetupvo, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
		return new ResponseEntity<ClassSetupVO>(classsetupvo, HttpStatus.OK);
	}
/**
 * 
 * @param classesetup
 * @return
 */
	@RequestMapping(value = "/deleteClassesSetup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClassSetupVO> deleteNotificationTemplate(
			@RequestBody ClassSetup classesetup) {
		ClassSetupVO classsetupvo=new ClassSetupVO();
		try {
			if(null!=classesetup){
			classessetupservices.deleteClass(classesetup);
			}else{
				return	new ResponseEntity<ClassSetupVO>(classsetupvo, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			ClassSetupCriteria classsetupcriteria=new ClassSetupCriteria();
			classsetupcriteria.setPagenumber(1);
			classsetupcriteria.setPagesize(15);
			List<ClassSetup> classlist=classessetupservices.getClassesDetails(classsetupcriteria);
			classsetupvo.setClasssetupcriteria(classsetupcriteria);
			classsetupvo.setClasssetup(classlist);
		} catch (Exception e) {
			return	new ResponseEntity<ClassSetupVO>(classsetupvo, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<ClassSetupVO>(classsetupvo, HttpStatus.OK);
	}
/**
 * 
 * @param pagesize
 * @param pageno
 * @return
 */
	@RequestMapping(value = "/getClasseslist/{pagesize}/{pageno}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClassSetupVO> getClassesSetupDetails(@PathVariable int pagesize,@PathVariable int pageno) {
		ClassSetupVO classsetupvo=new ClassSetupVO();
		try {
			ClassSetupCriteria classsetupcriteria=new ClassSetupCriteria();
			classsetupcriteria.setPagenumber(pageno);
			classsetupcriteria.setPagesize(pagesize);
			List<ClassSetup> classsetuplist = classessetupservices.getClassesDetails(classsetupcriteria);
			classsetupvo.setClasssetup(classsetuplist);
			classsetupvo.setClasssetupcriteria(classsetupcriteria);
		} catch (Exception e) {
			return	new ResponseEntity<ClassSetupVO>(classsetupvo, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<ClassSetupVO>(classsetupvo, HttpStatus.OK);
	}
/**
 * 
 * @param classsubject
 * @return
 */
	@RequestMapping(value = "/saveClassSubjectSetup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClassSubjectSetupVO> saveNotificationTemplateSetup(
			@RequestBody ClassSubjectSetup classsubject) {
		ClassSubjectSetupVO classsubjectsetupvo=new ClassSubjectSetupVO();
		try {
			if(null!=classsubject){
			classessetupservices.saveClassesSubjectDetails(classsubject);
			}else{
				return	new ResponseEntity<ClassSubjectSetupVO>(classsubjectsetupvo, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			ClassSetupCriteria classsetupcriteria=new ClassSetupCriteria();
			classsetupcriteria.setPagenumber(1);
			classsetupcriteria.setPagesize(15);
			List<ClassSubjectSetup> classsubjectlist=classessetupservices.getClassesSubjectDetails(classsetupcriteria);
			classsubjectsetupvo.setClasssubjectcriteria(classsetupcriteria);
			classsubjectsetupvo.setClasssubjectlist(classsubjectlist);
		} catch (Exception e) {
			return	new ResponseEntity<ClassSubjectSetupVO>(classsubjectsetupvo, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	
		return new ResponseEntity<ClassSubjectSetupVO>(classsubjectsetupvo, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param classsubjectsetup
	 * @return
	 */
	@RequestMapping(value = "/deleteClassSubjectSetup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClassSubjectSetupVO> deleteNotificationTemplate(
			@RequestBody ClassSubjectSetup classsubjectsetup) {
		ClassSubjectSetupVO classsubjectsetupvo=new ClassSubjectSetupVO();
		try {
			if(null!=classsubjectsetup){
			classessetupservices.deleteClassesSubjectDetails(classsubjectsetup);
			}else{
				return	new ResponseEntity<ClassSubjectSetupVO>(classsubjectsetupvo, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			ClassSetupCriteria classsetupcriteria=new ClassSetupCriteria();
			classsetupcriteria.setPagenumber(1);
			classsetupcriteria.setPagesize(15);
			List<ClassSubjectSetup> classsubjectlist=classessetupservices.getClassesSubjectDetails(classsetupcriteria);
			classsubjectsetupvo.setClasssubjectcriteria(classsetupcriteria);
			classsubjectsetupvo.setClasssubjectlist(classsubjectlist);
		} catch (Exception e) {
			return	new ResponseEntity<ClassSubjectSetupVO>(classsubjectsetupvo, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<ClassSubjectSetupVO>(classsubjectsetupvo, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param pagesize
	 * @param pageno
	 * @return
	 */
	@RequestMapping(value = "/getClassSubjectlist/{pagesize}/{pageno}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClassSubjectSetupVO> getNotificationSetupDetails(@PathVariable int pagesize,@PathVariable int pageno) {
		ClassSubjectSetupVO classsubjectsetupvo=new ClassSubjectSetupVO();
		try {
			ClassSetupCriteria classsetupcriteria=new ClassSetupCriteria();
			classsetupcriteria.setPagenumber(1);
			classsetupcriteria.setPagesize(15);
			List<ClassSubjectSetup> classsubjectlist=classessetupservices.getClassesSubjectDetails(classsetupcriteria);
			classsubjectsetupvo.setClasssubjectcriteria(classsetupcriteria);
			classsubjectsetupvo.setClasssubjectlist(classsubjectlist);
		} catch (Exception e) {
			return	new ResponseEntity<ClassSubjectSetupVO>(classsubjectsetupvo, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<ClassSubjectSetupVO>(classsubjectsetupvo, HttpStatus.OK);
	}


}
