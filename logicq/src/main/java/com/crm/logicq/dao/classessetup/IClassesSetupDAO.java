package com.crm.logicq.dao.classessetup;

import java.util.List;

import com.crm.logicq.model.classsetup.ClassSetup;
import com.crm.logicq.vo.classessetup.ClassSetupCriteria;

public interface IClassesSetupDAO {

	public List<ClassSetup> getClassesDetails(ClassSetupCriteria classcriteria) throws Exception;

	public void saveClassesDetails(ClassSetup classsetupdetails) throws Exception;

	public void deleteClass(ClassSetup classsetupdetails) throws Exception;

	
}
