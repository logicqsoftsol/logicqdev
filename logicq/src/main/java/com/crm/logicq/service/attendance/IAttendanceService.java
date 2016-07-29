package com.crm.logicq.service.attendance;

import java.util.List;

import com.crm.logicq.model.attendance.AttendanceAggregationResult;
import com.crm.logicq.model.attendance.AttendanceCriteria;
import com.crm.logicq.model.attendance.AttendanceDetails;

public interface IAttendanceService {

	public void saveAttendance(List<AttendanceDetails> attendancedetails) throws Exception;

	public List<AttendanceAggregationResult> getAttendanceCountAccordingToType(AttendanceCriteria attedancecriteria)
			throws Exception;

	public List<AttendanceDetails> getAttendanceAsTabular(AttendanceCriteria attedancecriteria) throws Exception;

}
