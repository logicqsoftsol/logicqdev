package com.logicq.homeplus.dao;

import java.util.List;

import com.logicq.homeplus.model.ServiceDetails;
import com.logicq.homeplus.model.ServiceList;

public interface IServiceRequestDAO {
	 void saveServiceDetails(ServiceDetails serviceDetails);
      ServiceDetails getServiceDetailsAccordingToRefrence(String refrenceNumber);
      List<ServiceDetails> getServiceDetailsAccordingToFilter(ServiceList serviceList);
}
