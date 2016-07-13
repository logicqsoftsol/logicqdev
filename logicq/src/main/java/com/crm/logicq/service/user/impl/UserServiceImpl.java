package com.crm.logicq.service.user.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.crm.logicq.common.LogicqContextProvider;
import com.crm.logicq.constant.ContactType;
import com.crm.logicq.constant.EntityType;
import com.crm.logicq.constant.alert.AlertType;
import com.crm.logicq.dao.employee.IEmployeeDAO;
import com.crm.logicq.dao.student.IStudentDAO;
import com.crm.logicq.dao.user.IUserDAO;
import com.crm.logicq.helper.SMSHelper;
import com.crm.logicq.model.alert.SMSDetails;
import com.crm.logicq.model.attendance.AttendanceCriteria;
import com.crm.logicq.model.attendance.AttendanceDetails;
import com.crm.logicq.model.communication.PhoneCommunication;
import com.crm.logicq.model.user.CardReadDetails;
import com.crm.logicq.model.user.Employee;
import com.crm.logicq.model.user.Student;
import com.crm.logicq.model.user.User;
import com.crm.logicq.service.alert.IAlertService;
import com.crm.logicq.service.user.IUserService;
import com.crm.logicq.ui.alert.AlertDetailsInputVO;
import com.crm.logicq.vo.attendance.AttendanceVO;

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
		userdetails.stream().forEach((user) -> {
			LogicqContextProvider.addElementToApplicationMap(user.getIdetificationid(), user);
		});
	}

	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void getUserForSMS(List<CardReadDetails> cardreadDeatils) throws Exception {
		List<SMSDetails> allSMSDetails = new ArrayList<SMSDetails>();
		for (CardReadDetails carddetail : cardreadDeatils) {
			User user = new User();// (User)
									// LogicqContextProvider.getElementFromApplicationMap(String.valueOf(carddetail.getCardid()));

			PhoneCommunication com = new PhoneCommunication();
			com.setActive(Boolean.TRUE);
			com.setContactType(ContactType.HOME);
			com.setMobilenumber("919861318105");
			user.setCommunication(com);
			user.setEmail("asd@gmail.com");
			user.setEntityType(EntityType.STUDENT);
			user.setFirstName("Dinesh");
			user.setIdetificationid("1");
			user.setUserid("STUD-1");
			user.setLastName("Bhera");
			user.setGender("Male");
			PhoneCommunication communications = user.getCommunication();
			
			if (null != communications && communications.isActive()) {
				SMSDetails smsdetails = SMSHelper.prepareSMSDetailsFromUser(user, communications, carddetail);
				allSMSDetails.add(smsdetails);
			}
		}
		if (null != allSMSDetails && !allSMSDetails.isEmpty()) {
			for (SMSDetails smsinfo : allSMSDetails) {
				SMSHelper.sendSMS(smsinfo);
			}
			// userdao.insertSMSDetails(allSMSDetails);
		}
		
	}


	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void triggerSMS(List<CardReadDetails> cardreadDeatils) throws Exception {
		List<SMSDetails> allSMSDetails = new ArrayList<SMSDetails>();
		for (CardReadDetails carddetail : cardreadDeatils) {
//			User userFromCache = (User) LogicqContextProvider.getElementFromApplicationMap(String.valueOf(carddetail.getCardid()));
//			if(null==userFromCache){
//				loadUsers();
//			}
			User user = new User();//(User) LogicqContextProvider.getElementFromApplicationMap(String.valueOf(carddetail.getCardid()));
			Set<PhoneCommunication> comset=new HashSet<PhoneCommunication>();
			PhoneCommunication com=new PhoneCommunication();
			com.setActive(Boolean.TRUE);
			com.setContactType(ContactType.HOME);
			com.setMobilenumber("919604551123");
			user.setCommunication(com);
			user.setEmail("asd@gmail.com");
			user.setEntityType(EntityType.STUDENT);
			user.setFirstName("Sangarm");
			user.setIdetificationid("1");
			user.setUserid("STUD-1");
			user.setLastName("Parida");
			user.setGender("Male");
			
			PhoneCommunication communications = user.getCommunication();
		
				if (null != communications && communications.isActive()) {
					SMSDetails smsdetails = SMSHelper.prepareSMSDetailsFromUser(user, communications, carddetail);
					//AlertDetailsInputVO alertDetailsVO = prepareAlertMessage(smsdetails);
					//String alertMessage = alertService.buildAlert(alertDetailsVO);
					//smsdetails.setText(alertMessage);
					allSMSDetails.add(smsdetails);
				}
		
		}
		if (null != allSMSDetails && !allSMSDetails.isEmpty()) {
			for (SMSDetails smsinfo : allSMSDetails) {
				SMSHelper.sendSMS(smsinfo);
			}
			// userdao.insertSMSDetails(allSMSDetails);
		}
		
	}

	@Override
	public void getUser(String cardid) throws Exception {
		
		
	}

	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<AttendanceVO> getAttendanceDetails(AttendanceCriteria attendancecriteria) throws Exception {
		 List<AttendanceDetails> attendacedetails= userdao.getAttendanceDetails(attendancecriteria);
		 return  AttendanceConversion.convertEntityToVO(attendacedetails);
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
	public List<Employee> getEmployeeList() throws Exception {
		return employeedao.getEmployeeList();
		
	}

	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<Student>  getStudentList() throws Exception {
		return studentdao.getStudentList();
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


	
	
}
