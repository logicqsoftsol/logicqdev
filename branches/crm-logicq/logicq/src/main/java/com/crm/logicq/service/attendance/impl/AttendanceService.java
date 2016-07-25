package com.crm.logicq.service.attendance.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.crm.logicq.dao.attendance.IAttendanceDAO;
import com.crm.logicq.model.attendance.AttendanceAggregationResult;
import com.crm.logicq.model.attendance.AttendanceCriteria;
import com.crm.logicq.model.user.User;
import com.crm.logicq.service.attendance.IAttendanceService;

@Service
@Transactional
public class AttendanceService  implements IAttendanceService{
	
	@Autowired
	IAttendanceDAO attendanceDAO;
	
	public void saveAttendance(List<User> cardDetails) throws Exception{
	
	}
	
	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<AttendanceAggregationResult> searchAttendanceAccordingToType(AttendanceCriteria attedancecriteria) throws Exception{
		List<AttendanceAggregationResult> attendancereport=new ArrayList<AttendanceAggregationResult>();
		AttendanceAggregationResult attednacestudent=new AttendanceAggregationResult();
		attednacestudent.setAbsentcount(100);
		attednacestudent.setPresentcount(900);
		attednacestudent.setApplicablefor("STUDENT");
		attendancereport.add(attednacestudent);
		AttendanceAggregationResult attednaceemployee=new AttendanceAggregationResult();
		attednaceemployee.setAbsentcount(13);
		attednaceemployee.setPresentcount(60);
		attednaceemployee.setApplicablefor("EMPLOYEE");
		attendancereport.add(attednaceemployee);
		return attendancereport;
	}
	

}
