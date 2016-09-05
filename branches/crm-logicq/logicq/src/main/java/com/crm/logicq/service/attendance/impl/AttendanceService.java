package com.crm.logicq.service.attendance.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.crm.logicq.dao.attendance.IAttendanceDAO;
import com.crm.logicq.dao.attendance.IAttendanceReportDAO;
import com.crm.logicq.model.attendance.AttendanceAggregationResult;
import com.crm.logicq.model.attendance.AttendanceCriteria;
import com.crm.logicq.model.attendance.AttendanceDetails;
import com.crm.logicq.service.attendance.IAttendanceService;
import com.crm.logicq.vo.download.AttendanceReportCriteria;

@Service
@Transactional
public class AttendanceService  implements IAttendanceService{
	
	@Autowired
	IAttendanceDAO attendanceDAO;
	

	@Autowired
	IAttendanceReportDAO attendanceReportDAO;
	
	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void saveAttendance(List<AttendanceDetails> attendancedetails) throws Exception{
		attendanceDAO.saveBulkAttendanceDetails(attendancedetails);
	}
	
	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<AttendanceAggregationResult> getAttendanceCountAccordingToType(AttendanceCriteria attedancecriteria) throws Exception{
		return attendanceReportDAO.getAttendanceCountAccordingToType(attedancecriteria);
	}
	
	
	
	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<AttendanceDetails> getAttendanceAsTabular(AttendanceCriteria attedancecriteria) throws Exception{
		return attendanceDAO.getAttendanceDetailsAccordingToCriteria(attedancecriteria); 
	}

	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<AttendanceDetails> getAttendanceForReport(AttendanceReportCriteria attedancecriteria) throws Exception {
		
		return attendanceDAO.getAttendanceForReport(attedancecriteria);
	}
		

}
