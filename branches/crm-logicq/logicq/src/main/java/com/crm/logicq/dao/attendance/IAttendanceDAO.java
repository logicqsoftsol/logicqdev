package com.crm.logicq.dao.attendance;

import com.crm.logicq.model.attendance.AttendanceDetails;

public interface IAttendanceDAO {
	public void saveAttendanceDetails(AttendanceDetails attendanceDetails) throws Exception;

}
