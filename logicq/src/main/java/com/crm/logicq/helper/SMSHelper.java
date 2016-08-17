package com.crm.logicq.helper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crm.logicq.common.ICommonConstant;
import com.crm.logicq.common.LogicqContextProvider;
import com.crm.logicq.common.vendor.sms.SMSVendor;
import com.crm.logicq.constant.SMSType;
import com.crm.logicq.model.alert.SMSDetails;
import com.crm.logicq.security.helper.StringFormatHelper;
import com.crm.logicq.service.alert.impl.sms.ISMSService;
import com.crm.logicq.ui.alert.NotificationParamVO;
import com.crm.logicq.vo.attendance.CardDetailsVO;
import com.crm.logicq.vo.event.EventDetailsVO;
import com.crm.logicq.vo.user.UserVO;


public class SMSHelper {
	private final static Logger logger = Logger.getLogger(SMSHelper.class);
	private final static  SMSVendor smsvendor=SMSVendor.getInstance();
	/**
	 * 
	 * @param user
	 * @param communication
	 * @param cardetails
	 * @return
	 * @throws Exception 
	 */
	public static SMSDetails prepareSMSDetailsFromUserForAttendance(UserVO userdetails,
			CardDetailsVO cardvo, String templaet,List<String> templatekeys) throws Exception {
		SMSDetails smsdetails = new SMSDetails();
		NotificationParamVO paramvo=new NotificationParamVO();
		if(null!=cardvo.getIntime()){
	    paramvo.setIntime(cardvo.getIntime());
		}
	    if(null!=cardvo.getOuttime()){
		paramvo.setOuttime(cardvo.getOuttime());
	    }
	    if(null==cardvo.getCardswapdate()){
	    	paramvo.setDate(new Date());
	    }
		paramvo.setName(userdetails.getFirstName());
		smsdetails.setMobileNumber(userdetails.getMobilenumber());
		smsdetails.setSmsdate(cardvo.getCardswapdate());
		smsdetails.setType(SMSType.ATTENDANCE);
		String text=formSMSText(paramvo,templaet,templatekeys);
		smsdetails.setText(text);
		return smsdetails;
	}
	
	
	/**
	 * 
	 * @param user
	 * @param communication
	 * @param cardetails
	 * @return
	 * @throws Exception 
	 */
	public static SMSDetails prepareSMSDetailsFromUser(UserVO userdetails, String templaet,List<String> templatekeys) throws Exception {
		SMSDetails smsdetails = new SMSDetails();
		NotificationParamVO paramvo=new NotificationParamVO();
		if(null!=userdetails.getFirstName()){
		paramvo.setName(userdetails.getFirstName());
		}
		smsdetails.setMobileNumber(userdetails.getMobilenumber());
		String text=formSMSText(paramvo,templaet,templatekeys);
		smsdetails.setText(text);
		return smsdetails;
	}	
	
	/**
	 * 
	 * @param smsdetails
	 * @throws Exception 
	 * @throws Exception
	 */
	public static SMSDetails sendSMS(SMSDetails smsdetails){
		
		HttpURLConnection httpconnection=null;
		try{
			StringBuilder smsurldetails=formSMSURL(smsdetails);
			URL url = new URL(smsurldetails.toString());
			httpconnection = (HttpURLConnection) url.openConnection();
			httpconnection.setRequestMethod("GET");
			httpconnection.setRequestProperty("Accept", "application/json");
			smsLogStatus(httpconnection,smsdetails);
		}catch(Exception ex){
			smsdetails.setStatus("Fail");
		}
		finally{
			if(null!=httpconnection){
			httpconnection.disconnect();
			}
		}
	
		return smsdetails;
	}
/**
 * 
 * @param smsdetails
 * @return
 * @throws Exception
 */
	private static StringBuilder formSMSURL(SMSDetails smsdetails) throws Exception{
		StringBuilder urlString =new StringBuilder();
		urlString.append(smsvendor.getUrl());
		urlString.append("user="+smsvendor.getUserid()+"&");
		urlString.append("password="+smsvendor.getPassword()+"&");
		urlString.append("msisdn="+smsdetails.getMobileNumber()+"&");
		urlString.append("sid="+smsvendor.getSid()+"&");
		urlString.append("msg="+StringFormatHelper.formatStringForSMS(smsdetails.getText())+"&");
		urlString.append("fl="+smsvendor.getFlag()+"&");
		urlString.append("gwid="+smsvendor.getGwid());
		return urlString;
	}
	
