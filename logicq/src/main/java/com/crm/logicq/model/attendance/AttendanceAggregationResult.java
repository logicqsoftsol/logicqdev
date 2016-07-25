package com.crm.logicq.model.attendance;

public class AttendanceAggregationResult {

	private int presentcount;

	private int absentcount;

	private String applicablefor;

	
	
	public int getPresentcount() {
		return presentcount;
	}

	public void setPresentcount(int presentcount) {
		this.presentcount = presentcount;
	}

	public int getAbsentcount() {
		return absentcount;
	}

	public void setAbsentcount(int absentcount) {
		this.absentcount = absentcount;
	}

	public String getApplicablefor() {
		return applicablefor;
	}

	public void setApplicablefor(String applicablefor) {
		this.applicablefor = applicablefor;
	}

	
	
}
