package com.logicq.logicq.ui.search.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.logicq.logicq.common.JSFUtil;
import com.logicq.logicq.common.LogicqContextProvider;
import com.logicq.logicq.ui.user.bean.EntityAvailabilityBean;
import com.logicq.logicq.ui.user.bean.EntityAvalAtLocationBean;
import com.logicq.logicq.ui.user.bean.ProfileBean;
import com.logicq.logicq.ui.user.vo.FacilityVO;

@ManagedBean(name = "userSearchMB")
@ViewScoped
public class UserSearchBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5987953879794515014L;
	private String searchText;
	private String searchlocation; 
	
	private List<ProfileBean> profiles;
	
	public List<ProfileBean> getProfiles() {
		profiles=(List<ProfileBean>)LogicqContextProvider.getElementFromApplicationMap("profileMB"); //LogicqContextProvider.getConversationMap().get("profileMB");
		LogicqContextProvider.removeElementFromApplicationMap("profileMB");
		return profiles;
	}

	public void setProfiles(List<ProfileBean> profiles) {
		this.profiles = profiles;
	}


	

	public String searchUsers() {
		UserSearchManagedBean userSearchManagedBean = LogicqContextProvider.getApplicationContext().getBean(UserSearchManagedBean.class);
		userSearchManagedBean.searchUsers(this);
			LogicqContextProvider.addElementFromApplicationMap("profileMB", profiles);
			JSFUtil.handleNavigation("searchresult");
		return "searchresult";
	}

	
	public String getSearchlocation() {
		return searchlocation;
	}

	public void setSearchlocation(String searchlocation) {
		this.searchlocation = searchlocation;
	}

	
	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	
}
