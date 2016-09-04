package com.crm.logicq.vo.attendance;

import java.io.Serializable;

public class EducationVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2750136005739888166L;

	private String classname;
	
	private String sectionname;

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getSectionname() {
		return sectionname;
	}

	public void setSectionname(String sectionname) {
		this.sectionname = sectionname;
	}

	@Override
	public String toString() {
		return "EducationVO [classname=" + classname + ", sectionname=" + sectionname + "]";
	}
	
	

}
