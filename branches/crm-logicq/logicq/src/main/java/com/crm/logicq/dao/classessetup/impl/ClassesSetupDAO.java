package com.crm.logicq.dao.classessetup.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.crm.logicq.common.AbstractDAO;
import com.crm.logicq.dao.classessetup.IClassesSetupDAO;
import com.crm.logicq.model.classsetup.ClassSetup;
import com.crm.logicq.model.classsetup.Subject;
import com.crm.logicq.vo.classessetup.ClassSetupCriteria;

@Repository
public class ClassesSetupDAO extends AbstractDAO<ClassSetup> implements IClassesSetupDAO {

	@Override
	public List<ClassSetup> getClassesDetails(ClassSetupCriteria classcriteria) throws Exception {
		StringBuilder  selectquery= new StringBuilder(" from ClassSetup");
		if (1 == classcriteria.getPagenumber()) {
			Long recordcount=getRecordCount(Subject.class);
			classcriteria.setTotalrecordcount(recordcount.intValue());
		}
		return executeQueryWithPagination(selectquery.toString(), classcriteria.getPagenumber(), classcriteria.getPagesize());
	}

	@Override
	public void saveClassesDetails(ClassSetup classsetupdetails) throws Exception {
		saveOrUpdate(classsetupdetails);
	}

	@Override
	public void deleteClass(ClassSetup classsetupdetails) throws Exception {
		delete(classsetupdetails);
	}

}
