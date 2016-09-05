package com.crm.logicq.dao.attendance;

import java.util.List;

import com.crm.logicq.model.attendance.AttendanceCriteria;
import com.crm.logicq.model.attendance.AttendanceDetails;
import com.crm.logicq.model.common.CommonProperty;
import com.crm.logicq.vo.download.AttendanceReportCriteria;

public interface IAttendanceDAO {
	public void saveAttendanceDetails(AttendanceDetails attendanceDetails) throws Exception;
	public void saveBulkAttendanceDetails(List<AttendanceDetails> attendanceDetails) throws Exception;
	
	public List<AttendanceDetails> getAttendanceDetailsAccordingToCriteria(AttendanceCriteria attedancecriteria) throws Exception;
	
	public List<AttendanceDetails> getAttendanceForReport(AttendanceReportCriteria attedancecriteria) throws Exception;

}
