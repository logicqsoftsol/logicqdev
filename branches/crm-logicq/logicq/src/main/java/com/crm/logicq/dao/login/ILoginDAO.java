package com.crm.logicq.dao.login;

import java.util.List;

import com.crm.logicq.model.login.Login;

/**
 * Login DAO Interface
 * 
 * @author SudhanshuL
 * @since 13 Dec 2015
 * @version 1.0.0
 */
public interface ILoginDAO {
	
	List<Login> loadloginUser();

	
}
