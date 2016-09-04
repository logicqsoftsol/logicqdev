package com.crm.logicq.service.user.impl;

import java.util.ArrayList;
import java.util.List;

import com.crm.logicq.model.attendance.AttendanceDetails;
import com.crm.logicq.security.helper.DateHelper;
import com.crm.logicq.vo.attendance.AttendanceVO;

public class AttendanceConversion { 

	
	public static List<AttendanceVO> convertEntityToVO(List<AttendanceDetails> attendanceDetails) {
		List<AttendanceVO> attendancevo = new ArrayList<AttendanceVO>();
		//attendanceDetails.stream().forEach((attendance) -> {
		for(AttendanceDetails attendanceentity:attendanceDetails){
			AttendanceVO attednace = new AttendanceVO();
			attednace.setIntime(attendanceentity.getIntime());
			attednace.setOuttime(attendanceentity.getOuttime());
			attednace.setMobileno(attendanceentity.getMobile());
			attednace.setName(attendanceentity.getFullName());
			attednace.setAttendance(attendanceentity.getIsPresent());
			if(null!=attendanceentity.getKey()){
			attednace.setId(attendanceentity.getKey().getIdetificationid());
			}
			if(null!=attendanceentity.getKey()){
			attednace.setDate(DateHelper.convertDatetoString(attendanceentity.getKey().getDate()));
			}
			attendancevo.add(attednace);
		//});
		}
		return attendancevo;
	}

}
