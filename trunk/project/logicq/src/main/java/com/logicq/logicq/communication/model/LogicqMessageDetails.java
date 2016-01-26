package com.logicq.logicq.communication.model;

public class LogicqMessageDetails {
	
	private String messageid;
	
	private String messageheader;
	
	private String messagefooter;
	
	private String messagecontent;
	
	private String senderid;
	
	private String reciverid;
	
	private SendingType sendingtype;
	
	private Stastus sendingStastus;
	
	public String getMessaggeid() {
		return messageid;
	}

	public void setMessaggeid(String messaggeid) {
		this.messageid = messaggeid;
	}

	public String getMessageheader() {
		return messageheader;
	}

	public void setMessageheader(String messageheader) {
		this.messageheader = messageheader;
	}

	public String getMessagefooter() {
		return messagefooter;
	}

	public void setMessagefooter(String messagefooter) {
		this.messagefooter = messagefooter;
	}

	public String getMessagecontent() {
		return messagecontent;
	}

	public void setMessagecontent(String messagecontent) {
		this.messagecontent = messagecontent;
	}

	public String getSenderid() {
		return senderid;
	}

	public void setSenderid(String senderid) {
		this.senderid = senderid;
	}

	public String getReciverid() {
		return reciverid;
	}

	public void setReciverid(String reciverid) {
		this.reciverid = reciverid;
	}

	public SendingType getSendingtype() {
		return sendingtype;
	}

	public void setSendingtype(SendingType sendingtype) {
		this.sendingtype = sendingtype;
	}

	public Stastus getSendingStastus() {
		return sendingStastus;
	}

	public void setSendingStastus(Stastus sendingStastus) {
		this.sendingStastus = sendingStastus;
	}


}
