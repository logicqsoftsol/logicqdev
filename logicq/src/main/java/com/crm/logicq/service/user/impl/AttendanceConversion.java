package com.crm.logicq.service.user.impl;

import java.util.ArrayList;
import java.util.List;

import com.crm.logicq.model.attendance.AttendanceDetails;
import com.crm.logicq.security.helper.DateHelper;
import com.crm.logicq.vo.attendance.AttendanceVO;

public class AttendanceConversion { 

	
	public static List<AttendanceVO> convertEntityToVO(List<AttendanceDetails> attendanceDetails) {
		List<AttendanceVO> attendancevo = new ArrayList<AttendanceVO>();
		attendanceDetails.stream().forEach((attendance) -> {
			AttendanceVO attednace = new AttendanceVO();
		//	attednace.setIntime(attendance.getIntime());
			attednace.setOuttime(attendance.getOuttime());
//			attednace.setDate(DateHelper.convertDatetoString(attendance.getKey().getDate()));
		//	attendancevo.add(attednace);
		});
		return attendancevo;
	}

}
