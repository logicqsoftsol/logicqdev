package com.crm.logicq.dao.employee;

import java.util.List;

import com.crm.logicq.model.user.Employee;
import com.crm.logicq.vo.user.EmployeeCriteria;

public interface IEmployeeDAO {

	
public void saveEmployee(Employee employee)throws Exception;

public List<Employee> getEmployeeList(EmployeeCriteria employeecriteria) throws Exception;

public Employee getEmployee(String empid) throws Exception;

public void deleteEmployee(Employee employee)throws Exception;

public List<Employee> loadEmployees() throws Exception;
}
