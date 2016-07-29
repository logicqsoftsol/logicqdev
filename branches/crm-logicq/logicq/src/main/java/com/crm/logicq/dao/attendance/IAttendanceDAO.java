package com.crm.logicq.dao.attendance;

import java.util.List;

import com.crm.logicq.model.attendance.AttendanceCriteria;
import com.crm.logicq.model.attendance.AttendanceDetails;

public interface IAttendanceDAO {
	public void saveAttendanceDetails(AttendanceDetails attendanceDetails) throws Exception;
	public void saveBulkAttendanceDetails(List<AttendanceDetails> attendanceDetails) throws Exception;
	
	public List<AttendanceDetails> getAttendanceDetailsAccordingToCriteria(AttendanceCriteria attedancecriteria) throws Exception;
	
	

}
