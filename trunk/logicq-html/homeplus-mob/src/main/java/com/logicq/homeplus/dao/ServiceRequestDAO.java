package com.logicq.homeplus.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.logicq.homeplus.helper.DateHelper;
import com.logicq.homeplus.model.ServiceDetails;
import com.logicq.homeplus.model.ServiceList;

@Repository
public class ServiceRequestDAO extends AbstractDAO<ServiceDetails> implements IServiceRequestDAO{

	
	@Override
	public void saveServiceDetails(ServiceDetails serviceDetails) {
	  save(serviceDetails);
	}

	@Override
	public ServiceDetails getServiceDetailsAccordingToRefrence(String refrenceNumber) {
		String query = "from ServiceDetails where refrenceNumber='" + refrenceNumber + "'";
		List<ServiceDetails> serviceDetailsList = (List<ServiceDetails>) execcuteQuery(query);
		if (null != serviceDetailsList && !serviceDetailsList.isEmpty()) {
			return serviceDetailsList.get(0);
		}
		return null;
	}

	@Override
	public List<ServiceDetails> getServiceDetailsAccordingToFilter(ServiceList serviceList) {
		String startDate=DateHelper.convertDateToString(serviceList.getFromdate());
		String endDate=DateHelper.convertDateToString(serviceList.getTodate());
		String query = "from ServiceDetails sd where sd.serviceRequestDate BETWEEN '"+startDate+"' AND '"+endDate+"'";
		return (List<ServiceDetails>) execcuteQuery(query);
	}

}
