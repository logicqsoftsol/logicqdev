package com.logicq.logicq.ui.search.bean;

import java.util.List;

import com.logicq.logicq.common.LogicqContextProvider;
import com.logicq.logicq.ui.search.helper.UserSearchBeanHelper;
import com.logicq.logicq.ui.search.vo.UserSearchRequest;
import com.logicq.logicq.ui.search.vo.UserSearchResponse;
import com.logicq.logicq.ui.search.vo.UserSearchVO;
import com.logicq.logicq.ui.user.bean.ProfileBean;
import com.logicq.logicq.ui.user.bean.UserBean;
import com.logicq.logicq.ui.user.vo.UserVO;

public class UserSearchManagedBean {
	
	

	public void searchUsers(UserSearchBean userSearchBean) {
		UserSearchBeanHelper userSearchBeanHelper = LogicqContextProvider.getApplicationContext().getBean(UserSearchBeanHelper.class);
		UserSearchRequest userSearchRequest = LogicqContextProvider.getApplicationContext().getBean(UserSearchRequest.class);
		UserSearchResponse userSearchResponse = LogicqContextProvider.getApplicationContext().getBean(UserSearchResponse.class);
		userSearchResponse = userSearchBeanHelper.searchUsers(userSearchRequest, userSearchResponse);
	}
	
	public void displaySearchResult(UserBean userBean, UserSearchResponse userSearchResponse) {
		List<UserVO> profilevolist = userSearchResponse.getUserlist();
		List<ProfileBean> profilebeanlist = userBean.getProfiles();
	}
}
