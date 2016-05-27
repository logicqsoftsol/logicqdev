package com.logicq.logicq.ui.search.vo;

import com.logicq.logicq.common.ConvertClass;

@ConvertClass(enable=true)
public class UserSearchVO {

    private String addressId;
	private String searchText;
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	
}
