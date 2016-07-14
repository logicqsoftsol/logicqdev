package com.crm.logicq.dao.student.impl;

import java.util.List;

import org.hsqldb.lib.StringUtil;
import org.springframework.stereotype.Repository;

import com.crm.logicq.common.AbstractDAO;
import com.crm.logicq.dao.student.IStudentDAO;
import com.crm.logicq.model.user.Student;

@Repository
public class StudentDAO extends AbstractDAO<Student> implements IStudentDAO{

	@Override
	public void saveStudent(Student student) throws Exception{
		if(StringUtil.isEmpty(student.getUserid())){
			student.setUserid(student.getBasicdetails().getFirstname().substring(0, 3)+"-"+student.getIdetificationid());
		}
		saveOrUpdate(student);
		
	}

	@Override
	public List<Student> getStudentList() {
		return (List<Student>) loadClass(Student.class);
	}

	@Override
	public Student getStudentDetails(String studentid) {
		String query = " from Student stu where stu.id="+studentid;
		// need to change currently for testing purpose bind with userid
		return (Student) execcuteQuery(query).get(0);
	}

	@Override
	public void deleteStudent(Student student) throws Exception {
		delete(student);
	}

}
