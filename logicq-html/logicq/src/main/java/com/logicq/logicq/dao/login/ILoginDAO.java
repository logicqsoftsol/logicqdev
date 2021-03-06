package com.logicq.logicq.dao.login;

import java.util.List;

import com.logicq.logicq.model.login.Login;

/**
 * Login DAO Interface
 * 
 * @author SudhanshuL
 * @since 13 Dec 2015
 * @version 1.0.0
 */
public interface ILoginDAO {

	public List<Login> checkLoginUser(Login loginuser);

	public void insertLoginDetails(Login login);
	
	public Login fethchLoginUser(String username,String password);
	List<Login> load();
	
}
