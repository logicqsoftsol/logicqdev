package com.logicq.mlm.service.networkdetails;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logicq.mlm.dao.networkdetails.INetworkDetailsDAO;
import com.logicq.mlm.model.profile.NetworkInfo;

@Service
@Transactional
public class NetworkDetailsService implements INetworkDetailsService {

	@Autowired
	INetworkDetailsDAO networkdetailsdao;
	
	@Override
	public NetworkInfo getNetworkDetails(String memberid) {
		return networkdetailsdao.getNetworkDetails(memberid);
	}

	@Override
	public void saveNetworkDetails(NetworkInfo networkinfo) {
		networkdetailsdao.saveNetworkDetails(networkinfo);
	}

	@Override
	public void updateNetworkDetails(NetworkInfo networkinfo) {
		networkdetailsdao.updateNetworkDetails(networkinfo);
	}

	@Override
	public List<NetworkInfo> getNetworkDetailsForParent(String parentid) {
		return networkdetailsdao.getNetworkDetailsForParent(parentid);
	}

	@Override
	public NetworkInfo getUpdatePedingNetworkDetails(String memberid) {
		return networkdetailsdao.getUpdatePedingNetworkDetails(memberid);
	}

}
