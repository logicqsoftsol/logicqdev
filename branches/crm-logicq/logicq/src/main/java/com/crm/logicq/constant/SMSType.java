package com.crm.logicq.constant;

public enum SMSType {

	 ATTENDANCE("attendance"), SUMMERVACATION("summerVacation"),EMERGENCY("emergency");

		private String smsType;

		SMSType(String contactType) {
			this.smsType = contactType;
		}

		public String getContactType() {

			return smsType;
		}
	
}
