package com.logicq.mlm.dao.performance;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

import com.logicq.mlm.dao.AbstractDAO;
import com.logicq.mlm.model.performance.UserPerformance;

@Repository
public class UserPerformanceDAO extends AbstractDAO<UserPerformance> implements IUserPerformanceDAO{

	@Override
	public UserPerformance fetchUserPerformanceAccordingToAggregation(UserPerformance userperformance) {
		userperformance.setAggregationType("Last 1 Week");
		userperformance.setMetting(10);
		userperformance.setNetwork(10);
		userperformance.setRatting(4);
		userperformance.setTask(15);
		userperformance.setPerformancetype("GOOD");
		userperformance.setIncome(new BigDecimal(1000.00));
		return null;
	}

	
}
