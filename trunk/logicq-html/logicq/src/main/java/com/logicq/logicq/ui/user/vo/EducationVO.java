package com.logicq.logicq.ui.user.vo;

import java.io.Serializable;

public class EducationVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6871451089963944163L;
	
	private String higestQualicfication;
	private String specialization;
	
	public String getHigestQualicfication() {
		return higestQualicfication;
	}
	public void setHigestQualicfication(String higestQualicfication) {
		this.higestQualicfication = higestQualicfication;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

}
