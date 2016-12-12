package com.logicq.mlm.common.helper;

import java.util.Properties;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.logicq.mlm.model.profile.NetWorkDetails;
import com.logicq.mlm.model.profile.NetworkInfo;

public class PropertyHelper {
	 static ObjectMapper mapper = new ObjectMapper();
	 
	public static Properties loadProperty(){
		Properties prop=new Properties();
		prop.put("filepath", "");
		return prop;
	}
	
 
  
  public static NetWorkDetails convertJsonToNetworkInfo(NetworkInfo parentnetworkinfo) throws Exception{
	 return  mapper.readValue(new String( parentnetworkinfo.getNetworkjson()),NetWorkDetails.class );
  }

}
