package com.crm.logicq.dao.attendance.impl;

import java.util.Date;
import java.util.List;

import org.hsqldb.lib.StringUtil;
import org.springframework.stereotype.Repository;

import com.crm.logicq.common.AbstractDAO;
import com.crm.logicq.dao.attendance.IAttendanceDAO;
import com.crm.logicq.model.attendance.AttendanceCriteria;
import com.crm.logicq.model.attendance.AttendanceDetails;
import com.crm.logicq.security.helper.DateHelper;
import com.crm.logicq.vo.download.AttendanceReportCriteria;

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

	@Override
	public List<AttendanceDetails> getAttendanceForReport(AttendanceReportCriteria attedancecriteria) throws Exception {
		StringBuilder  selectquery= new StringBuilder(" from AttendanceDetails attd  ");
		StringBuilder  wherequery= new StringBuilder();
		if(!StringUtil.isEmpty(attedancecriteria.getApplicableto())){
			wherequery.append(" where ");
			if("STUDENT".equals(attedancecriteria.getApplicableto())){
				wherequery.append(" attd.attendancefor = ");
				wherequery.append("'STUDENT'");
			}
			else if("EMPLOYEE".equals(attedancecriteria.getApplicableto())){
				wherequery.append(" attd.attendancefor = ");
				wherequery.append(" 'EMPLOYEE' ");
			}
			else if("ALL".equals(attedancecriteria.getApplicableto())){
				wherequery.append(" attd.attendancefor IN ");
				wherequery.append("('EMPLOYEE'),('STUDENT')");
			}
		}
		
		if(!StringUtil.isEmpty(attedancecriteria.getClassname())){
			wherequery.append(" and attd.classname='" + attedancecriteria.getClassname() + "'");
		}
		if(!StringUtil.isEmpty(attedancecriteria.getSectionname())){
			wherequery.append(" and attd.sectionname='" + attedancecriteria.getSectionname() + "'");
		}
		String fromDatestring = null;
		String todatestring = null;

		
		if (null != attedancecriteria.getReportof()) {
			Date todate = new Date();
			Date fromDate = DateHelper.convertDateAccordingToString(attedancecriteria.getReportof());
			fromDatestring = DateHelper.convertDatetoString(fromDate);
			todatestring = DateHelper.convertDatetoString(todate);
			attedancecriteria.setAttfromdate(fromDatestring);
			attedancecriteria.setAtttodate(todatestring);
			//attedancecriteria.setFromdate(fromDate);
			//attedancecriteria.setTodate(todate);
		}else
		if (attedancecriteria.getFromdate() != null && attedancecriteria.getTodate() != null) {
			fromDatestring = DateHelper.convertDatetoString(attedancecriteria.getFromdate());
			todatestring = DateHelper.convertDatetoString(attedancecriteria.getTodate());
		} else {
			
		}
		if(!StringUtil.isEmpty(fromDatestring) && !StringUtil.isEmpty(todatestring)){
			wherequery.append(" and attd.key.date between '" + fromDatestring + "' AND '" + todatestring + "'");
		}
		if(!StringUtil.isEmpty(attedancecriteria.getCardnumber())){
			wherequery.append(" and attd.key.idetificationid = '" + attedancecriteria.getCardnumber()+"'");
		}
		if(!StringUtil.isEmpty(attedancecriteria.getMobilenumber())){
			wherequery.append(" and attd.mobile = '" + attedancecriteria.getMobilenumber()+"'");
		}
		String query=selectquery.append(wherequery).toString();
		return executeQuery(query);
	}

	
}
