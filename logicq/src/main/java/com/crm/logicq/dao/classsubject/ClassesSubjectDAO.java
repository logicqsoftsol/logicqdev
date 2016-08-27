package com.crm.logicq.dao.classsubject;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.crm.logicq.common.AbstractDAO;
import com.crm.logicq.dao.classsubject.impl.IClassesSubjectDAO;
import com.crm.logicq.model.classsetup.ClassSetup;
import com.crm.logicq.model.classsetup.ClassSubjectSetup;
import com.crm.logicq.vo.classessetup.ClassSetupCriteria;

@Repository
public class ClassesSubjectDAO  extends AbstractDAO<ClassSubjectSetup> implements IClassesSubjectDAO {

	@Override
	public List<ClassSubjectSetup> getClassesSubjectDetails(ClassSetupCriteria classcriteria) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveClassesSubjectDetails(ClassSubjectSetup classssubject) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteClassesSubjectDetails(ClassSetup classsetupdetails) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
