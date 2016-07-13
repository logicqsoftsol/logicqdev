package com.crm.logicq.service.user;

import java.util.List;

import com.crm.logicq.model.attendance.AttendanceCriteria;
import com.crm.logicq.model.user.CardReadDetails;
import com.crm.logicq.model.user.Employee;
import com.crm.logicq.model.user.Student;
import com.crm.logicq.vo.attendance.AttendanceVO;

public interface IUserService {
	
	public void loadUsers();

	public void getUserForSMS(List<CardReadDetails> cardreadDeatils)throws Exception;
	public void triggerSMS(List<CardReadDetails> cardreadDeatils) throws Exception;
	
	public void getUser(String cardid) throws Exception;
	
	public List<AttendanceVO> getAttendanceDetails(AttendanceCriteria attendancecriteria) throws Exception;
	

	public void saveEmployee(Employee employee) throws Exception;
	
	public void saveStudent(Student student) throws Exception;
	
	public void saveUser(Student student) throws Exception;
	
	public List<Employee> getEmployeeList() throws Exception;
	public List<Student> getStudentList() throws Exception;
	
	public Employee getEmployee(String empid) throws Exception;
	
	public Student getStudent(String student) throws Exception;
	
}
