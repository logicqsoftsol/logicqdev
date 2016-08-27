package com.crm.logicq.dao.subject.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.crm.logicq.common.AbstractDAO;
import com.crm.logicq.dao.subject.ISubjectDAO;
import com.crm.logicq.model.classsetup.Subject;
import com.crm.logicq.vo.classessetup.ClassSetupCriteria;

@Repository
public class SubjectDAO  extends AbstractDAO<Subject> implements ISubjectDAO{

	@Override
	public List<Subject> getSubjectDetails(ClassSetupCriteria subjectcriteria) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveSubjectDetails(Subject subjectdetails) throws Exception {
		saveOrUpdate(subjectdetails);
		
	}

	@Override
	public void deleteSubject(Subject subjectdetails) throws Exception {
		delete(subjectdetails);
	}

}
