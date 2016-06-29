package com.crm.logicq.model.alert;

public interface AlertConstants {

		public static final String GET_ALERT_TEMPLATE_BY_REASON_ID = "GET_ALERT_TEMPLATE_BY_REASON_ID";
		public static final String GET_ALERT_TEMPLATE_BY_REASON_ID_QRY = "from AlertTemplate where reasonId = :reasonId";
		public static final String GET_ALERT_TEMPLATE_DETAILS_BY_TEMPLATE_ID = "GET_ALERT_TEMPLATE_DETAILS_BY_TEMPLATE_ID";
		public static final String GET_ALERT_TEMPLATE_DETAILS_BY_TEMPLATE_ID_QRY = "from AlertTemplateDetails where templateId = :templateId";
		public static final String GET_ALERT_BY_REASON_ID = "GET_ALERT_BY_REASON_ID";
		public static final String GET_ALERT_BY_REASON_QRY = "from Alert where reasonId = :reasonId";
	
}
