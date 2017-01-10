package com.logicq.mlm.common.schedule;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.logicq.mlm.common.helper.PropertyHelper;
import com.logicq.mlm.model.admin.NetWorkTask;
import com.logicq.mlm.model.profile.NetWorkDetails;
import com.logicq.mlm.model.profile.NetworkInfo;
import com.logicq.mlm.service.networkdetails.INetworkDetailsService;
import com.logicq.mlm.service.networkdetails.INetworkTaskService;
import com.logicq.mlm.service.user.IUserService;

@Configuration
@EnableScheduling
public class NetworkInfoTimerTask  {

	@Autowired
	IUserService userservice;
	
	@Autowired
	INetworkDetailsService networkDetailService;
	
	@Autowired
	INetworkTaskService networktaskservice;
	
	

	
	ObjectMapper mapper=new ObjectMapper();
	
	@Scheduled(fixedDelay=15000)
	public void updateNetworkinfo() throws Exception {
		List<NetWorkTask> tasklist=networktaskservice.getNetworkTaskList();
		for(NetWorkTask task:tasklist){
			int levelCount=1;
			updateNetworkDetails(task.getMemberid(),task.getParentid(), levelCount);
			networktaskservice.deleteNetworkTask(task);
		}
		
		
	}
	
	

	private void updateNetworkDetails(String memberid, String parentid,int levelCount) throws Exception {
		NetworkInfo memberNetworkInfo = networkDetailService.getNetworkDetails(memberid);
		NetWorkDetails membernetworkdetails = PropertyHelper.convertJsonToNetworkInfo(memberNetworkInfo);
		NetworkInfo parentNetworkInfo = networkDetailService.getNetworkDetails(parentid);
		NetWorkDetails parentnetworkdetails = PropertyHelper.convertJsonToNetworkInfo(parentNetworkInfo);
		List<NetWorkDetails> networkchildlist = parentnetworkdetails.getChildren();
		findNetworkNode(membernetworkdetails, parentnetworkdetails, networkchildlist,levelCount);
		String networkjson = PropertyHelper.convertNetworkInfoToJson(parentnetworkdetails);
		parentNetworkInfo.setNetworkjson(networkjson.getBytes());
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
