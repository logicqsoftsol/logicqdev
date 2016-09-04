package com.crm.logicq.dao.attendance.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hsqldb.lib.StringUtil;
import org.springframework.stereotype.Repository;

import com.crm.logicq.common.AbstractDAO;
import com.crm.logicq.dao.attendance.IAttendanceDAO;
import com.crm.logicq.model.attendance.AttendanceCriteria;
import com.crm.logicq.model.attendance.AttendanceDetails;
import com.crm.logicq.security.helper.DateHelper;

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
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		 
		StringBuilder  selectquery= new StringBuilder(" from AttendanceDetails attd where ");
		if(!StringUtil.isEmpty(attedancecriteria.getApplicablefor())){
			;
			if("STUDENT".equals(attedancecriteria.getApplicablefor())){
				selectquery.append(" attd.attendancefor IN ");
				selectquery.append("('STUDENT')");
			}
			else if("EMPLOYEE".equals(attedancecriteria.getApplicablefor())){
				selectquery.append(" attd.attendancefor IN ");
				selectquery.append("('EMPLOYEE')");
			}
			else if("ALL".equals(attedancecriteria.getApplicablefor())){
				selectquery.append(" attd.attendancefor IN ");
				selectquery.append("('EMPLOYEE'),('STUDENT')");
			}
			else if("CLASS".equals(attedancecriteria.getApplicablefor())){
				if(!("undefined".equals(attedancecriteria.getClassName()))){
					
					selectquery.append(" attd.classname='"+attedancecriteria.getClassName()+"'");
				}
                    if(!("undefined".equals(attedancecriteria.getSectionName()))){
					
					selectquery.append(" attd.sectionname='"+attedancecriteria.getSectionName()+"'");
				}
				
			}
			
			if (attedancecriteria.getFromdate() != null && attedancecriteria.getTodate() != null) {
				System.out.println("from date is " + format.format(attedancecriteria.getFromdate()));
				System.out.println("To date is " + format.format(attedancecriteria.getTodate()));
				//selectquery.append("and attd.key.date between" +format.format(attedancecriteria.getFromdate()) + "AND"  +format.format(attedancecriteria.getTodate()));
			}
			Date fromDate = DateHelper.convertDateAccordingToString(attedancecriteria.getReportFor());
			selectquery.append("and attd.key.date between '" + format.format(fromDate) + "' AND '" + format.format(new Date())+"'");
			if ( !("undefined".equals(attedancecriteria.getCardno()))) {
				selectquery.append(" and attd.key.idetificationid =" + attedancecriteria.getCardno());
			}
		}
		if (1 == attedancecriteria.getPagenumber()) {
			Long recordcount = getRecordCount(AttendanceDetails.class);
			attedancecriteria.setTotalrecordcount(recordcount.intValue());
		}
		return executeQueryWithPagination(selectquery.toString(),attedancecriteria.getPagenumber(),attedancecriteria.getPagesize());
	}

	
}
