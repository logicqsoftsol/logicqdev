package com.logicq.logicq.facade.search;

import org.springframework.beans.factory.annotation.Autowired;

import com.logicq.logicq.service.search.IUserSearchApplicationService;
import com.logicq.logicq.ui.search.vo.UserSearchRequest;
import com.logicq.logicq.ui.search.vo.UserSearchResponse;

public class UserSearchFacade implements IUserSearchFacade {

	@Autowired
	IUserSearchApplicationService userSearchApplicationService;

	public IUserSearchApplicationService getUserSearchApplicationService() {

		return userSearchApplicationService;
	}

	public void setUserSearchApplicationService(IUserSearchApplicationService userSearchApplicationService) {

		this.userSearchApplicationService = userSearchApplicationService;
	}

	public UserSearchResponse searchUsers(UserSearchRequest userSearchRequest, UserSearchResponse userSearchResponse) {

		return (getUserSearchApplicationService().searchUsers(userSearchRequest, userSearchResponse));
	}
}
