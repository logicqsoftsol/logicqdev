package com.crm.logicq.model.classsetup;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ClassSubjectKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3089045582064374312L;

	@Column(name = "CLASS_ID")
	private Long classid;

	@Column(name = "SUB_ID")
	private Long subjectid;

	public Long getClassid() {
		return classid;
	}

	public void setClassid(Long classid) {
		this.classid = classid;
	}

	public Long getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(Long subjectid) {
		this.subjectid = subjectid;
	}

	@Override
	public String toString() {
		return "ClassSubjectKey [classid=" + classid + ", subjectid=" + subjectid + "]";
	}

}
