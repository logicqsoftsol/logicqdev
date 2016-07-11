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
import com.crm.logicq.vo.user.EmployeeVO;

@RestController
@RequestMapping("/user")
public class UserSearchController {
	

	@RequestMapping(value = "/searchAllEmployeeList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmployeeVO>> searchAllEmployee() {
		List<EmployeeVO> employelist = new ArrayList<EmployeeVO>();
		for (int i = 0; i < 10; i++) {
			EmployeeVO employee = new EmployeeVO();
			employee.setId("EMP-LEC-1001" + i);
			employee.setName("Mr. Test test" + i);
			employee.setDate(new Date());
			employee.setType("PROFESSOR" + i);
			employelist.add(employee);
		}
		
		return new ResponseEntity<List<EmployeeVO>>(employelist, HttpStatus.OK);
	}

	@RequestMapping(value = "/saveEmployeeDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmployeeVO>> saveEmployeeDetails(@RequestBody Employee employee) {
		List<EmployeeVO> employelist = new ArrayList<EmployeeVO>();
		
		for (int i = 0; i < 10; i++) {
			EmployeeVO fetchemployee = new EmployeeVO();
			fetchemployee.setId("EMP-LEC-1001" + i);
			fetchemployee.setName("Mr. Test test" + i);
			fetchemployee.setDate(new Date());
			fetchemployee.setType("PROFESSOR" + i);
			employelist.add(fetchemployee);
		}
		
		return new ResponseEntity<List<EmployeeVO>>(employelist, HttpStatus.OK);
	}
	
}
