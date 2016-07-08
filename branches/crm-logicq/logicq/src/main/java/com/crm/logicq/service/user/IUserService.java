package com.crm.logicq.service.user;

import java.util.List;

import com.crm.logicq.model.attendance.AttendanceCriteria;
import com.crm.logicq.model.user.CardReadDetails;
import com.crm.logicq.vo.attendance.AttendanceVO;

public interface IUserService {
	
	public void loadUsers();

	public void getUserForSMS(List<CardReadDetails> cardreadDeatils)throws Exception;
	public void triggerSMS(List<CardReadDetails> cardreadDeatils) throws Exception;
	
	public void getUser(String cardid) throws Exception;
	
	public List<AttendanceVO> getAttendanceDetails(AttendanceCriteria attendancecriteria) throws Exception;
}
