package com.logicq.logicq.ui.search.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
		//UserSearchManagedBean userSearchManagedBean = LogicqContextProvider.getApplicationContext().getBean(UserSearchManagedBean.class);
		//userSearchManagedBean.searchUsers(this);
		profiles=new ArrayList<ProfileBean>();
		ProfileBean profile=(ProfileBean) LogicqContextProvider.getBean("profileMB");
				profile.setFullname("Test001");
				profile.setFeedback("100");
				profile.setFess("400");
				profile.setFullname("Test For each");
				profile.setLocation("Pune");
				profile.setRecomendation("200");
				profile.setSpcification("Phd");
				profile.setProfileid("Test101");
				profile.setBookingdate(new Date().toString());
				profile.setUserImage("pages/userImage/1000.jpg");
				List<FacilityVO> facilities = new ArrayList<FacilityVO>();
				profile.setFacilityDetails(facilities);
				EntityAvailabilityBean avialen = new EntityAvailabilityBean();
				avialen.setAvilabledate(new Date());
				avialen.setEntityid("Test101");
				avialen.setProfileid("Test101");
				List<EntityAvalAtLocationBean> enetiyavalloc = avialen.getEntityavalloc("Test101", new Date());
				avialen.setEntityavalloc(enetiyavalloc);
				profile.setAvilablityDetails(avialen);
				profiles.add(profile);
			LogicqContextProvider.addElementFromApplicationMap("profileMB", profiles);
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
