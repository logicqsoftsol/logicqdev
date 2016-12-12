package com.logicq.mlm.dao.networkdetails;

import com.logicq.mlm.model.profile.NetworkInfo;

public interface INetworkDetailsDAO {
	
	NetworkInfo getNetworkDetails(String memberid);
	void saveNetworkDetails(NetworkInfo networkinfo);
	void updateNetworkDetails(NetworkInfo networkinfo);

}
