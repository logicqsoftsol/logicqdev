package com.logicq.logicq.service.search.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.logicq.dao.user.IUserDAO;
import com.logicq.logicq.model.user.User;
import com.logicq.logicq.service.search.IUserSearchService;
import com.logicq.logicq.ui.search.vo.UserSearchRequest;
import com.logicq.logicq.ui.search.vo.UserSearchResponse;

@Service
@Transactional
public class UserSearchService implements IUserSearchService {

	@Autowired
	IUserDAO userDAO;

	public UserSearchResponse searchUsers(UserSearchRequest userSearchRequest, UserSearchResponse userSearchResponse) {

		String pincode =userSearchRequest.getUserSearchVO().getPincode();
		String searchtext=userSearchRequest.getUserSearchVO().getSearchText();
		//String[] inputs = { city };
		List<User> users = null;//userDAO.getParticularUsersForArea(searchtext,pincode);
		//userSearchResponse.setLogicqTransactionStatus(logicqTransactionStatus);
		return userSearchResponse;
	}
}
