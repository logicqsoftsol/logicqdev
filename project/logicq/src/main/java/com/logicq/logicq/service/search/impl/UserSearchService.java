package com.logicq.logicq.service.search.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.logicq.logicq.dao.user.IUserDAO;
import com.logicq.logicq.service.search.IUserSearchService;
import com.logicq.logicq.ui.search.vo.UserSearchVO;

@Service
@Transactional
public class UserSearchService implements IUserSearchService {

	@Autowired
	IUserDAO userDAO;


	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	@ExceptionHandler(Exception.class)
	public UserSearchVO searchUsers(@Validated UserSearchVO userSearchVO) {
		//userDAO.getAllEntityAccordingtoLocation(usersearch)
		return null;
	}
}
