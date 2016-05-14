package com.logicq.logicq.ui.search.bean;

import java.util.List;

import com.logicq.logicq.common.LogicqContextProvider;
import com.logicq.logicq.ui.search.helper.UserSearchBeanHelper;
import com.logicq.logicq.ui.search.vo.UserSearchResponse;
import com.logicq.logicq.ui.search.vo.UserSearchVO;
import com.logicq.logicq.ui.user.bean.ProfileBean;
import com.logicq.logicq.ui.user.bean.UserBean;
import com.logicq.logicq.ui.user.vo.UserVO;

public class UserSearchManagedBean {

	public List<UserVO> searchUsers(UserSearchBean userSearchBean) {
		UserSearchBeanHelper userSearchBeanHelper = (UserSearchBeanHelper) LogicqContextProvider.getBeanFromContext(UserSearchBeanHelper.class);
		UserSearchVO uservo = userSearchBeanHelper.searchUsers(userSearchBean);
		return uservo.getUservo();
	}

	public void displaySearchResult(UserBean userBean, UserSearchResponse userSearchResponse) {
		List<UserVO> profilevolist = userSearchResponse.getUserlist();
		List<ProfileBean> profilebeanlist = userBean.getProfiles();
	}
}
