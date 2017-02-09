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
	
	@Scheduled(fixedDelay = 15000)
	public void updateNetworkinfo() throws Exception {
		List<NetWorkTask> tasklist = networktaskservice.getNetworkTaskList();
		if (!tasklist.isEmpty()) {
			Map<String, UserNetworkCount> memberCount = new ConcurrentHashMap<>();
			for (NetWorkTask task : tasklist) {
				int levelCount = 1;
				updateNetworkDetails(task.getMemberid(), task.getParentid(), levelCount);
				networktaskservice.deleteNetworkTask(task);
			}
			calculateWalletBalance(memberCount);
			if (!memberCount.isEmpty()) {
				for (Map.Entry<String, UserNetworkCount> networkCOunt : memberCount.entrySet()) {
					if (null != networkCOunt.getValue()) {
						userNetworkPerformance.addUserNetworkPerformance(networkCOunt.getValue());
					}
				}
			}
		}

	}
	
	

	private void calculateWalletBalance(Map<String,UserNetworkCount> memberCount) throws Exception {
	   
		NetworkInfo memberNetworkInfo = networkDetailService.getNetworkDetails("ADMIN");
		NetWorkDetails membernetworkdetails = PropertyHelper.convertJsonToNetworkInfo(memberNetworkInfo);
		int leveCount=1;
		if (null != membernetworkdetails) {
			calculateChildAttribute(memberCount, membernetworkdetails, leveCount);
		}
	
	}



	private void calculateChildAttribute(Map<String, UserNetworkCount> memberCount, NetWorkDetails membernetworkdetails,
			int leveCount) throws Exception {
		if (null != membernetworkdetails.getChildren() && !membernetworkdetails.getChildren().isEmpty()) {
			List<NetWorkDetails> networkdetails = membernetworkdetails.getChildren();
			UserNetworkCount networkCount = new UserNetworkCount();
			networkCount.setMemberid(membernetworkdetails.getId());
			networkCount.setNetworklevel(leveCount);
			networkCount.setParentid(membernetworkdetails.getParentid());
			if (null != networkdetails) {
				networkCount.setMembercount(networkdetails.size());
			} else {
				networkCount.setMembercount(0);
			}
			memberCount.put(networkCount.getMemberid() + leveCount, networkCount);
			if (!StringUtils.isEmpty(membernetworkdetails.getParentid())) {
				calculateRecursiveParent(memberCount, membernetworkdetails, leveCount, networkdetails, networkCount);
			}
			
			if(null!=networkdetails && !networkdetails.isEmpty()){
			    for(NetWorkDetails network:networkdetails){
			    	int childlevelcount=1;
			    	calculateChildAttribute(memberCount,network,childlevelcount);
			    }
			}
		}
	}



	private void calculateRecursiveParent(Map<String, UserNetworkCount> memberCount,
			NetWorkDetails membernetworkdetails, int leveCount, List<NetWorkDetails> networkdetails,
			UserNetworkCount networkCount) throws Exception {
		NetworkInfo parentNetworkInfo = networkDetailService.getNetworkDetails(networkCount.getParentid());
		NetWorkDetails parentNetworkDetails = PropertyHelper.convertJsonToNetworkInfo(parentNetworkInfo);
		int parentlevel = leveCount + 1;
		UserNetworkCount parentNetworkCount = memberCount.get(membernetworkdetails.getParentid() + parentlevel);
		if (null != parentNetworkCount) {
			parentNetworkCount.setMembercount(networkdetails.size());
		} else {
			parentNetworkCount = new UserNetworkCount();
			parentNetworkCount.setMemberid(networkCount.getParentid());
			parentNetworkCount.setNetworklevel(networkdetails.size());
			networkCount.setParentid(parentNetworkDetails.getParentid());
		}
		memberCount.put(networkCount.getParentid() + parentlevel, parentNetworkCount);
		if (StringUtils.isEmpty(parentNetworkDetails.getParentid()) && null != parentNetworkDetails.getChildren()
				&& !parentNetworkDetails.getChildren().isEmpty()) {
			UserNetworkCount parentnetworkCount = new UserNetworkCount();
			calculateRecursiveParent(memberCount, parentNetworkDetails, parentlevel, parentNetworkDetails.getChildren(),
					parentnetworkCount);
		}
	}



