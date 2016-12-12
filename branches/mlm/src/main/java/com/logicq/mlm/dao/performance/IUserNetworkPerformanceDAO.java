package com.logicq.mlm.dao.performance;

import java.util.List;

import com.logicq.mlm.model.performance.UserNetworkCount;

public interface IUserNetworkPerformanceDAO {

	void updateUserNetworkPerformance(UserNetworkCount usernetowrk);
	void addUserNetworkPerformance(UserNetworkCount usernetowrk);
	List<UserNetworkCount> getNetworkPerformance(UserNetworkCount usernetowrk);
}
