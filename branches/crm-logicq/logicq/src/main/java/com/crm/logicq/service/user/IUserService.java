package com.crm.logicq.service.user;

import java.util.List;

import com.crm.logicq.model.attendance.AttendanceCriteria;
import com.crm.logicq.model.user.CardReadDetails;
import com.crm.logicq.model.user.Employee;
import com.crm.logicq.model.user.Student;
import com.crm.logicq.vo.attendance.AttendanceVO;
import com.crm.logicq.vo.user.EmployeeCriteria;
import com.crm.logicq.vo.user.StudentCriteria;

public interface IUserService {
	
	public void loadUsers();

	public void getUser(String cardid) throws Exception;
	
	
	public void saveEmployee(Employee employee) throws Exception;
	
	public void saveStudent(Student student) throws Exception;
	
	public void saveUser(Student student) throws Exception;
	
	public List<Employee> getEmployeeList(EmployeeCriteria employeecriteria) throws Exception;
	public List<Student> getStudentList(StudentCriteria studentcriteria) throws Exception;
	
	public Employee getEmployee(String empid) throws Exception;
	
	public Student getStudent(String studentid) throws Exception;
	public void deleteStudent(Student student) throws Exception;
	public void deleteEmployee(Employee emp) throws Exception;
	public void loadEmployees() throws Exception;
	public void loadStudents() throws Exception;
}
