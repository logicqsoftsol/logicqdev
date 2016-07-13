package com.crm.logicq.dao.student;

import java.util.List;

import com.crm.logicq.model.user.Student;

public interface IStudentDAO {

	public void saveStudent(Student student);
	
	public List<Student> getStudentList();
	
	public Student getStudentDetails(String studentid);
}
