package com.logicq.mlm.service.networkdetails;

import java.util.List;

import com.logicq.mlm.model.profile.NetworkInfo;

public interface INetworkDetailsService {
	NetworkInfo getNetworkDetails(String memberid);
	void saveNetworkDetails(NetworkInfo networkinfo);
	void updateNetworkDetails(NetworkInfo networkinfo);
	List<NetworkInfo> getNetworkDetailsForParent(String parentid);
	 NetworkInfo getUpdatePedingNetworkDetails(String memberid);

}