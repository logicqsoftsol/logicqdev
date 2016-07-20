package com.crm.logicq.dao.attendance.impl;

import org.springframework.stereotype.Repository;

import com.crm.logicq.common.AbstractDAO;
import com.crm.logicq.dao.attendance.IAttendanceDAO;
import com.crm.logicq.model.attendance.AttendanceDetails;

@Repository
public class AttendanceDAO extends AbstractDAO<AttendanceDetails> implements IAttendanceDAO{

	public void saveAttendanceDetails(AttendanceDetails attendanceDetails) throws Exception{
		save(attendanceDetails);
	}
}
