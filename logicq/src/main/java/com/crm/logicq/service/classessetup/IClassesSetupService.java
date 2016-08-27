package com.crm.logicq.service.classessetup;

import java.util.List;

import com.crm.logicq.model.classsetup.ClassSetup;
import com.crm.logicq.model.classsetup.ClassSubjectSetup;
import com.crm.logicq.model.classsetup.Subject;
import com.crm.logicq.vo.classessetup.ClassSetupCriteria;



public interface IClassesSetupService {
	
	public List<Subject> getSubjectDetails(ClassSetupCriteria subjectcriteria) throws Exception;

	public void saveSubjectDetails(Subject subjectdetails) throws Exception;

	public void deleteSubject(Subject subjectdetails) throws Exception;
	
	
	public List<ClassSetup> getClassesDetails(ClassSetupCriteria classcriteria) throws Exception;

	public void saveClassesDetails(ClassSetup classsetupdetails) throws Exception;

	public void deleteClass(ClassSetup classsetupdetails) throws Exception;

	
	public List<ClassSubjectSetup> getClassesSubjectDetails(ClassSetupCriteria classcriteria) throws Exception;

	public void saveClassesSubjectDetails(ClassSubjectSetup classssubject) throws Exception;

	public void deleteClassesSubjectDetails(ClassSetup classsetupdetails) throws Exception;

}
