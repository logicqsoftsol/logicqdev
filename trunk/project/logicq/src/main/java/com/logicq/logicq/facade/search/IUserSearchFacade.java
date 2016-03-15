package com.logicq.logicq.facade.search;

import com.logicq.logicq.ui.search.vo.UserSearchRequest;
import com.logicq.logicq.ui.search.vo.UserSearchResponse;

public interface IUserSearchFacade {

	public UserSearchResponse searchUsers(UserSearchRequest userSearchRequest, UserSearchResponse userSearchResponse);
}
