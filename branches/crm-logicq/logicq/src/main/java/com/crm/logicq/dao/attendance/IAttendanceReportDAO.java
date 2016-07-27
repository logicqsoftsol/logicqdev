package com.crm.logicq.dao.attendance;

import java.util.List;

import com.crm.logicq.model.attendance.AttendanceAggregationResult;
import com.crm.logicq.model.attendance.AttendanceCriteria;

public interface IAttendanceReportDAO {
	
	public List<AttendanceAggregationResult> getAttendanceCountAccordingToType(AttendanceCriteria attedancecriteria) throws Exception;	

}
