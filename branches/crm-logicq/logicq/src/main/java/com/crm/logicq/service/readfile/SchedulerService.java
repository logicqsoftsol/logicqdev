package com.crm.logicq.service.readfile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.crm.logicq.dao.readfile.IReadFileDAO;
import com.crm.logicq.dao.readfile.ReadFileDAO;
import com.crm.logicq.model.user.CardReadDetails;
import com.crm.logicq.service.user.IUserService;
/**
 * 
 * @author Nihar 
 *
 */
@Service("ScheduleService")
public class SchedulerService implements ISchedulerService {
	
	@Autowired
	IReadFileDAO readFileDAO;
	
	@Autowired
	IUserService userservice;
	

	
	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public void readAccessFile()  throws Exception{
		List<CardReadDetails> userCardDeatils = readFileDAO.readAccessFile();
		userservice.getUserForSMS(userCardDeatils);
	}

	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public void performTask() {
		
	}
}