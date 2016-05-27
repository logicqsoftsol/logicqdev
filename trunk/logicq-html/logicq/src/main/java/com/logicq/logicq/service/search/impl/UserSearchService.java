package com.logicq.logicq.service.search.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.logicq.logicq.conversion.user.UserConversion;
import com.logicq.logicq.conversion.user.UserSearchConversion;
import com.logicq.logicq.dao.user.IUserDAO;
import com.logicq.logicq.model.user.User;
import com.logicq.logicq.model.user.UserSearch;
import com.logicq.logicq.service.search.IUserSearchService;
import com.logicq.logicq.ui.search.vo.UserSearchVO;

@Service
@Transactional
public class UserSearchService implements IUserSearchService {

	@Autowired
	IUserDAO userDAO;
	
	UserSearchConversion usersearchConversion = UserSearchConversion.getInstance();


	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	@ExceptionHandler(Exception.class)
	public UserSearchVO searchUsers(@Validated UserSearchVO userSearchVO) {
		UserSearch usersearch= usersearchConversion.conversionFromVOtoEntity(userSearchVO, UserSearch.class);
		List<User>  users=	userDAO.getAllEntityAccordingtoLocation(usersearch);
		return usersearchConversion.conversionFromEntitytoVO(usersearch, userSearchVO);
	}
}
