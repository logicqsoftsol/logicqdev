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
	IUserDAO iUserDAO;

	public UserSearchResponse searchUsers(UserSearchRequest userSearchRequest, UserSearchResponse userSearchResponse) {

		UserSearchVO userSearchVO = userSearchRequest.getUserSearchVO();
		String city = userSearchVO.getCity();
		String[] inputs = { city };
		List<User> users = iUserDAO.getUsersForAddress(inputs);
		//userSearchResponse.setLogicqTransactionStatus(logicqTransactionStatus);
		return userSearchResponse;
	}
}
