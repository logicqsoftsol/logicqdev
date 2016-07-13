package com.crm.logicq.dao.employee.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hsqldb.lib.StringUtil;
import org.springframework.stereotype.Repository;

import com.crm.logicq.common.AbstractDAO;
import com.crm.logicq.dao.employee.IEmployeeDAO;
import com.crm.logicq.model.user.Employee;

@Repository
public class EmployeeDAO extends AbstractDAO<Employee> implements IEmployeeDAO{

	@Override
	public void saveEmployee(Employee employee) throws Exception {
		if(StringUtil.isEmpty(employee.getUserid())){
			employee.setUserid(employee.getBasicdetails().getFirstname().substring(0, 3)+"-"+employee.getIdetificationid());
		}
		saveOrUpdate(employee);
	}

	@Override
	public List<Employee> getEmployeeList() throws Exception {
		return (List<Employee>) loadClass(Employee.class);
		
	}

	@Override
	public Employee getEmployee(String empid) throws Exception {
		String query = " from Employee emp where emp.id="+empid;
		// need to change currently for testing purpose bind with userid
		return (Employee) execcuteQuery(query).get(0);
	}

}
