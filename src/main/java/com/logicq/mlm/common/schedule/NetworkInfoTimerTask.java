package com.logicq.mlm.common.schedule;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.logicq.mlm.common.helper.PropertyHelper;
import com.logicq.mlm.common.helper.StringFormatHelper;
import com.logicq.mlm.model.admin.FeeSetup;
import com.logicq.mlm.model.admin.NetWorkTask;
import com.logicq.mlm.model.performance.UserNetworkCount;
import com.logicq.mlm.model.profile.NetWorkDetails;
import com.logicq.mlm.model.profile.NetworkInfo;
import com.logicq.mlm.model.profile.UserProfile;
import com.logicq.mlm.model.wallet.WalletStatement;
import com.logicq.mlm.service.networkdetails.INetworkDetailsService;
import com.logicq.mlm.service.networkdetails.INetworkTaskService;
import com.logicq.mlm.service.performance.IUserNetworkPerformanceService;
import com.logicq.mlm.service.user.IUserService;
import com.logicq.mlm.service.wallet.IFeeSetupService;
import com.logicq.mlm.service.wallet.IWalletStmntService;

@Configuration
@EnableScheduling
public class NetworkInfoTimerTask {

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
	
	@Autowired
	IWalletStmntService walletStmntService;

	ObjectMapper mapper = new ObjectMapper();

	@Scheduled(fixedDelay = 30000)
	public void updateNetworkinfo() throws Exception {
		List<NetWorkTask> tasklist = networktaskservice.getNetworkTaskList();
		if (!tasklist.isEmpty()) {
			List<FeeSetup> feeList = feeSetupService.getFeeDetails();
			for (NetWorkTask task : tasklist) {
				updateNetworkDetails(task.getMemberid(), task.getParentid());
				networktaskservice.deleteNetworkTask(task);
				//Map<String,Integer> netWorkCountMap=new HashMap<>();
				//calculateNetworkCount(task.getMemberid(),netWorkCountMap,null);
				calculateWalletAmount(task.getParentid(),feeList,"LEVEL1");
			}
		}
	}

	
	
	private void calculateWalletAmount(String memberid,List<FeeSetup> feeList,String level) throws Exception {
		NetworkInfo networkInfo = networkDetailService.getNetworkDetails(memberid);
		NetWorkDetails networkdetails = PropertyHelper.convertJsonToNetworkInfo(networkInfo);
		if (null != feeList && !feeList.isEmpty()) {
			UserProfile userprofile = userservice.fetchUserAccordingToUserName(memberid);
			WalletStatement walletstment = new WalletStatement();
			walletstment.setWallet(userprofile.getWalletdetails());
			walletstment.setWalletid(userprofile.getWalletdetails().getWalletid());
			if (null != networkdetails.getChildren() && !networkdetails.getChildren().isEmpty()) {
				for (FeeSetup fee : feeList) {
					if (fee.getApplyTo().equals(level)) {
						walletstment = walletStmntService.fetchWalletStmnt(walletstment);
						BigDecimal calculated = caculateAmountAccordingToFee(fee,
								new BigDecimal(1));
						if (null != calculated) {
								walletstment.setPayout(walletstment.getPayout().add(calculated));
								walletstment.setMaxencashable(walletstment.getMaxencashable().add(calculated));
								walletstment.setCurrentbalance(walletstment.getCurrentbalance().add(calculated));
								walletstment.setWalletlastupdate(new Date());
								walletStmntService.updateWalletStmnt(walletstment);
								break;
						   }
						
						
					}
				}
			}
			if (null != networkdetails && !StringUtils.isEmpty(networkInfo.getParentmemberid())) {
				int intlevel = StringFormatHelper.getLevelAsInteger(level);
				int currentlevel = intlevel + 1;
				if (currentlevel <= feeList.size()) {
					String stringlevel = StringFormatHelper.getLevelAsString(currentlevel);
					calculateWalletAmount(networkInfo.getParentmemberid(), feeList, stringlevel);
				}
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
	
	private void calculateNetworkCount(String memberid, Map<String,Integer>  netWorkCountMap,UserNetworkCount networkCount) throws Exception {
		NetworkInfo networkInfo = networkDetailService.getNetworkDetails(memberid);
		NetWorkDetails networkdetails = PropertyHelper.convertJsonToNetworkInfo(networkInfo);
		List<NetWorkDetails> childNetworkList = networkdetails.getChildren();
		if (null != networkdetails) {
			int level = 0;
			UserNetworkCount userNetworkCount = new UserNetworkCount();
			userNetworkCount.setMemberid(networkdetails.getId());
			if (null != networkCount) {
				if (!StringUtils.isEmpty(networkdetails.getParentid())) {
					networkCount.setParentid(networkdetails.getParentid());
				}
				level = networkCount.getNetworklevel();
				UserNetworkCount fetchedUserNetwork = userNetworkPerformance
						.getNetworkPerformanceForMemeberandLevel(networkCount);
				if (null != fetchedUserNetwork) {
					fetchedUserNetwork.setMembercount(networkCount.getMembercount());
					userNetworkPerformance.updateUserNetworkPerformance(fetchedUserNetwork);
					netWorkCountMap.put(networkdetails.getId() + "_" + level, networkCount.getMembercount());
				} else {
					userNetworkPerformance.addUserNetworkPerformance(networkCount);
					netWorkCountMap.put(networkdetails.getId() + "_" + level, networkCount.getMembercount());
				}
			}
			if (!StringUtils.isEmpty(networkdetails.getParentid())) {
				userNetworkCount.setParentid(networkdetails.getParentid());
			}
			if (null != childNetworkList && !childNetworkList.isEmpty()) {
				String networkLevel = childNetworkList.get(0).getCategory();
				level=StringFormatHelper.getLevelAsInteger(networkLevel);
				userNetworkCount.setNetworklevel(level);
				UserNetworkCount fetchedUserNetwork = userNetworkPerformance
						.getNetworkPerformanceForMemeberandLevel(userNetworkCount);
				if (null != fetchedUserNetwork) {
					fetchedUserNetwork.setMembercount(childNetworkList.size());
					userNetworkPerformance.updateUserNetworkPerformance(fetchedUserNetwork);
					netWorkCountMap.put(networkdetails.getId()+"_"+level, childNetworkList.size());
				} else {
					userNetworkCount.setMembercount(childNetworkList.size());
					userNetworkPerformance.addUserNetworkPerformance(userNetworkCount);
					netWorkCountMap.put(networkdetails.getId()+"_"+level, childNetworkList.size());
				}
				
			}
			if (!StringUtils.isEmpty(networkdetails.getParentid())) {
				Integer memberCount = netWorkCountMap.get(networkdetails.getId() + "_" + level);
				UserNetworkCount parentNetworkCount = null;
				if (null != memberCount) {
					parentNetworkCount = new UserNetworkCount();
					parentNetworkCount.setMemberid(networkdetails.getParentid());
					parentNetworkCount.setMembercount(memberCount);
					parentNetworkCount.setNetworklevel(level + 1);
				}
				calculateNetworkCount(networkdetails.getParentid(), netWorkCountMap, parentNetworkCount);
			}
		}
	}


	private BigDecimal caculateAmountAccordingToFee(FeeSetup feedetails,BigDecimal multiplicationfactor) {
		BigDecimal baseAmount = feedetails.getAmount();
		if(null!=baseAmount){
		return baseAmount.multiply(multiplicationfactor);
		}
		return null;
	}


}
