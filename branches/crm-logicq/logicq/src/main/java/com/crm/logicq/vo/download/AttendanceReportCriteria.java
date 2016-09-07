package com.crm.logicq.vo.download;

public class AttendanceReportCriteria extends DownloadCriteria {

	private String classname;
	private String sectionname;
	private String cardnumber;
	private String mobilenumber;
	private String attfromdate;
	private String atttodate;

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

	
	
	public String getAttfromdate() {
		return attfromdate;
	}

	public void setAttfromdate(String attfromdate) {
		this.attfromdate = attfromdate;
	}

	public String getAtttodate() {
		return atttodate;
	}

	public void setAtttodate(String atttodate) {
		this.atttodate = atttodate;
	}

	@Override
	public String toString() {
		return "AttendanceReportCriteria [classname=" + classname + ", sectionname=" + sectionname + ", cardnumber="
				+ cardnumber + ", mobilenumber=" + mobilenumber + "]";
	}

	

	

}
