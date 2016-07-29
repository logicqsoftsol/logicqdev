package com.crm.logicq.vo.attendance;

import java.util.List;

import com.crm.logicq.model.attendance.AttendanceCriteria;
import com.crm.logicq.model.attendance.AttendanceDetails;

public class AttendanceDetailsVO {
	
	private List<AttendanceDetails> attendacedetails;
	private AttendanceCriteria attendanceCriteria;
	public List<AttendanceDetails> getAttendacedetails() {
		return attendacedetails;
	}
	public void setAttendacedetails(List<AttendanceDetails> attendacedetails) {
		this.attendacedetails = attendacedetails;
	}
	public AttendanceCriteria getAttendanceCriteria() {
		return attendanceCriteria;
	}
	public void setAttendanceCriteria(AttendanceCriteria attendanceCriteria) {
		this.attendanceCriteria = attendanceCriteria;
	}
	
	@Override
	public String toString() {
		return "AttendanceDetailsVO [attendacedetails=" + attendacedetails + ", attendanceCriteria="
				+ attendanceCriteria + "]";
	}
	

}
