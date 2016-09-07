package com.crm.logicq.vo.attendance;

public class AttendanceVO {
	private String id;
	private String name;
	private String mobileno;
	private String intime;
	private String outtime;
	private String date;
	private String attendance;

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getIntime() {
		return intime;
	}
	public void setIntime(String intime) {
		this.intime = intime;
	}
	public String getOuttime() {
		return outtime;
	}
	public void setOuttime(String outtime) {
		this.outtime = outtime;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
    public String getAttendance() {
    
    	return attendance;
    }

    public void setAttendance(String attendance) {
		this.attendance = attendance;
	}
	
	@Override
	public String toString() {
		return "AttendanceVO [id=" + id + ", name=" + name + ", mobileno=" + mobileno + ", intime=" + intime
				+ ", outtime=" + outtime + ", date=" + date + ",attendance="+attendance + "]";
	}

}
