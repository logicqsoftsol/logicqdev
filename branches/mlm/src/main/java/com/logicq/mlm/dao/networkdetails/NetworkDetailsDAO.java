package com.logicq.mlm.dao.networkdetails;

import org.springframework.stereotype.Repository;

import com.logicq.mlm.dao.AbstractDAO;
import com.logicq.mlm.model.profile.NetworkInfo;

@Repository
public class NetworkDetailsDAO  extends AbstractDAO<NetworkInfo> implements INetworkDetailsDAO{

	@Override
	public NetworkInfo getNetworkDetails(String memberid) {
		StringBuilder query=new StringBuilder();
		query.append(" from NetworkInfo ni where ni.memberid='"+memberid+"'");
		// need to change query may break as null pointer
		return (NetworkInfo) execcuteQuery(query.toString()).get(0);
	}

	@Override
	public void saveNetworkDetails(NetworkInfo networkinfo) {
		save(networkinfo);
	}

	@Override
	public void updateNetworkDetails(NetworkInfo networkinfo) {
		update(networkinfo);
	}

}
