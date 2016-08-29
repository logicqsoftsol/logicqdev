package com.crm.logicq.vo.classessetup;

import java.io.Serializable;
import java.util.List;

import com.crm.logicq.model.classsetup.ClassSubjectSetup;

public class ClassSubjectSetupVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7145548420699983369L;
	
	private List<ClassSubjectSetup> classsubjectlist;
	private ClassSetupCriteria classsubjectcriteria;
	public List<ClassSubjectSetup> getClasssubjectlist() {
		return classsubjectlist;
	}
	public void setClasssubjectlist(List<ClassSubjectSetup> classsubjectlist) {
		this.classsubjectlist = classsubjectlist;
	}
	public ClassSetupCriteria getClasssubjectcriteria() {
		return classsubjectcriteria;
	}
	public void setClasssubjectcriteria(ClassSetupCriteria classsubjectcriteria) {
		this.classsubjectcriteria = classsubjectcriteria;
	}
	@Override
	public String toString() {
		return "ClassSubjectSetupVO [classsubjectlist=" + classsubjectlist + ", classsubjectcriteria="
				+ classsubjectcriteria + "]";
	}
	
	

}
