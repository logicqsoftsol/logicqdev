package com.crm.logicq.controller.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crm.logicq.constant.EntityType;
import com.crm.logicq.model.user.Employee;
import com.crm.logicq.model.user.Student;
import com.crm.logicq.service.user.IUserService;
import com.crm.logicq.vo.user.BasicRegistrationVO;
import com.crm.logicq.vo.user.EmployeeCriteria;
import com.crm.logicq.vo.user.EmployeeVO;
import com.crm.logicq.vo.user.StudentCriteria;
import com.crm.logicq.vo.user.StudentVO;

@RestController
@RequestMapping("/user")
public class UserController {
	
  @Autowired	
  IUserService userservice;
  								
	
	@RequestMapping(value = "/searchAllEmployeeList/{pagesize}/{pageno}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeVO> searchAllEmployee(@PathVariable int pagesize,@PathVariable int pageno) {
		EmployeeVO employeevo=new EmployeeVO();
		EmployeeCriteria employeecriteria=new EmployeeCriteria();
		employeecriteria.setPagenumber(pageno);
		employeecriteria.setPagesize(pagesize);
		List<BasicRegistrationVO> basicemployeelist = new ArrayList<BasicRegistrationVO>();
		List<Employee> employeelist=null;
		try {
			employeelist = userservice.getEmployeeList(employeecriteria);
			employeelist.forEach((emp) -> {
				BasicRegistrationVO bsaicregvo = new BasicRegistrationVO();
				bsaicregvo.setDate(emp.getRegdate());
				bsaicregvo.setId(emp.getId());
				bsaicregvo.setUserid(emp.getUserid());
				bsaicregvo
						.setName(emp.getBasicdetails().getFirstname() + " " + emp.getBasicdetails().getLastname());
				bsaicregvo.setType(EntityType.EMPLOYEE.toString());
				basicemployeelist.add(bsaicregvo);
			});
			employeevo.setEmployeelist(basicemployeelist);
			employeevo.setEmployeecriteria(employeecriteria);
		} catch (Exception e) {
			return new ResponseEntity<EmployeeVO>(employeevo, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
		return new ResponseEntity<EmployeeVO>(employeevo, HttpStatus.OK);
	}

	
	
	@RequestMapping(value = "/searchEmployeeDetails/{empid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> searchEmployeeDetails(@PathVariable String empid) {
		
		Employee employee=null;
		
		try {
			employee=userservice.getEmployee(empid);

		} catch (Exception e) {
			return new ResponseEntity<Employee>(employee, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	
	
	@RequestMapping(value = "/searchStudentDetails/{studentid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> searchStudentDetails(@PathVariable String studentid) {
		
		Student student=null;
		try {
			student=userservice.getStudent(studentid);
		} catch (Exception e) {
			return new ResponseEntity<Student>(student, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/saveEmployeeDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeVO> saveEmployeeDetails(@RequestBody Employee employee) {
		
		EmployeeVO employeevo=new EmployeeVO();
		EmployeeCriteria employeecriteria=new EmployeeCriteria();
		employeecriteria.setPagenumber(1);
		employeecriteria.setPagesize(15);
		try {
			if (null == employee) {
				return new ResponseEntity<EmployeeVO>(employeevo, HttpStatus.BAD_REQUEST);
			} else {
				List<BasicRegistrationVO> basicemployeelist = new ArrayList<BasicRegistrationVO>();
				if (null == employee.getRegdate()) {
					employee.setRegdate(new Date());
				}
				userservice.saveEmployee(employee);
				List<Employee> employeelist = userservice.getEmployeeList(employeecriteria);
				employeelist.forEach((emp) -> {
					BasicRegistrationVO bsaicregvo = new BasicRegistrationVO();
					bsaicregvo.setDate(emp.getRegdate());
					bsaicregvo.setId(emp.getId());
					bsaicregvo.setUserid(emp.getUserid());
					bsaicregvo
							.setName(emp.getBasicdetails().getFirstname() + " " + emp.getBasicdetails().getLastname());
					bsaicregvo.setType(EntityType.EMPLOYEE.toString());
					basicemployeelist.add(bsaicregvo);
				});
				employeevo.setEmployeelist(basicemployeelist);
				employeevo.setEmployeecriteria(employeecriteria);
			
			}
		} catch (Exception ex) {
			return new ResponseEntity<EmployeeVO>(employeevo, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<EmployeeVO>(employeevo, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/deleteEmployeeDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeVO> deleteEmployeeDetails(@RequestBody Employee employee) {
		
		EmployeeVO employeevo=new EmployeeVO();
		EmployeeCriteria employeecriteria=new EmployeeCriteria();
		employeecriteria.setPagenumber(1);
		employeecriteria.setPagesize(15);
		
		List<BasicRegistrationVO> basicemployeelist = new ArrayList<BasicRegistrationVO>();
		try {
			if (null == employee) {
				return new ResponseEntity<EmployeeVO>(employeevo, HttpStatus.BAD_REQUEST);
			} else {
				userservice.deleteEmployee(employee);
				List<Employee> employeelist = userservice.getEmployeeList(employeecriteria);
				employeelist.forEach((emp) -> {
					BasicRegistrationVO bsaicregvo = new BasicRegistrationVO();
					bsaicregvo.setDate(emp.getRegdate());
					bsaicregvo.setId(emp.getId());
					bsaicregvo.setUserid(emp.getUserid());
					bsaicregvo
							.setName(emp.getBasicdetails().getFirstname() + " " + emp.getBasicdetails().getLastname());
					bsaicregvo.setType(EntityType.EMPLOYEE.toString());
					basicemployeelist.add(bsaicregvo);
				});
				employeevo.setEmployeelist(basicemployeelist);
				employeevo.setEmployeecriteria(employeecriteria);
			}
		} catch (Exception ex) {
			return new ResponseEntity<EmployeeVO>(employeevo, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		return new ResponseEntity<EmployeeVO>(employeevo, HttpStatus.OK);
	} 
	

	@RequestMapping(value = "/searchAllStudentList/{pagesize}/{pageno}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentVO> searchAllStudent(@PathVariable int pagesize,@PathVariable int pageno	) {
		StudentVO studentvo=new StudentVO();
		StudentCriteria studentcriteria=new StudentCriteria();
		studentcriteria.setPagenumber(pageno);
		studentcriteria.setPagesize(pagesize);
		List<BasicRegistrationVO> basicstudentlist = new ArrayList<BasicRegistrationVO>();
		List<Student> studentlist=null;
		try {
			studentlist = userservice.getStudentList(studentcriteria);
			studentlist.forEach((stu) -> {
				BasicRegistrationVO bsaicregvo = new BasicRegistrationVO();
				bsaicregvo.setDate(stu.getRegdate());
				bsaicregvo.setId(stu.getId());
				bsaicregvo.setUserid(stu.getUserid());
				bsaicregvo
						.setName(stu.getBasicdetails().getFirstname() + " " + stu.getBasicdetails().getLastname());
				bsaicregvo.setType(EntityType.STUDENT.toString());
				basicstudentlist.add(bsaicregvo);
			});
			studentvo.setStudentlist(basicstudentlist);
			studentvo.setStudentcriteria(studentcriteria);
		} catch (Exception ex) {
			return new ResponseEntity<StudentVO>(studentvo, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<StudentVO>(studentvo, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value = "/saveStudentDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentVO> saveStudentDetails(@RequestBody Student student) {
		StudentVO studentvo=new StudentVO();
		try {
			if (null == student) {
				return new ResponseEntity<StudentVO>(studentvo, HttpStatus.BAD_REQUEST);
			} else {
				StudentCriteria studentcriteria=new StudentCriteria();
				studentcriteria.setPagenumber(1);
				studentcriteria.setPagesize(15);
				List<BasicRegistrationVO> basicstudentlist = new ArrayList<BasicRegistrationVO>();
				if (null == student.getRegdate()) {
					student.setRegdate(new Date());
				}
				userservice.saveStudent(student);
				List<Student> studentlist=userservice.getStudentList(studentcriteria);
				studentlist.forEach((stu) -> {
					BasicRegistrationVO bsaicregvo = new BasicRegistrationVO();
					bsaicregvo.setDate(stu.getRegdate());
					bsaicregvo.setId(stu.getId());
					bsaicregvo.setUserid(stu.getUserid());
					bsaicregvo
							.setName(stu.getBasicdetails().getFirstname() + " " + stu.getBasicdetails().getLastname());
					bsaicregvo.setType(EntityType.STUDENT.toString());
					basicstudentlist.add(bsaicregvo);
				});
				studentvo.setStudentlist(basicstudentlist);
				studentvo.setStudentcriteria(studentcriteria);
			}
		} catch (Exception ex) {
			return new ResponseEntity<StudentVO>(studentvo, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		return new ResponseEntity<StudentVO>(studentvo, HttpStatus.OK);
	}
	
	

	
	
	@RequestMapping(value = "/deleteStudentDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentVO> deleteStudentDetails(@RequestBody Student student) {
		StudentVO studentvo=new StudentVO();
		try {
			if (null == student) {
				return new ResponseEntity<StudentVO>(studentvo, HttpStatus.BAD_REQUEST);
			} else {
				StudentCriteria studentcriteria=new StudentCriteria();
				studentcriteria.setPagenumber(1);
				studentcriteria.setPagesize(15);
				List<BasicRegistrationVO> basicstudentlist = new ArrayList<BasicRegistrationVO>();
				userservice.deleteStudent(student);
				List<Student> studentlist=userservice.getStudentList(studentcriteria);
				studentlist.forEach((stu) -> {
					BasicRegistrationVO bsaicregvo = new BasicRegistrationVO();
					bsaicregvo.setDate(stu.getRegdate());
					bsaicregvo.setId(stu.getId());
					bsaicregvo.setUserid(stu.getUserid());
					bsaicregvo
							.setName(stu.getBasicdetails().getFirstname() + " " + stu.getBasicdetails().getLastname());
					bsaicregvo.setType(EntityType.STUDENT.toString());
					basicstudentlist.add(bsaicregvo);
				});
				
			}
		} catch (Exception ex) {
			return new ResponseEntity<StudentVO>(studentvo, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<StudentVO>(studentvo, HttpStatus.OK);
	}
	
	
	

}
