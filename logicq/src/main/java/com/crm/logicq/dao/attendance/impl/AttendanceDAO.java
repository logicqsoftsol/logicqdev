package com.crm.logicq.dao.attendance.impl;

import java.util.List;

import org.hsqldb.lib.StringUtil;
import org.springframework.stereotype.Repository;

import com.crm.logicq.common.AbstractDAO;
import com.crm.logicq.dao.attendance.IAttendanceDAO;
import com.crm.logicq.model.attendance.AttendanceCriteria;
import com.crm.logicq.model.attendance.AttendanceDetails;
import com.crm.logicq.model.common.CommonProperty;

@Repository
public class AttendanceDAO extends AbstractDAO<AttendanceDetails> implements IAttendanceDAO{

	@Override
	public void saveAttendanceDetails(AttendanceDetails attendanceDetails) throws Exception{
		save(attendanceDetails);
	}

	@Override
	public void saveBulkAttendanceDetails(List<AttendanceDetails> attendanceDetails) throws Exception{
		bulkSave(attendanceDetails);
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
		if (1 == attedancecriteria.getPagenumber()) {
			Long recordcount=getRecordCount(AttendanceDetails.class);
			attedancecriteria.setTotalrecordcount(recordcount.intValue());
		}
		return executeQueryWithPagination(selectquery.toString(),attedancecriteria.getPagenumber(),attedancecriteria.getPagesize());
	}

	
}
