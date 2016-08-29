package com.crm.logicq.dao.classsubject.impl;

import java.util.List;

import com.crm.logicq.model.classsetup.ClassSubjectSetup;
import com.crm.logicq.vo.classessetup.ClassSetupCriteria;

public interface IClassesSubjectDAO {
	
	public List<ClassSubjectSetup> getClassesSubjectDetails(ClassSetupCriteria classcriteria) throws Exception;

	public void saveClassesSubjectDetails(ClassSubjectSetup classssubject) throws Exception;

	public void deleteClassesSubjectDetails(ClassSubjectSetup classsetupdetails) throws Exception;

}
