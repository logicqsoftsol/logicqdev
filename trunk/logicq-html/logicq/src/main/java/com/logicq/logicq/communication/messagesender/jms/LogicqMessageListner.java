package com.logicq.logicq.communication.messagesender.jms;

import java.util.StringTokenizer;

import org.springframework.util.StringUtils;

import com.logicq.logicq.common.LogicqContextProvider;


public class LogicqMessageListner  {


	public void handleMessage(String text) {
		StringTokenizer st2 = new StringTokenizer(text);
		String l_key = "";
		String l_value = "";
		while(st2.hasMoreTokens()) {
			if (StringUtils.isEmpty(l_value)) {
				l_value = st2.nextToken();
			} else {
				l_key = st2.nextToken();
			}
		}
		//LogicqContextProvider.getApplicationmap().put(l_key, l_value);
	}
}
