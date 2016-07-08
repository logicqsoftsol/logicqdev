package com.crm.logicq.controller.admin.attendance;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crm.logicq.model.attendance.AttendanceCriteria;
import com.crm.logicq.security.helper.DateHelper;
import com.crm.logicq.service.user.IUserService;
import com.crm.logicq.vo.attendance.AttendanceCount;
import com.crm.logicq.vo.attendance.AttendanceVO;


@RestController
@RequestMapping("/admin/attendance")
public class AttendanceController {

  @Autowired
  IUserService userservice;
  

	@RequestMapping(value = "/searchCurrentAttendance", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AttendanceVO>> viewCurrentAttendanceReport() {
		List<AttendanceVO> attendancedetails = new ArrayList<AttendanceVO>();
		try {
		AttendanceCriteria attedancecriteria=new AttendanceCriteria();  
		attedancecriteria.setFromdate(new Date());
		attedancecriteria.setTodate(new Date());
		attendancedetails=userservice.getAttendanceDetails(attedancecriteria);
		} catch (Exception e) {
			return new ResponseEntity<List<AttendanceVO>>(attendancedetails, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<AttendanceVO>>(attendancedetails, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/searchAttendance/{id}/{mobileno}/{cardno}/{fromdate}/{todate}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AttendanceVO>> viewAttendanceReport(@PathVariable String id,@PathVariable String mobileno,@PathVariable String cardno,@PathVariable String fromdate,@PathVariable String todate) {
		List<AttendanceVO> attendancedetails = new ArrayList<AttendanceVO>();
		try {
		AttendanceCriteria attedancecriteria=new AttendanceCriteria();
		attedancecriteria.setCardno(cardno);
		attedancecriteria.setMobileno(mobileno);
		attedancecriteria.setUserid(id);
	    attedancecriteria.setTodate(DateHelper.convertStringtoDate(todate));
	    attedancecriteria.setFromdate(DateHelper.convertStringtoDate(fromdate));
		for(int i=0;i<50;i++){
			AttendanceVO attendance=new AttendanceVO();
			attendance.setId("SCL-1"+i);
			attendance.setName("Dummy"+i);
			attendance.setIntime("10.10 AM");
			attendance.setOuttime("4.30 PM");
			attendance.setMobileno("730393436"+i);
			attendance.setDate("10-JULY-2016");
			attendancedetails.add(attendance);
		}
	} catch (ParseException e) {
		new ResponseEntity<List<AttendanceVO>>(attendancedetails, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<AttendanceVO>>(attendancedetails, HttpStatus.OK);
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
