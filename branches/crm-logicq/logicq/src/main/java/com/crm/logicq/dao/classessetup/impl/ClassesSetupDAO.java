package com.crm.logicq.dao.classessetup.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.crm.logicq.common.AbstractDAO;
import com.crm.logicq.dao.classessetup.IClassesSetupDAO;
import com.crm.logicq.model.classsetup.ClassSetup;
import com.crm.logicq.vo.classessetup.ClassSetupCriteria;

@Repository
public class ClassesSetupDAO extends AbstractDAO<ClassSetup> implements IClassesSetupDAO {

	@Override
	public List<ClassSetup> getClassesDetails(ClassSetupCriteria classcriteria) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveClassesDetails(ClassSetup classsetupdetails) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteClass(ClassSetup classsetupdetails) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
