package com.crm.logicq.vo.download;

public class AttendanceReportCriteria extends DownloadCriteria {

	private String classname;
	private String sectionname;
	private String cardnumber;
	private String mobilenumber;
	

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

	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	@Override
	public String toString() {
		return "AttendanceReportCriteria [classname=" + classname + ", sectionname=" + sectionname + ", cardnumber="
				+ cardnumber + ", mobilenumber=" + mobilenumber + "]";
	}

	

	

}
