
package com.logicq.mlm.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.logicq.mlm.dao.user.IUserDAO;
import com.logicq.mlm.model.profile.UserProfile;
import com.logicq.mlm.service.otp.IOTPService;

@Service
@Transactional
public class UserService implements IUserService{
	
	@Autowired
	IUserDAO  userdao;
	
	@Autowired
	IOTPService otpservice;

	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public UserProfile fetchUser(UserProfile user) {
		
		return userdao.fetchUser(user);
	}

	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteUser(UserProfile user) {
		userdao.deleteUser(user);
		
	}

	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void saveUser(UserProfile user) {
		userdao.saveUser(user);
		if (null != user.getConatctDetails() && !StringUtils.isEmpty(user.getConatctDetails().getMobilenumber())) {
			otpservice.sendOTP(user.getConatctDetails().getMobilenumber());
		}
	}

	@Override
	@ExceptionHandler(Exception.class)
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateUser(UserProfile user) {
		userdao.updateUser(user);
	}
   
	

}
