package com.crm.logicq.service.attendance.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.logicq.common.LogicqContextProvider;
import com.crm.logicq.dao.attendance.IAttendanceDAO;
import com.crm.logicq.model.attendance.AttendanceDetails;
import com.crm.logicq.model.user.CardReadDetails;
import com.crm.logicq.model.user.Employee;
import com.crm.logicq.model.user.Student;

@Service
@Transactional
public class AttendanceService {
	
	@Autowired
	IAttendanceDAO attendanceDAO;
	
	public void saveAttendance(List<CardReadDetails> cardDetails) throws Exception{
		
		for(CardReadDetails cardDetail : cardDetails){
			Integer cardId = cardDetail.getCardid();
			AttendanceDetails attendanceDetails = new AttendanceDetails();
			Object employee = LogicqContextProvider.getElementFromEmployeeMap(String.valueOf(cardId));
			if(employee != null){
				Employee emp = (Employee) employee;
				attendanceDetails.setMobile(emp.getContactdetails().getCommunicationdetails().getMobilenumber());
				attendanceDetails.setFullName(emp.getBasicdetails().getFirstname().concat(emp.getBasicdetails().getLastname()));
				
			} else {
				
				Object student = LogicqContextProvider.getElementFromStudentMap(String.valueOf(cardId));
				Student stu = (Student)student;
				attendanceDetails.setFullName(stu.getBasicdetails().getFirstname().concat(stu.getBasicdetails().getLastname()));
				attendanceDetails.setMobile(stu.getContactdetails().getCommunicationdetails().getMobilenumber());
			}
			attendanceDetails.setDate(cardDetail.getCardswappdate());
			attendanceDetails.setIntime(String.valueOf(cardDetail.getIntime()));
			attendanceDetails.setOuttime(String.valueOf(cardDetail.getOuttime()));
			attendanceDAO.saveAttendanceDetails(attendanceDetails);
		}
	}

}
