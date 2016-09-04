package com.crm.logicq.dao.student.impl;

import java.util.List;

import org.hsqldb.lib.StringUtil;
import org.springframework.stereotype.Repository;

import com.crm.logicq.common.AbstractDAO;
import com.crm.logicq.dao.student.IStudentDAO;
import com.crm.logicq.model.user.ContactDetails;
import com.crm.logicq.model.user.Employee;
import com.crm.logicq.model.user.Student;
import com.crm.logicq.vo.user.StudentCriteria;

@Repository
public class StudentDAO extends AbstractDAO<Student> implements IStudentDAO{

	@Override
	public void saveStudent(Student student) throws Exception{
		if(StringUtil.isEmpty(student.getUserid())){
			student.setUserid(student.getBasicdetails().getFirstname().substring(0, 3)+"-"+student.getIdetificationid());
		}
		if (null != student.getBasicdetails()) {
			student.getBasicdetails().setStudent(student);
		}
		ContactDetails contactdetails = student.getContactdetails();
		if (null != contactdetails) {
			student.getContactdetails().setStudent(student);
		}
		if (null != contactdetails.getAddressdetails()) {
			contactdetails.getAddressdetails().setContactdetails(contactdetails);
		}
		if (null != contactdetails.getCommunicationdetails()) {
			contactdetails.getCommunicationdetails().setContactdetails(contactdetails);
		}
		if (null != student.getEducationdetails()) {
			student.setEducationdetails(student.getEducationdetails());
			student.getEducationdetails().setStudent(student);
		}
		saveOrUpdate(student);
	}

	@Override
	public List<Student> getStudentList(StudentCriteria studentcriteria) {
		String query = " from Student std where std.basicdetails.id!=null and std.contactdetails.id!=null";
		if (1 == studentcriteria.getPagenumber()) {
			Long recordcount=getRecordCount(Student.class);
			studentcriteria.setTotalrecordcount(recordcount.intValue());
		}
		return executeQueryWithPagination(query, studentcriteria.getPagenumber(), studentcriteria.getPagesize());
	}

	@Override
	public Student getStudentDetails(String studentid) {
		String query = " from Student stu where stu.id="+studentid;
		// need to change currently for testing purpose bind with userid
		return (Student) executeQuery(query).get(0);
	}

	@Override
	public void deleteStudent(Student student) throws Exception {
		delete(getStudentDetails(String.valueOf(student.getId())));
	}
	
	@Override
	public List<Student> loadStudents() {
		return (List<Student>) loadClass(Student.class);
	}

}
