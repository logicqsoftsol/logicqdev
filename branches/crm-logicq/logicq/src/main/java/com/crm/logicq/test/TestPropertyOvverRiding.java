package com.crm.logicq.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class TestPropertyOvverRiding {

	public static void main(String[] args) {
		Map<String, TestKeyValue> duplicatmap = new HashMap<String, TestKeyValue>();
		Pattern inner = Pattern.compile("=|>|<");
		String all = "ClaasName=xyz and EventName=pqr or name=test12 and ClaasName>abc";
		StringTokenizer toknes = new StringTokenizer(all);
		Stack<TestKeyValue> lastvalue=new Stack<TestKeyValue>();
		String joincondtion = null;
		while (toknes.hasMoreTokens()) {
			TestKeyValue keyvalue = new TestKeyValue();
			String token = toknes.nextToken();
			if (token.equals("and")) {
				joincondtion = "and";
				keyvalue=lastvalue.pop();
				keyvalue.setOuterJoinCondition(joincondtion);
				duplicatmap.put(keyvalue.getKey(), keyvalue);
			} else if (token.equals("or")) {
				joincondtion = "or";
				keyvalue=lastvalue.pop();
				keyvalue.setOuterJoinCondition(joincondtion);
				duplicatmap.put(keyvalue.getKey(), keyvalue);
				
			}
			//split tokens
			String[] charparts = inner.split(token);
			if (token.contains("=")) {
				keyvalue.setKey(charparts[0].trim());
				keyvalue.setInnderJoinCOndition("=");
				keyvalue.setValue(charparts[1].trim());
				lastvalue.push(keyvalue);
			} else if (token.contains(">")) {
				keyvalue.setKey(charparts[0].trim());
				keyvalue.setInnderJoinCOndition(">");
				keyvalue.setValue(charparts[1].trim());
				lastvalue.push(keyvalue);
			} 
			//for last tokens
			if (!toknes.hasMoreTokens()) {
				keyvalue.setOuterJoinCondition(joincondtion);
				duplicatmap.put(keyvalue.getKey(), keyvalue);
			}

		}
		System.out.println(duplicatmap);
	}

}