//	private void updateRecrsiveParentNetwork(Map<String, UserNetworkCount> memberCountMap, String parentid,
//			int leveCount) {
//
//		UserNetworkCount usernetwork = memberCountMap.get(parentid + leveCount);
//		if (null != usernetwork) {
//			UserNetworkCount parentNetworkCount = new UserNetworkCount();
//			parentNetworkCount = usernetwork;
//			parentNetworkCount.setNetworklevel(leveCount + 1);
//			memberCountMap.put(parentNetworkCount.getMemberid()+parentNetworkCount.getNetworklevel(),parentNetworkCount);
//			if (StringUtils.isEmpty(parentNetworkCount.getParentid())) {
//				updateRecrsiveParentNetwork(memberCountMap, parentNetworkCount.getParentid(),
//						parentNetworkCount.getNetworklevel() + 1);
//			}
//		}
//	}


	private void updateNetworkDetails(String memberid, String parentid,int levelCount) throws Exception {
		NetworkInfo memberNetworkInfo = networkDetailService.getNetworkDetails(memberid);
		NetWorkDetails membernetworkdetails = PropertyHelper.convertJsonToNetworkInfo(memberNetworkInfo);
		NetworkInfo parentNetworkInfo = networkDetailService.getNetworkDetails(parentid);
		NetWorkDetails parentnetworkdetails = PropertyHelper.convertJsonToNetworkInfo(parentNetworkInfo);
		List<NetWorkDetails> networkchildlist = parentnetworkdetails.getChildren();
		findNetworkNode(membernetworkdetails, parentnetworkdetails, networkchildlist,levelCount);
		parentnetworkdetails.setCategory("LEVEL0");
		parentnetworkdetails.setTitle("LEVEL0");
		String networkjson = PropertyHelper.convertNetworkInfoToJson(parentnetworkdetails);
		parentNetworkInfo.setNetworkjson(networkjson.getBytes());
		parentNetworkInfo.setMemberlevel("");
		networkDetailService.updateNetworkDetails(parentNetworkInfo);
		if(!StringUtils.isEmpty(parentNetworkInfo.getParentmemberid())){
		levelCount=levelCount+1;
		updateNetworkDetails(parentNetworkInfo.getMemberid(), parentNetworkInfo.getParentmemberid(),levelCount);
		}
	}



	private void findNetworkNode(NetWorkDetails membernetworkdetails, NetWorkDetails parentnetworkdetails,
			List<NetWorkDetails> networkchildlist, int levelCount) {
		String level="LEVEL" + levelCount;
		if (null != networkchildlist && !networkchildlist.isEmpty()) {
			for (NetWorkDetails networkdetails : networkchildlist) {
				if (null != networkdetails && !StringUtils.isEmpty(networkdetails.getId())) {
					if (networkdetails.getId().equals(membernetworkdetails.getId())) {
						List<NetWorkDetails> childernnetworks = membernetworkdetails.getChildren();
						int childLevelcount=levelCount;
						setUPLevelForNode(level, childernnetworks,childLevelcount);
						networkdetails.setChildren(childernnetworks);
					} else {
						findNetworkNode(membernetworkdetails, networkdetails, networkdetails.getChildren(), levelCount);
					}
				}
			}

		} else {

			if (!StringUtils.isEmpty(parentnetworkdetails.getId())
					&& parentnetworkdetails.getId().equals(membernetworkdetails.getParentid())) {
				List<NetWorkDetails> newNetworkChildList = new ArrayList<NetWorkDetails>();
				membernetworkdetails.setCategory(level);
				membernetworkdetails.setTitle(level);
				newNetworkChildList.add(membernetworkdetails);
				parentnetworkdetails.setChildren(newNetworkChildList);
			}
		}
	}



	private void setUPLevelForNode(String level, List<NetWorkDetails> childernnetworks, int levelCount) {
		for (NetWorkDetails childernnetwork : childernnetworks) {
			if (!StringUtils.isEmpty(childernnetwork.getId())) {
				childernnetwork.setCategory(level);
				childernnetwork.setTitle(level);
				if (null != childernnetwork.getChildren() && !childernnetwork.getChildren().isEmpty()) {
					int levecount = levelCount + 1;
					String childlevel = "LEVEL" + levecount;
					setUPLevelForNode(childlevel, childernnetwork.getChildren(), levelCount);
				}
			}
		}
	}
	
	
	

}
