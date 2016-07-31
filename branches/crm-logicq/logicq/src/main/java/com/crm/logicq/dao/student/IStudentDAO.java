package com.crm.logicq.dao.student;

import java.util.List;

import com.crm.logicq.model.user.Employee;
import com.crm.logicq.model.user.Student;
import com.crm.logicq.vo.user.StudentCriteria;

public interface IStudentDAO {

	public void saveStudent(Student student)throws Exception;
	
	public List<Student> getStudentList(StudentCriteria studentcriteria);
	
	public Student getStudentDetails(String studentid);
	
	public void deleteStudent(Student student) throws Exception;
	
	public List<Student> loadStudents() throws Exception;
}
