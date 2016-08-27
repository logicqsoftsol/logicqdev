package com.crm.logicq.dao.subject;

import java.util.List;

import com.crm.logicq.model.classsetup.Subject;
import com.crm.logicq.vo.classessetup.ClassSetupCriteria;

public interface ISubjectDAO {
	
	public List<Subject> getSubjectDetails(ClassSetupCriteria subjectcriteria) throws Exception;

	public void saveSubjectDetails(Subject subjectdetails) throws Exception;

	public void deleteSubject(Subject subjectdetails) throws Exception;
	

}
