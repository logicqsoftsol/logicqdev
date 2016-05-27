package com.logicq.logicq.model.user;

import com.logicq.logicq.common.ConvertClass;

@ConvertClass(enable=true)
public class UserSearch implements UserSearchConstant{

	private String searchText;
	private Long addressid;
	
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	public Long getAddressid() {
		return addressid;
	}
	public void setAddressid(Long addressid) {
		this.addressid = addressid;
	}
	

}
