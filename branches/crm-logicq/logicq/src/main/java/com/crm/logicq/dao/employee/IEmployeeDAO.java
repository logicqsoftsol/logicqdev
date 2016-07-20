package com.crm.logicq.dao.employee;

import java.util.List;

import com.crm.logicq.model.user.Employee;

public interface IEmployeeDAO {

	
public void saveEmployee(Employee employee)throws Exception;

public List<Employee> getEmployeeList() throws Exception;

public Employee getEmployee(String empid) throws Exception;

public void deleteEmployee(Employee employee)throws Exception;

public List<Employee> loadEmployees() throws Exception;
}