	/**
	 * 
	 * @param conn
	 * @throws Exception
	 */
	public static void smsLogStatus(HttpURLConnection conn,SMSDetails smsdetails) throws Exception{
		if (conn.getResponseCode() != 200) {
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output;
				while ((output = br.readLine()) != null) {
					smsdetails.setStatus(output);
					smsdetails.setStatuscode(String.valueOf(conn.getResponseCode()));
				}
		}else{
			smsdetails.setStatus("Sucess");
			smsdetails.setStatuscode(String.valueOf(conn.getResponseCode()));
		}
	}
	
	private static String formSMSText(NotificationParamVO parameter, String template,List<String> templatekeys) throws Exception {
		
		for(String tempkey:templatekeys){
		Field field = parameter.getClass().getDeclaredField(tempkey);
		field.setAccessible(Boolean.TRUE);
	    String keyvalue=String.valueOf(field.get(parameter)) ;
	    template=template.replace("#"+tempkey, keyvalue);
		};
		return template;

	}
	
	public static void executeSMS(List<SMSDetails> smspresentlist){
		if (null != smspresentlist && !smspresentlist.isEmpty()) {
			runSMSExecutor(smspresentlist);
		}
	}
	
	private static void runSMSExecutor(List<SMSDetails> allSMSDetails) {
		if (null != allSMSDetails && !allSMSDetails.isEmpty()) {
			ExecutorService executorService = Executors.newFixedThreadPool(5);
			try{
			executorService.execute(new Runnable() {
			    public void run() {
			    	List<SMSDetails> smsdetailslist=new ArrayList<SMSDetails>();
			    	allSMSDetails.forEach((smsinfo) -> {
			    	   SMSDetails	smslogdetails= SMSHelper.sendSMS(smsinfo);
			    		smsdetailslist.add(smslogdetails);
			    		
			    	});
			    	ISMSService smsservice=LogicqContextProvider.getApplicationContext().getBean(ISMSService.class);
		    		smsservice.logsmsdetails(smsdetailslist);
			    }
			});
			}finally{
			executorService.shutdown();
			}
		}
	}
	
	public static void prepareTemplateAndExecuteSMS(EventDetailsVO eventDetailsVO){
		@SuppressWarnings("unchecked")
		Map<String, UserVO> allusermapdetails = (Map<String, UserVO>) LogicqContextProvider
				.getElementFromApplicationMap(ICommonConstant.CACHEDUSER);
		List<SMSDetails> smspresentlist = new ArrayList<SMSDetails>();
		for (Map.Entry<String, UserVO> usermap : allusermapdetails.entrySet()) {
			try {
				UserVO user = usermap.getValue();
				if ((user.getEntityType().getValue().equals(eventDetailsVO.getApplicablefor()))
						|| ("ALL".equals(eventDetailsVO.getApplicablefor()))) {
				List<String> templatekeys = StringFormatHelper.getSMSTemplateKey(eventDetailsVO.getTemplatetext());
				SMSDetails smsdetails = SMSHelper.prepareSMSDetailsFromUser(user, eventDetailsVO.getTemplatetext(),
						templatekeys);
				smspresentlist.add(smsdetails);
				}
			} catch (Exception ex) {
				logger.error(" Unable to prepare message " + ex.getMessage());
			}
		}
	      	    //Execute SMS
				SMSHelper.executeSMS(smspresentlist);
		
	}
	
}
