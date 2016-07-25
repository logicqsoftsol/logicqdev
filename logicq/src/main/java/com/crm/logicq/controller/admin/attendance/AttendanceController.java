package com.crm.logicq.controller.admin.attendance;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hsqldb.lib.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crm.logicq.model.attendance.AttendanceAggregationResult;
import com.crm.logicq.model.attendance.AttendanceCriteria;
import com.crm.logicq.security.helper.DateHelper;
import com.crm.logicq.service.attendance.IAttendanceService;
import com.crm.logicq.service.user.IUserService;
import com.crm.logicq.vo.attendance.AttendanceCount;
import com.crm.logicq.vo.attendance.AttendanceVO;


@RestController
@RequestMapping("/admin/attendance")
public class AttendanceController {

  @Autowired
  IAttendanceService attendanceservice;
  

	
	
	@RequestMapping(value = "/searchAttendance/{criteriadate}/{applicablefor}/{id}/{mobileno}/{cardno}/{fromdate}/{todate}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AttendanceAggregationResult>> viewAttendanceReport(@PathVariable String criteriadate,@PathVariable String applicablefor,@PathVariable String id,@PathVariable String mobileno,@PathVariable String cardno,@PathVariable String fromdate,@PathVariable String todate) {
		List<AttendanceAggregationResult> attendanceaggregation = null;
		try {
			AttendanceCriteria attedancecriteria = new AttendanceCriteria();
			if (!StringUtil.isEmpty(cardno)) {
				attedancecriteria.setCardno(cardno);
			}
			if (!StringUtil.isEmpty(mobileno)) {
				attedancecriteria.setMobileno(mobileno);
			}
			if (!StringUtil.isEmpty(id)) {
				attedancecriteria.setUserid(id);
			}
			if (!StringUtil.isEmpty(todate)) {
				attedancecriteria.setTodate(DateHelper.convertStringtoDate(todate));
			}
			if (!StringUtil.isEmpty(fromdate)) {
				attedancecriteria.setFromdate(DateHelper.convertStringtoDate(fromdate));
			}
			if (!StringUtil.isEmpty(applicablefor)) {
				attedancecriteria.setApplicablefor(applicablefor);
			}
			if (!StringUtil.isEmpty(criteriadate)) {
			attedancecriteria.setFromdate(new Date());
			Date converttodate=DateHelper.convertDateAccordingToString(criteriadate);
			attedancecriteria.setTodate(converttodate);
			}
			attendanceaggregation = attendanceservice.searchAttendanceAccordingToType(attedancecriteria);
		} catch (Exception e) {
			new ResponseEntity<List<AttendanceAggregationResult> >(attendanceaggregation, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<AttendanceAggregationResult> >(attendanceaggregation, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/getAttendanceCount/{attedancefor}/{fromdate}/{todate}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AttendanceCount> getAttendanceCount(@PathVariable String attedancefor,@PathVariable String fromdate,@PathVariable String todate) {
		AttendanceCount attendancecount=new AttendanceCount();
		attendancecount.setAbsentcount(130);
		attendancecount.setAttendanceFor(attedancefor);
		attendancecount.setPresentcount(900);
		attendancecount.setTodate(new Date());
		attendancecount.setFromdate(new Date());
		return new ResponseEntity<AttendanceCount>(attendancecount, HttpStatus.OK);
	}

}
