package com.crm.logicq.service.classessetup.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.crm.logicq.dao.classessetup.IClassesSetupDAO;
import com.crm.logicq.dao.classsubject.impl.IClassesSubjectDAO;
import com.crm.logicq.dao.subject.ISubjectDAO;
import com.crm.logicq.model.classsetup.ClassSetup;
import com.crm.logicq.model.classsetup.ClassSubjectSetup;
import com.crm.logicq.model.classsetup.Subject;
import com.crm.logicq.service.classessetup.IClassesSetupService;
import com.crm.logicq.vo.classessetup.ClassSetupCriteria;

@Service
@Transactional
public class ClassesSetupServiceImpl implements IClassesSetupService{

	@Autowired
	ISubjectDAO subjectdao;
	
	@Autowired
	IClassesSetupDAO classsetupdao;
	
	@Autowired
	IClassesSubjectDAO classsubjectdao;
	
	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<Subject> getSubjectDetails(ClassSetupCriteria subjectcriteria) throws Exception {
		return subjectdao.getSubjectDetails(subjectcriteria);
	}

	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void saveSubjectDetails(Subject subjectdetails) throws Exception {
		subjectdao.saveSubjectDetails(subjectdetails);
	}

	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void deleteSubject(Subject subjectdetails) throws Exception {
		subjectdao.deleteSubject(subjectdetails);
	}

	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<ClassSetup> getClassesDetails(ClassSetupCriteria classcriteria) throws Exception {
		return classsetupdao.getClassesDetails(classcriteria);
	}

	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void saveClassesDetails(ClassSetup classsetupdetails) throws Exception {
		classsetupdao.saveClassesDetails(classsetupdetails);
		
	}

	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void deleteClass(ClassSetup classsetupdetails) throws Exception {
		classsetupdao.deleteClass(classsetupdetails);
		
	}

	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<ClassSubjectSetup> getClassesSubjectDetails(ClassSetupCriteria classcriteria) throws Exception {
		// TODO Auto-generated method stub
		return classsubjectdao.getClassesSubjectDetails(classcriteria);
	}

	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void saveClassesSubjectDetails(ClassSubjectSetup classssubject) throws Exception {
		classsubjectdao.saveClassesSubjectDetails(classssubject);
	}

	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public void deleteClassesSubjectDetails(ClassSubjectSetup classsetupdetails) throws Exception {
		classsubjectdao.deleteClassesSubjectDetails(classsetupdetails);
	}

}
