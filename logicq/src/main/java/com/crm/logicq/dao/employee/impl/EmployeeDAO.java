package com.crm.logicq.dao.employee.impl;

import java.util.List;

import org.hsqldb.lib.StringUtil;
import org.springframework.stereotype.Repository;

import com.crm.logicq.common.AbstractDAO;
import com.crm.logicq.dao.employee.IEmployeeDAO;
import com.crm.logicq.model.attendance.AttendanceDetails;
import com.crm.logicq.model.user.ContactDetails;
import com.crm.logicq.model.user.Employee;
import com.crm.logicq.model.user.Student;
import com.crm.logicq.model.user.User;
import com.crm.logicq.vo.user.EmployeeCriteria;

@Repository
public class EmployeeDAO extends AbstractDAO<Employee> implements IEmployeeDAO{

	@Override
	public void saveEmployee(Employee employee) throws Exception {
		if(StringUtil.isEmpty(employee.getUserid())){
		employee.setUserid(employee.getBasicdetails().getFirstname().substring(0, 3)+"-"+employee.getIdetificationid());
		}
		if (null != employee.getBasicdetails()) {
			employee.getBasicdetails().setEmployee(employee);
		}
		ContactDetails contactdetails = employee.getContactdetails();
		if (null != contactdetails) {
			employee.getContactdetails().setEmployee(employee);
		}
		if (null != contactdetails.getAddressdetails()) {
			employee.getContactdetails().getAddressdetails().setContactdetails(contactdetails);
		}
		if (null != contactdetails.getCommunicationdetails()) {
			employee.getContactdetails().getCommunicationdetails().setContactdetails(contactdetails);
		}
		saveOrUpdate(employee);
	
	}

	@Override
	public List<Employee> getEmployeeList(EmployeeCriteria employeecriteria) throws Exception {
		String query = " from Employee emp where emp.basicdetails.id!=null and emp.contactdetails.id!=null";
		if (1 == employeecriteria.getPagenumber()) {
			Long recordcount=getRecordCount(Employee.class);
			employeecriteria.setTotalrecordcount(recordcount.intValue());
		}
		return executeQueryWithPagination(query, employeecriteria.getPagenumber(), employeecriteria.getPagesize());
		
	}

	@Override
	public Employee getEmployee(String empid) throws Exception {
		String query = " from Employee emp where emp.id="+empid;
		// need to change currently for testing purpose bind with userid
		return (Employee) executeQuery(query).get(0);
	}

	@Override
	public void deleteEmployee(Employee emp) throws Exception {
		delete(getEmployee(String.valueOf(emp.getId())));
	}
	
	@Override
	public List<Employee> loadEmployees() {
		return (List<Employee>) loadClass(Employee.class);
	}
	
}
