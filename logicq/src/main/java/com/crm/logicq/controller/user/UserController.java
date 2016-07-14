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

@RestController
@RequestMapping("/user")
public class UserController {
	
  @Autowired	
  IUserService userservice;
  								
	
	@RequestMapping(value = "/searchAllEmployeeList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BasicRegistrationVO>> searchAllEmployee() {
		
		
		List<BasicRegistrationVO> employelist = new ArrayList<BasicRegistrationVO>();
		List<Employee> employeelist=null;
		try {
			employeelist = userservice.getEmployeeList();
			employeelist.forEach((emp) -> {
				BasicRegistrationVO bsaicregvo = new BasicRegistrationVO();
				bsaicregvo.setDate(emp.getRegdate());
				bsaicregvo.setId(emp.getId());
				bsaicregvo.setUserid(emp.getUserid());
				bsaicregvo
						.setName(emp.getBasicdetails().getFirstname() + " " + emp.getBasicdetails().getLastname());
				bsaicregvo.setType(EntityType.EMPLOYEE.toString());
				employelist.add(bsaicregvo);
			});

		} catch (Exception e) {
			return new ResponseEntity<List<BasicRegistrationVO>>(employelist, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
		return new ResponseEntity<List<BasicRegistrationVO>>(employelist, HttpStatus.OK);
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
	public ResponseEntity<List<BasicRegistrationVO>> saveEmployeeDetails(@RequestBody Employee employee) {
		List<BasicRegistrationVO> employelist = new ArrayList<BasicRegistrationVO>();
		try {
			if (null == employee) {
				return new ResponseEntity<List<BasicRegistrationVO>>(employelist, HttpStatus.BAD_REQUEST);
			} else {
				if (null == employee.getRegdate()) {
					employee.setRegdate(new Date());
				}
				userservice.saveEmployee(employee);
				List<Employee> employeelist = userservice.getEmployeeList();
				employeelist.forEach((emp) -> {
					BasicRegistrationVO bsaicregvo = new BasicRegistrationVO();
					bsaicregvo.setDate(emp.getRegdate());
					bsaicregvo.setId(emp.getId());
					bsaicregvo.setUserid(emp.getUserid());
					bsaicregvo
							.setName(emp.getBasicdetails().getFirstname() + " " + emp.getBasicdetails().getLastname());
					bsaicregvo.setType(EntityType.EMPLOYEE.toString());
					employelist.add(bsaicregvo);
				});

			
			}
		} catch (Exception ex) {
			return new ResponseEntity<List<BasicRegistrationVO>>(employelist, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<List<BasicRegistrationVO>>(employelist, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/saveStudentDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BasicRegistrationVO>> saveStudentDetails(@RequestBody Student student) {
		List<BasicRegistrationVO> studentlistvo = new ArrayList<BasicRegistrationVO>();
		try {
			if (null == student) {
				return new ResponseEntity<List<BasicRegistrationVO>>(studentlistvo, HttpStatus.BAD_REQUEST);
			} else {
				if (null == student.getRegdate()) {
					student.setRegdate(new Date());
				}
				userservice.saveStudent(student);
				List<Student> studentlist=userservice.getStudentList();
				studentlist.forEach((stu) -> {
					BasicRegistrationVO bsaicregvo = new BasicRegistrationVO();
					bsaicregvo.setDate(stu.getRegdate());
					bsaicregvo.setId(stu.getId());
					bsaicregvo.setUserid(stu.getUserid());
					bsaicregvo
							.setName(stu.getBasicdetails().getFirstname() + " " + stu.getBasicdetails().getLastname());
					bsaicregvo.setType(EntityType.STUDENT.toString());
					studentlistvo.add(bsaicregvo);
				});
				
			}
		} catch (Exception ex) {
			return new ResponseEntity<List<BasicRegistrationVO>>(studentlistvo, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		return new ResponseEntity<List<BasicRegistrationVO>>(studentlistvo, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/deleteStudentDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BasicRegistrationVO>> deleteStudentDetails(@RequestBody Student student) {
		List<BasicRegistrationVO> studentlistvo = new ArrayList<BasicRegistrationVO>();
		try {
			if (null == student) {
				return new ResponseEntity<List<BasicRegistrationVO>>(studentlistvo, HttpStatus.BAD_REQUEST);
			} else {
				userservice.deleteStudent(student);
				List<Student> studentlist=userservice.getStudentList();
				studentlist.forEach((stu) -> {
					BasicRegistrationVO bsaicregvo = new BasicRegistrationVO();
					bsaicregvo.setDate(stu.getRegdate());
					bsaicregvo.setId(stu.getId());
					bsaicregvo.setUserid(stu.getUserid());
					bsaicregvo
							.setName(stu.getBasicdetails().getFirstname() + " " + stu.getBasicdetails().getLastname());
					bsaicregvo.setType(EntityType.STUDENT.toString());
					studentlistvo.add(bsaicregvo);
				});
				
			}
		} catch (Exception ex) {
			return new ResponseEntity<List<BasicRegistrationVO>>(studentlistvo, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		return new ResponseEntity<List<BasicRegistrationVO>>(studentlistvo, HttpStatus.OK);
	}
	
	
	

	@RequestMapping(value = "/searchAllStudentList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BasicRegistrationVO>> searchAllStudent() {
		List<BasicRegistrationVO> studentlistvo = new ArrayList<BasicRegistrationVO>();
		List<Student> studentlist=null;
		try {
			studentlist = userservice.getStudentList();
			studentlist.forEach((stu) -> {
				BasicRegistrationVO bsaicregvo = new BasicRegistrationVO();
				bsaicregvo.setDate(stu.getRegdate());
				bsaicregvo.setId(stu.getId());
				bsaicregvo.setUserid(stu.getUserid());
				bsaicregvo
						.setName(stu.getBasicdetails().getFirstname() + " " + stu.getBasicdetails().getLastname());
				bsaicregvo.setType(EntityType.STUDENT.toString());
				studentlistvo.add(bsaicregvo);
			});
			
		} catch (Exception ex) {
			return new ResponseEntity<List<BasicRegistrationVO>>(studentlistvo, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		return new ResponseEntity<List<BasicRegistrationVO>>(studentlistvo, HttpStatus.OK);
	}
	
}
