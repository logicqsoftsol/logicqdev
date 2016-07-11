package com.crm.logicq.controller.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crm.logicq.model.user.Employee;
import com.crm.logicq.model.user.Student;
import com.crm.logicq.vo.user.BasicRegistrationVO;

@RestController
@RequestMapping("/user")
public class UserController {
	

	@RequestMapping(value = "/searchAllEmployeeList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BasicRegistrationVO>> searchAllEmployee() {
		List<BasicRegistrationVO> employelist = new ArrayList<BasicRegistrationVO>();
		for (int i = 0; i < 10; i++) {
			BasicRegistrationVO employee = new BasicRegistrationVO();
			employee.setId("EMP-LEC-1001" + i);
			employee.setName("Mr. Test test" + i);
			employee.setDate(new Date());
			employee.setType("PROFESSOR" + i);
			employelist.add(employee);
		}
		
		return new ResponseEntity<List<BasicRegistrationVO>>(employelist, HttpStatus.OK);
	}

	@RequestMapping(value = "/saveEmployeeDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BasicRegistrationVO>> saveEmployeeDetails(@RequestBody Employee employee) {
		List<BasicRegistrationVO> employelist = new ArrayList<BasicRegistrationVO>();
		
		for (int i = 0; i < 10; i++) {
			BasicRegistrationVO fetchemployee = new BasicRegistrationVO();
			fetchemployee.setId("EMP-LEC-1001" + i);
			fetchemployee.setName("Mr. Test test" + i);
			fetchemployee.setDate(new Date());
			fetchemployee.setType("PROFESSOR" + i);
			employelist.add(fetchemployee);
		}
		
		return new ResponseEntity<List<BasicRegistrationVO>>(employelist, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/saveStudentDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BasicRegistrationVO>> saveStudentDetails(@RequestBody Student student) {
		List<BasicRegistrationVO> studentlist = new ArrayList<BasicRegistrationVO>();
		
		for (int i = 0; i < 10; i++) {
			BasicRegistrationVO fetchstudent = new BasicRegistrationVO();
			fetchstudent.setId("STUDENT-1001" + i);
			fetchstudent.setName("Mr. Test test" + i);
			fetchstudent.setDate(new Date());
			fetchstudent.setType("HSC" + i);
			studentlist.add(fetchstudent);
		}
		
		return new ResponseEntity<List<BasicRegistrationVO>>(studentlist, HttpStatus.OK);
	}
	
	

	@RequestMapping(value = "/searchAllStudentList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BasicRegistrationVO>> searchAllStudent() {
		List<BasicRegistrationVO> employelist = new ArrayList<BasicRegistrationVO>();
		for (int i = 0; i < 10; i++) {
			BasicRegistrationVO employee = new BasicRegistrationVO();
			employee.setId("EMP-LEC-1001" + i);
			employee.setName("Mr. Test test" + i);
			employee.setDate(new Date());
			employee.setType("PROFESSOR" + i);
			employelist.add(employee);
		}
		
		return new ResponseEntity<List<BasicRegistrationVO>>(employelist, HttpStatus.OK);
	}
	
}
