package com.crm.logicq.service.attendance;

import java.util.List;

import com.crm.logicq.model.attendance.AttendanceAggregationResult;
import com.crm.logicq.model.attendance.AttendanceCriteria;

public interface IAttendanceService {
	
 public List<AttendanceAggregationResult> searchAttendanceAccordingToType(AttendanceCriteria attedancecriteria) throws Exception;
	
	

}
