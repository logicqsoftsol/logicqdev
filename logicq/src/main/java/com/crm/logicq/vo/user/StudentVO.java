package com.crm.logicq.vo.user;

import java.io.Serializable;
import java.util.List;

public class StudentVO implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1062767647975485742L;
	
	private List<BasicRegistrationVO> studentlist;
	private StudentCriteria studentcriteria;
	
	public List<BasicRegistrationVO> getStudentlist() {
		return studentlist;
	}
	public void setStudentlist(List<BasicRegistrationVO> studentlist) {
		this.studentlist = studentlist;
	}
	public StudentCriteria getStudentcriteria() {
		return studentcriteria;
	}
	public void setStudentcriteria(StudentCriteria studentcriteria) {
		this.studentcriteria = studentcriteria;
	}
	
	
}
