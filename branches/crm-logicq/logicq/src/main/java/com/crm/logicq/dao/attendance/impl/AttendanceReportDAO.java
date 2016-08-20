package com.crm.logicq.dao.attendance.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hsqldb.lib.StringUtil;
import org.springframework.stereotype.Repository;

import com.crm.logicq.common.AbstractDAO;
import com.crm.logicq.constant.EntityType;
import com.crm.logicq.dao.attendance.IAttendanceReportDAO;
import com.crm.logicq.model.attendance.AttendanceAggregationResult;
import com.crm.logicq.model.attendance.AttendanceCriteria;
import com.crm.logicq.security.helper.DateHelper;
import com.crm.logicq.vo.user.BasicRegistrationVO;

@Repository
public class AttendanceReportDAO  extends AbstractDAO<AttendanceAggregationResult> implements IAttendanceReportDAO{
	
	
	@Override
	public List<AttendanceAggregationResult> getAttendanceCountAccordingToType(AttendanceCriteria attedancecriteria)
			throws Exception {
		List<AttendanceAggregationResult> attendanceresult = new ArrayList<AttendanceAggregationResult>();
		StringBuilder attendaceselectquery = new StringBuilder();
		StringBuilder attendacewherequery = new StringBuilder();
		String resultquery = null;
		attendaceselectquery.append("select ").append(" #GROUPBYFUNCTION ,")
				.append(" count(case when is_present ='A'  then 1 end) as absentcount ,");
		attendaceselectquery.append(" count(case when is_present ='P' then 1 end) AS presentcount ");
		attendaceselectquery.append(" from attendance_report where attd_date between ");
		if (null != attedancecriteria.getFromdate()) {
		String fromdate=DateHelper.convertDatetoStringWituoutTime(attedancecriteria.getFromdate());
			attendacewherequery.append("'"+fromdate+"'");
		} else {
			String fromdate=DateHelper.convertDatetoStringWituoutTime(new Date());
			attendacewherequery.append("'"+fromdate+"'");
		}
		if (null != attedancecriteria.getTodate()) {
			String todate=DateHelper.convertDatetoStringWituoutTime(attedancecriteria.getTodate());
			attendacewherequery.append(" and '"+todate+"'");
		} else {
			String todate=DateHelper.convertDatetoStringWituoutTime(new Date());
			attendacewherequery.append(" and '"+todate+"'");
		}
		if (!StringUtil.isEmpty(attedancecriteria.getApplicablefor())) {
			if ("EMPLOYEE".equals(attedancecriteria.getApplicablefor())
					|| "STUDENT".equals(attedancecriteria.getApplicablefor())) {
				attendacewherequery.append(" and attendance_for= '" + attedancecriteria.getApplicablefor() + "'");
			}
		}
		if (!StringUtil.isEmpty(attedancecriteria.getCardno())) {
			attendacewherequery.append(" and  identification_id = '" + attedancecriteria.getCardno() + "'");
		}

		if (!StringUtil.isEmpty(attedancecriteria.getMobileno())) {
			attendacewherequery.append(" and  mobile ='" + attedancecriteria.getMobileno() + "'");
		}

		if ("ALL".equals(attedancecriteria.getApplicablefor())) {
			resultquery = attendaceselectquery.append(attendacewherequery).toString().replace(" #GROUPBYFUNCTION ,",
					" ");

		} else if ("EMPSTD".equals(attedancecriteria.getApplicablefor())) {
			resultquery = attendaceselectquery.append(attendacewherequery.append("group by attendance_for")).toString()
					.replace(" #GROUPBYFUNCTION ", " attendance_for as applicablefor ");
		} else {
			resultquery = attendaceselectquery.append(attendacewherequery).toString();
		}
		//whole code need to change temporary add this code to handle issue
		List<Object> resultobjectlist = (List<Object>) execcuteSQLQuery(resultquery);
		for(Object obj:resultobjectlist){
		//resultobject.forEach((obj) -> {
			Object[] fetchobject=(Object[]) obj;
			AttendanceAggregationResult attendaceresult=new AttendanceAggregationResult();
			attendaceresult.setApplicablefor(String.valueOf(fetchobject[0]));
			attendaceresult.setAbsentcount(Integer.valueOf(String.valueOf(fetchobject[1])));
			attendaceresult.setPresentcount(Integer.valueOf(String.valueOf(fetchobject[2])));
			attendanceresult.add(attendaceresult);
		//});
		}
		return attendanceresult;
	}

}
