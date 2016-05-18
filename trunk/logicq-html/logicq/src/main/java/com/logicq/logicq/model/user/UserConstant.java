package com.logicq.logicq.model.user;

public interface UserConstant {

	public static final String USERID = "userid";
	public static final String GET_USER = "GET_USER";
	public static final String GET_USER_QUERY = "from User u where u.id =:userId";
	public static final String GET_MOBILE_NO = "GET_MOBILE_NO";
	public static final String GET_MOBILE_NO_QRY = "from User u where u.mobileNo =:mobileNo";
	public static final String GET_EMAIL_ID = "GET_EMAIL_ID";
	public static final String GET_EMAIL_ID_QRY = "from User u where u.emailId =:emailId";
	public static final String GET_USERS_NEAR_ADDRESS = "GET_USERS_NEAR_ADDRESS";
	public static final String GET_USERS_NEAR_ADDRESS_QRY = "from User u where u.id = (select a.user.id from Address a where a.city = :city)";
	public static final String GET_PARTICULAR_USERS_NEAR_ADDRESS = "GET_PARTICULAR_USERS_NEAR_ADDRESS";
	public static final String GET_PARTICULAR_USERS_NEAR_ADDRESS_QRY = "from User u where u.entityType = :entityType and u.id = (select a.user.id from Address a where a.city = :city)";
}
