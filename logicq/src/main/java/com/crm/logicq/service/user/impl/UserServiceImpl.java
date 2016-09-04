package com.crm.logicq.service.user.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.crm.logicq.common.LogicqContextProvider;
import com.crm.logicq.constant.EntityType;
import com.crm.logicq.dao.employee.IEmployeeDAO;
import com.crm.logicq.dao.student.IStudentDAO;
import com.crm.logicq.dao.user.IUserDAO;
import com.crm.logicq.model.education.EducationDetails;
import com.crm.logicq.model.user.Employee;
import com.crm.logicq.model.user.Student;
import com.crm.logicq.model.user.User;
import com.crm.logicq.service.alert.IAlertService;
import com.crm.logicq.service.user.IUserService;
import com.crm.logicq.vo.attendance.EducationVO;
import com.crm.logicq.vo.user.EmployeeCriteria;
import com.crm.logicq.vo.user.StudentCriteria;
import com.crm.logicq.vo.user.UserVO;

@Service
@Transactional
public class UserServiceImpl implements IUserService{

	@Autowired
	IUserDAO userdao;
	@Autowired
	IAlertService alertService;
	@Autowired
	IEmployeeDAO employeedao;
	@Autowired
	IStudentDAO studentdao;
	
	
	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public void loadUsers() {
		List<User> userdetails= userdao.loadUsers();
		for(User user:userdetails){
	//	userdetails.stream().forEach((user) -> {
			LogicqContextProvider.addElementToApplicationMap(user.getIdetificationid(), user);
		//});
		}
	}


	@Override
	public void getUser(String cardid) throws Exception {
		
		
	}

	

	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void saveEmployee(Employee employee) throws Exception {
		employeedao.saveEmployee(employee);
	}

	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void saveStudent(Student student) throws Exception {
		studentdao.saveStudent(student);
		
	}

	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void saveUser(Student student) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<Employee> getEmployeeList(EmployeeCriteria employeecriteria) throws Exception {
		return employeedao.getEmployeeList(employeecriteria);
		
	}

	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<Student>  getStudentList(StudentCriteria studentcriteria) throws Exception {
		return studentdao.getStudentList(studentcriteria);
	}

	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public Employee getEmployee(String empid) throws Exception {
		return employeedao.getEmployee(empid);
	}

	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public Student getStudent(String studentid) throws Exception {
		return studentdao.getStudentDetails(studentid);
	}

	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void deleteStudent(Student student) throws Exception {
		studentdao.deleteStudent(student);
	}

	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void deleteEmployee(Employee emp) throws Exception {
		employeedao.deleteEmployee(emp);
	}

	
	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public void loadEmployees() throws Exception{
		List<Employee> employeeDetails= employeedao.loadEmployees();
		Map<String,UserVO> allusermapdetails = (Map<String, UserVO>) LogicqContextProvider.getElementFromApplicationMap("CACHEDUSER");
		if(null==allusermapdetails || allusermapdetails.isEmpty()){
			allusermapdetails=new HashMap<String, UserVO>();
			LogicqContextProvider.addElementToApplicationMap("CACHEDUSER", allusermapdetails);
		}
		for(Employee employee:employeeDetails){
	//	employeeDetails.forEach((employee)->{
			Map<String,UserVO> allusermap=(Map<String, UserVO>) LogicqContextProvider.getElementFromApplicationMap("CACHEDUSER");
			UserVO uservo=new UserVO();
			if (null != employee.getContactdetails()
					&& null != employee.getContactdetails().getCommunicationdetails()) {
				uservo.setEmail(employee.getContactdetails().getCommunicationdetails().getEmailid());
				uservo.setMobilenumber(employee.getContactdetails().getCommunicationdetails().getMobilenumber());
			}
			if(null!=employee.getBasicdetails()){
			uservo.setName(employee.getBasicdetails().getFirstname()+" "+employee.getBasicdetails().getLastname());
			uservo.setFirstName(employee.getBasicdetails().getFirstname());
			uservo.setLastName(employee.getBasicdetails().getLastname());
			}
			uservo.setEntityType(EntityType.EMPLOYEE);
			uservo.setIdetificationid(employee.getIdetificationid());
			uservo.setUserid(employee.getUserid());
			allusermap.put(employee.getIdetificationid(), uservo);
		//});
		}
	}
	
	
	
	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public void loadStudents() throws Exception{
		List<Student> students= studentdao.loadStudents();
		Map<String,UserVO> allusermapdetails = (Map<String, UserVO>) LogicqContextProvider.getElementFromApplicationMap("CACHEDUSER");
		Map<String,EducationVO>  studenteducationdetails = (Map<String, EducationVO>) LogicqContextProvider.getElementFromApplicationMap("CACHEDSTUDENTEDU");
		if(null==allusermapdetails || allusermapdetails.isEmpty()){
			allusermapdetails=new HashMap<String, UserVO>();
			LogicqContextProvider.addElementToApplicationMap("CACHEDUSER", allusermapdetails);
		if(null==studenteducationdetails || studenteducationdetails.isEmpty()){
				studenteducationdetails=new HashMap<String, EducationVO>();
				LogicqContextProvider.addElementToApplicationMap("CACHEDSTUDENTEDU", studenteducationdetails);
		}
			
			for(Student student:students){
				
				//set education details for student only and it will cache student education details
				EducationDetails educationdetails = student.getEducationdetails();
				if (null != educationdetails) {
					EducationVO edu = new EducationVO();
					edu.setClassname(educationdetails.getClassname());
					edu.setSectionname(educationdetails.getSectionname());
					studenteducationdetails.put(student.getIdetificationid(), edu);
				}
				
				
				//set student as use details
				UserVO uservo=new UserVO();
				if (null != student.getContactdetails()
						&& null != student.getContactdetails().getCommunicationdetails()) {
					uservo.setEmail(student.getContactdetails().getCommunicationdetails().getEmailid());
					uservo.setMobilenumber(student.getContactdetails().getCommunicationdetails().getMobilenumber());
				}
				if(null!=student.getBasicdetails()){
					uservo.setName(student.getBasicdetails().getFirstname()+" "+student.getBasicdetails().getLastname());
					uservo.setFirstName(student.getBasicdetails().getFirstname());
					uservo.setLastName(student.getBasicdetails().getLastname());
					}
				uservo.setEntityType(EntityType.STUDENT);
				uservo.setIdetificationid(student.getIdetificationid());
				uservo.setUserid(student.getUserid());
				allusermapdetails.put(student.getIdetificationid(), uservo);
			}
			
		}
	
		//students.forEach((student)->{
		//Map<String,UserVO> allusermap=(Map<String, UserVO>) LogicqContextProvider.getElementFromApplicationMap("CACHEDUSER");
		//Map<String,EducationVO>  studenteducationdetails = (Map<String, EducationVO>) LogicqContextProvider.getElementFromApplicationMap("CACHEDSTUDENTEDU");
		
		//});
	}


}
