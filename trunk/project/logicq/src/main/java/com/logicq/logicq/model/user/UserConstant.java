
package com.logicq.logicq.model.user;

public interface UserConstant {

	public static final String USERID = "userid";
	public static final String GET_USER = "GET_USER";
	public static final String GET_USER_QUERY = "from User u where u.id =:userId";
	public static final String GET_MOBILE_NO = "GET_MOBILE_NO";
	public static final String GET_MOBILE_NO_QRY = "from User u where u.mobileNo =:mobileNo";
	public static final String GET_EMAIL_ID = "GET_EMAIL_ID";
	public static final String GET_EMAIL_ID_QRY = "from User u where u.emailId =:emailId";
}