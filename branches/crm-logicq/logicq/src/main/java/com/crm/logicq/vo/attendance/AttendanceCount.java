package com.crm.logicq.vo.attendance;

import java.util.Date;

public class AttendanceCount {
	
	private int presentcount;
	
	private int  absentcount;
	
	private String attendanceFor;
	
	private Date todate;
	
	private Date fromdate;

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

	public String getAttendanceFor() {
		return attendanceFor;
	}

	public void setAttendanceFor(String attendanceFor) {
		this.attendanceFor = attendanceFor;
	}

	public Date getTodate() {
		return todate;
	}

	public void setTodate(Date todate) {
		this.todate = todate;
	}

	public Date getFromdate() {
		return fromdate;
	}

	public void setFromdate(Date fromdate) {
		this.fromdate = fromdate;
	}
	
	

	@Override
	public String toString() {
		return "AttendanceCount [presentcount=" + presentcount + ", absentcount=" + absentcount + ", attendanceFor="
				+ attendanceFor + ", todate=" + todate + ", fromdate=" + fromdate + "]";
	}

	
	
}
