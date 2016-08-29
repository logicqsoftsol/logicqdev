package com.crm.logicq.dao.classsubject;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.crm.logicq.common.AbstractDAO;
import com.crm.logicq.dao.classsubject.impl.IClassesSubjectDAO;
import com.crm.logicq.model.classsetup.ClassSetup;
import com.crm.logicq.model.classsetup.ClassSubjectSetup;
import com.crm.logicq.model.classsetup.Subject;
import com.crm.logicq.vo.classessetup.ClassSetupCriteria;

@Repository
public class ClassesSubjectDAO  extends AbstractDAO<ClassSubjectSetup> implements IClassesSubjectDAO {

	@Override
	public List<ClassSubjectSetup> getClassesSubjectDetails(ClassSetupCriteria classcriteria) throws Exception {
		StringBuilder  selectquery= new StringBuilder(" from ClassSubjectSetup");
		if (1 == classcriteria.getPagenumber()) {
			Long recordcount=getRecordCount(Subject.class);
			classcriteria.setTotalrecordcount(recordcount.intValue());
		}
		return executeQueryWithPagination(selectquery.toString(), classcriteria.getPagenumber(), classcriteria.getPagesize());
	}

	@Override
	public void saveClassesSubjectDetails(ClassSubjectSetup classssubject) throws Exception {
		saveOrUpdate(classssubject);
	}

	@Override
	public void deleteClassesSubjectDetails(ClassSubjectSetup classsetupdetails) throws Exception {
		delete(classsetupdetails);
	}

}
