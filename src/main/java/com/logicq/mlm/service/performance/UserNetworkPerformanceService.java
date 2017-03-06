package com.logicq.mlm.service.performance;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logicq.mlm.dao.performance.IUserNetworkPerformanceDAO;
import com.logicq.mlm.model.performance.UserNetworkCount;

@Service
@Transactional
public class UserNetworkPerformanceService  implements IUserNetworkPerformanceService{

	@Autowired
	IUserNetworkPerformanceDAO networkperfdao;
	
	@Override
	public void updateUserNetworkPerformance(UserNetworkCount usernetowrk) {
		networkperfdao.updateUserNetworkPerformance(usernetowrk);
		
	}

	@Override
	public void addUserNetworkPerformance(UserNetworkCount usernetowrk) {
		networkperfdao.addUserNetworkPerformance(usernetowrk);
		
	}

	@Override
	public List<UserNetworkCount> getNetworkPerformance(UserNetworkCount usernetowrk) {
		return networkperfdao.getNetworkPerformance(usernetowrk);
	}

	@Override
	public void addUserNetworkPerformanceList(List<UserNetworkCount> usernetowrkList) {
		networkperfdao.addUserNetworkPerformanceList(usernetowrkList);
		
	}

	@Override
	public UserNetworkCount getNetworkPerformanceForMemeberandLevel(UserNetworkCount usernetowrk) {
		return networkperfdao.getNetworkPerformanceForMemeberandLevel(usernetowrk);
	}

}
