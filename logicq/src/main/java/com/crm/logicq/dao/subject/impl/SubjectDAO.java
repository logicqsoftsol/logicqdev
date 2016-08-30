package com.crm.logicq.dao.subject.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.crm.logicq.common.AbstractDAO;
import com.crm.logicq.dao.subject.ISubjectDAO;
import com.crm.logicq.model.classsetup.Subject;
import com.crm.logicq.model.event.EventDetails;
import com.crm.logicq.vo.classessetup.ClassSetupCriteria;

@Repository
public class SubjectDAO  extends AbstractDAO<Subject> implements ISubjectDAO{

	@Override
	public List<Subject> getSubjectDetails(ClassSetupCriteria subjectcriteria) throws Exception {
		StringBuilder  selectquery= new StringBuilder(" from Subject");
		if (1 == subjectcriteria.getPagenumber()) {
			Long recordcount=getRecordCount(Subject.class);
			subjectcriteria.setTotalrecordcount(recordcount.intValue());
		}
		return executeQueryWithPagination(selectquery.toString(), subjectcriteria.getPagenumber(), subjectcriteria.getPagesize());
	}

	@Override
	public void saveSubjectDetails(Subject subjectdetails) throws Exception {
		saveOrUpdate(subjectdetails);
		
	}

	@Override
	public void deleteSubject(Subject subjectdetails) throws Exception {
		delete(subjectdetails);
	}

	@Override
	public List<Subject> getAllSubjectDetails() throws Exception {
		return (List<Subject>) loadClass(Subject.class);
	}

}
