package com.crm.logicq.vo.user;

import java.io.Serializable;
import java.util.List;

public class EmployeeVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7192014727174773266L;
	
	private List<BasicRegistrationVO> employeelist;
	private EmployeeCriteria employeecriteria;
	
	public List<BasicRegistrationVO> getEmployeelist() {
		return employeelist;
	}
	public void setEmployeelist(List<BasicRegistrationVO> employeelist) {
		this.employeelist = employeelist;
	}
	public EmployeeCriteria getEmployeecriteria() {
		return employeecriteria;
	}
	public void setEmployeecriteria(EmployeeCriteria employeecriteria) {
		this.employeecriteria = employeecriteria;
	}
     
     
}
