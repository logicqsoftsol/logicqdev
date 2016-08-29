package com.crm.logicq.vo.classessetup;

import java.io.Serializable;
import java.util.List;

import com.crm.logicq.model.classsetup.Subject;

public class SubjectVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5223928283173865925L;
	
	private List<Subject> subjectlist;
	private ClassSetupCriteria subjectcriteria;
	public List<Subject> getSubjectlist() {
		return subjectlist;
	}
	public void setSubjectlist(List<Subject> subjectlist) {
		this.subjectlist = subjectlist;
	}
	public ClassSetupCriteria getSubjectcriteria() {
		return subjectcriteria;
	}
	public void setSubjectcriteria(ClassSetupCriteria subjectcriteria) {
		this.subjectcriteria = subjectcriteria;
	}
	@Override
	public String toString() {
		return "SubjectVO [subjectlist=" + subjectlist + ", subjectcriteria=" + subjectcriteria + "]";
	}


}
