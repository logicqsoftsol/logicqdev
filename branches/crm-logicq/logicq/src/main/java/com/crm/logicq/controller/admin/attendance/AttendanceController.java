package com.crm.logicq.controller.admin.attendance;

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
import com.crm.logicq.model.attendance.AttendanceDetails;
import com.crm.logicq.model.common.CommonProperty;
import com.crm.logicq.security.helper.DateHelper;
import com.crm.logicq.service.attendance.IAttendanceService;
import com.crm.logicq.vo.attendance.AttendanceDetailsVO;
import com.crm.logicq.vo.attendance.AttendanceVO;


@RestController
@RequestMapping("api/admin/attendance")
public class AttendanceController {

  @Autowired
  IAttendanceService attendanceservice;
  


	@RequestMapping(value = "/getAttendanceAsGraph/{criteriadate}/{applicablefor}/{mobileno}/{cardno}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AttendanceAggregationResult>> getAttendanceAsGraph(@PathVariable String criteriadate,
			@PathVariable String applicablefor, @PathVariable String mobileno, @PathVariable String cardno) {
		List<AttendanceAggregationResult> attendanceaggregation = null;
		try {
			AttendanceCriteria attedancecriteria = new AttendanceCriteria();
			if (!StringUtil.isEmpty(cardno) && !"ISEMPTY".equals(cardno)) {
				attedancecriteria.setCardno(cardno);
			}
			if (!StringUtil.isEmpty(mobileno) && !"ISEMPTY".equals(mobileno)) {
				attedancecriteria.setMobileno(mobileno);
			}
			if (!StringUtil.isEmpty(applicablefor)) {
				attedancecriteria.setApplicablefor(applicablefor);
			}
			if (!StringUtil.isEmpty(criteriadate)) {
				Date converttodate = DateHelper.convertDateAccordingToString(criteriadate);
				attedancecriteria.setFromdate(converttodate);
				attedancecriteria.setTodate(new Date());
			}
		
			
			attendanceaggregation = attendanceservice.getAttendanceCountAccordingToType(attedancecriteria);
		} catch (Exception e) {
			new ResponseEntity<List<AttendanceAggregationResult>>(attendanceaggregation, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<AttendanceAggregationResult>>(attendanceaggregation, HttpStatus.OK);
	}

	@RequestMapping(value = "/getAttendanceAsTabular/{criteriadate}/{applicablefor}/{mobileno}/{cardno}/{pagesize}/{pagenumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AttendanceDetailsVO> getAttendanceAsTabular(@PathVariable String criteriadate,
			@PathVariable String applicablefor, @PathVariable String mobileno, @PathVariable String cardno,
			@PathVariable int pagesize, @PathVariable int pagenumber) {
		AttendanceDetailsVO attedancevo=new AttendanceDetailsVO();
		List<AttendanceDetails> attendancedetails = null;
		try {
			AttendanceCriteria attedancecriteria = new AttendanceCriteria();
			
			attedancecriteria.setPagenumber(pagenumber);
			attedancecriteria.setPagesize(pagesize);
			if (!StringUtil.isEmpty(cardno) && !"#".equals(cardno)) {
				attedancecriteria.setCardno(cardno);
			}
			if (!StringUtil.isEmpty(mobileno) && !"#".equals(mobileno)) {
				attedancecriteria.setMobileno(mobileno);
			}
			if (!StringUtil.isEmpty(applicablefor)) {
				attedancecriteria.setApplicablefor(applicablefor);
			}
			if (!StringUtil.isEmpty(criteriadate)) {
				attedancecriteria.setFromdate(new Date());
				Date converttodate = DateHelper.convertDateAccordingToString(criteriadate);
				attedancecriteria.setTodate(converttodate);
			}
			attendancedetails = attendanceservice.getAttendanceAsTabular(attedancecriteria);
			attedancevo.setAttendacedetails(attendancedetails);
			attedancevo.setAttendanceCriteria(attedancecriteria);
		} catch (Exception e) {
			new ResponseEntity<AttendanceDetailsVO>(attedancevo, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<AttendanceDetailsVO>(attedancevo, HttpStatus.OK);
	}

}
