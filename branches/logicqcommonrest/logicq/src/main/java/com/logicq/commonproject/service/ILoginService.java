package com.logicq.commonproject.service;

import java.util.List;

import com.logicq.commonproject.model.Login;


/**
 * NIHAR 15-Oct-2016 6:07:28 pm
 */

public interface ILoginService {
	 boolean validateUser(String username,String password);
}
