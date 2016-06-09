package com.logicq.logicq.model.alert;

public interface AlertConstants {

	public static final String GET_ALERT_TEMPLATE_BY_SERVICE_ID = "GET_ALERT_TEMPLATE_BY_SERVICE_ID";
	public static final String GET_ALERT_TEMPLATE_BY_SERVICE_ID_QRY = "from AlertTemplate where serviceId = :serviceId";
	public static final String GET_ALERT_TEMPLATE_DETAILS_BY_TEMPLATE_ID = "GET_ALERT_TEMPLATE_DETAILS_BY_TEMPLATE_ID";
	public static final String GET_ALERT_TEMPLATE_DETAILS_BY_TEMPLATE_ID_QRY = "from AlertTemplateDetails where templateId = :templateId";
	public static final String GET_ALERT_BY_USER_ID = "GET_ALERT_BY_USER_ID";
	public static final String GET_ALERT_BY_USER_ID_QRY = "from Alert where userId = :userId";
}
