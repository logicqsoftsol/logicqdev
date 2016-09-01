package com.crm.logicq.vo.classessetup;

import java.io.Serializable;
import java.util.List;

import com.crm.logicq.model.classsetup.ClassSetup;

public class ClassSetupVO implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3666414918080005483L;
	private List<ClassSetup> classessetup;
	private ClassSetupCriteria classsetupcriteria;
	
	
	
	public List<ClassSetup> getClassessetup() {
		return classessetup;
	}
	public void setClassessetup(List<ClassSetup> classessetup) {
		this.classessetup = classessetup;
	}
	public ClassSetupCriteria getClasssetupcriteria() {
		return classsetupcriteria;
	}
	public void setClasssetupcriteria(ClassSetupCriteria classsetupcriteria) {
		this.classsetupcriteria = classsetupcriteria;
	}
	
	

}
