package com.crm.logicq.constant;

public enum SMSType {

	 ATTENDANCE("work"), SUMMERVACATION("home"),EMERGENCY("emergency");

		private String smsType;

		SMSType(String contactType) {
			this.smsType = contactType;
		}

		public String getContactType() {

			return smsType;
		}
	
}
