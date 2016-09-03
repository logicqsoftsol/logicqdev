package com.crm.logicq.vo.classessetup;

import java.io.Serializable;
import java.util.List;

import com.crm.logicq.model.classsetup.ClassSetup;
import com.crm.logicq.model.classsetup.Subject;

public class ClassSetupVO implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3666414918080005483L;
	private List<ClassSetup> classessetup;
	private ClassSetupCriteria classsetupcriteria;
	private List<Subject> compsubjectlist;
	private List<Subject> optionalsubjectlist;
	
	
	
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
	public List<Subject> getCompsubjectlist() {
		return compsubjectlist;
	}
	public void setCompsubjectlist(List<Subject> compsubjectlist) {
		this.compsubjectlist = compsubjectlist;
	}
	public List<Subject> getOptionalsubjectlist() {
		return optionalsubjectlist;
	}
	public void setOptionalsubjectlist(List<Subject> optionalsubjectlist) {
		this.optionalsubjectlist = optionalsubjectlist;
	}
	@Override
	public String toString() {
		return "ClassSetupVO [classessetup=" + classessetup + ", classsetupcriteria=" + classsetupcriteria
				+ ", compsubjectlist=" + compsubjectlist + ", optionalsubjectlist=" + optionalsubjectlist + "]";
	}
	
	

}
