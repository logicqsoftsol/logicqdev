package com.crm.logicq.model.classsetup;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class ClassSectionKey implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4152040432323239614L;

	@Column(name = "CLASS_ID", nullable = false)
	private Long classid;

	 @Column(name = "SECTION_ID",nullable = false)
	 private Long sectionid;

	public Long getClassid() {
		return classid;
	}

	public void setClassid(Long classid) {
		this.classid = classid;
	}

	public Long getSectionid() {
		return sectionid;
	}

	public void setSectionid(Long sectionid) {
		this.sectionid = sectionid;
	}

	
	@Override
	public String toString() {
		return "ClassSectionKey [classid=" + classid + ", sectionid=" + sectionid + "]";
	}

	
	
	

}
