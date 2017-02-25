package com.logicq.mlm.common.schedule;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.logicq.mlm.common.helper.PropertyHelper;
import com.logicq.mlm.common.helper.StringFormatHelper;
import com.logicq.mlm.model.admin.NetWorkTask;
import com.logicq.mlm.model.performance.UserNetworkCount;
import com.logicq.mlm.model.profile.NetWorkDetails;
import com.logicq.mlm.model.profile.NetworkInfo;
import com.logicq.mlm.service.networkdetails.INetworkDetailsService;
import com.logicq.mlm.service.networkdetails.INetworkTaskService;
import com.logicq.mlm.service.performance.IUserNetworkPerformanceService;
import com.logicq.mlm.service.user.IUserService;
import com.logicq.mlm.service.wallet.IFeeSetupService;

@Configuration
@EnableScheduling
public class NetworkInfoTimerTask  {

	@Autowired
	IUserService userservice;
	
	@Autowired
	INetworkDetailsService networkDetailService;
	
	@Autowired
	INetworkTaskService networktaskservice;
	
	@Autowired
	IFeeSetupService feeSetupService;
	
	@Autowired
	IUserNetworkPerformanceService userNetworkPerformance;

	
	ObjectMapper mapper=new ObjectMapper();
	
	@Scheduled(fixedDelay = 30000)
	public void updateNetworkinfo() throws Exception {
		List<NetWorkTask> tasklist = networktaskservice.getNetworkTaskList();
		if (!tasklist.isEmpty()) {
			for (NetWorkTask task : tasklist) {
				updateNetworkDetails(task.getMemberid(),task.getParentid());
				networktaskservice.deleteNetworkTask(task);
			}
		}

	}

	private void updateNetworkDetails(String memberid, String parentid) throws Exception {
		NetworkInfo networkInfo = networkDetailService.getNetworkDetails(memberid);
		NetWorkDetails networkdetails = PropertyHelper.convertJsonToNetworkInfo(networkInfo);
		NetworkInfo parentNetworkInfo = networkDetailService.getNetworkDetails(parentid);
		NetWorkDetails parentNetworkdetails = PropertyHelper.convertJsonToNetworkInfo(parentNetworkInfo);
		List<NetWorkDetails> childNetworksDetails = parentNetworkdetails.getChildren();
		List<NetWorkDetails> newchildNetworksDetails = new ArrayList<>();
		newchildNetworksDetails.addAll(childNetworksDetails);
		if (null != childNetworksDetails && !childNetworksDetails.isEmpty()) {
			NetWorkDetails childNetwork = null;
			for (int i = 0; i < childNetworksDetails.size(); i++) {
				childNetwork = childNetworksDetails.get(i);
				if (childNetwork.getName().equals(networkdetails.getName())) {
					childNetwork = networkdetails;
					updateNetworkLevel(childNetwork, parentNetworkdetails.getCategory());
					newchildNetworksDetails.remove(i);
					newchildNetworksDetails.add(childNetwork);
					parentNetworkdetails.setChildren(newchildNetworksDetails);
					parentNetworkInfo
							.setNetworkjson(PropertyHelper.convertNetworkInfoToJson(parentNetworkdetails).getBytes());
					networkDetailService.updateNetworkDetails(parentNetworkInfo);
					break;
				}
			}

		}
		if (!StringUtils.isEmpty(parentNetworkInfo.getParentmemberid())) {
			updateNetworkDetails(parentNetworkInfo.getMemberid(), parentNetworkInfo.getParentmemberid());
		}
	}

	private void updateNetworkLevel(NetWorkDetails childNetwork, String parentLevel) {
		if (null != childNetwork) {
			Integer intlevel = StringFormatHelper.getLevelAsInteger(childNetwork.getCategory());
			if (null != intlevel) {
				intlevel = intlevel + 1;
				String stringlevel = StringFormatHelper.getLevelAsString(intlevel);
				childNetwork.setCategory(stringlevel);
				childNetwork.setTitle(stringlevel);
			}
			List<NetWorkDetails> networkDetails = childNetwork.getChildren();
			if (null != networkDetails && !networkDetails.isEmpty()) {
				for (NetWorkDetails network : networkDetails) {
					updateNetworkLevel(network, network.getCategory());
				}
			}
		}

	}

}
