package com.logicq.logicq.service.search.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.logicq.logicq.dao.user.IUserDAO;
import com.logicq.logicq.model.user.User;
import com.logicq.logicq.service.search.IUserSearchApplicationService;
import com.logicq.logicq.ui.search.vo.UserSearchRequest;
import com.logicq.logicq.ui.search.vo.UserSearchResponse;
import com.logicq.logicq.ui.search.vo.UserSearchVO;

public class UserSearchApplicationService implements IUserSearchApplicationService {

	@Autowired
	IUserDAO userDAO;

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public UserSearchResponse searchUsers(UserSearchRequest userSearchRequest, UserSearchResponse userSearchResponse) {

		String pincode =userSearchRequest.getUserSearchVO().getPincode();
		String searchtext=userSearchRequest.getUserSearchVO().getSearchText();
		//String[] inputs = { city };
		List<User> users = null;//userDAO.getParticularUsersForArea(searchtext,pincode);
		//userSearchResponse.setLogicqTransactionStatus(logicqTransactionStatus);
		return userSearchResponse;
	}
}
