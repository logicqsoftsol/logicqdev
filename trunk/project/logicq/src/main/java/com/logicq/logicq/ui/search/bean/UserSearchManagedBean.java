package com.logicq.logicq.ui.search.bean;

import com.logicq.logicq.common.LogicqContextProvider;
import com.logicq.logicq.ui.search.helper.UserSearchBeanHelper;
import com.logicq.logicq.ui.search.vo.UserSearchRequest;
import com.logicq.logicq.ui.search.vo.UserSearchResponse;
import com.logicq.logicq.ui.search.vo.UserSearchVO;

public class UserSearchManagedBean {

	public UserSearchResponse searchUsers(UserSearchBean userSearchBean) {

		UserSearchBeanHelper userSearchBeanHelper = LogicqContextProvider.getApplicationContext().getBean(UserSearchBeanHelper.class);
		UserSearchVO userSearchVO = LogicqContextProvider.getApplicationContext().getBean(UserSearchVO.class);
		UserSearchRequest userSearchRequest = LogicqContextProvider.getApplicationContext().getBean(UserSearchRequest.class);
		UserSearchResponse userSearchResponse = LogicqContextProvider.getApplicationContext().getBean(UserSearchResponse.class);
		userSearchVO = userSearchBeanHelper.convertUserBeanToVO(userSearchBean, userSearchVO);
		userSearchRequest.setUserSearchVO(userSearchVO);
		userSearchResponse = userSearchBeanHelper.searchUsers(userSearchRequest, userSearchResponse);
		return userSearchResponse;
	}
}
