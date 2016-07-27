package com.crm.logicq.dao.attendance.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hsqldb.lib.StringUtil;
import org.springframework.stereotype.Repository;

import com.crm.logicq.common.AbstractDAO;
import com.crm.logicq.dao.attendance.IAttendanceDAO;
import com.crm.logicq.model.attendance.AttendanceCriteria;
import com.crm.logicq.model.attendance.AttendanceDetails;

@Repository
public class AttendanceDAO extends AbstractDAO<AttendanceDetails> implements IAttendanceDAO{

	public void saveAttendanceDetails(AttendanceDetails attendanceDetails) throws Exception{
		save(attendanceDetails);
	}

	@Override
	public List<AttendanceDetails> getAttendanceDetailsAccordingToCriteria(AttendanceCriteria attedancecriteria)
			throws Exception {
		StringBuilder  selectquery= new StringBuilder(" from AttendanceDetails attd where ");
		if(!StringUtil.isEmpty(attedancecriteria.getApplicablefor())){
			selectquery.append(" attd.attendancefor IN ");
			if("EMPSTD".equals(attedancecriteria.getApplicablefor())){
				selectquery.append("('EMPLOYEE','STUDENT')");
			}
			if("STUDENT".equals(attedancecriteria.getApplicablefor())){
				selectquery.append("('STUDENT')");
			}
			if("EMPLOYEE".equals(attedancecriteria.getApplicablefor())){
				selectquery.append("('EMPLOYEE')");
			}
		}
		
		return execcuteQuery(selectquery.toString());
	}

	
}
