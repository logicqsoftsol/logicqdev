package com.logicq.logicq.dao.login.impl;

import java.util.ArrayList;
import java.util.List;

import com.logicq.logicq.common.criteriamanager.DataFetchType;
import com.logicq.logicq.common.criteriamanager.LogicqCriteriaHandler;
import com.logicq.logicq.common.criteriamanager.LogicqRestrictions;
import com.logicq.logicq.dao.AbstractDAO;
import com.logicq.logicq.dao.login.ILoginDAO;
import com.logicq.logicq.dao.login.LoginFilter;
import com.logicq.logicq.model.login.Login;

public class LoginDAO extends AbstractDAO<Login> implements ILoginDAO {

	@SuppressWarnings("unchecked")
	public List<Login> checkLoginUser(Login loginuser) {

		LogicqCriteriaHandler l_crietria = new LogicqCriteriaHandler();
		List<LoginFilter> l_criterialist = formFilterCriteria(loginuser);
		return (List<Login>) l_crietria.executeCriteriaDetails(l_criterialist, DataFetchType.LIST_RECORD, l_crietria.createCriteria(getSession(), Login.class));
	}

	private List<LoginFilter> formFilterCriteria(Login loginuser) {

		List<LoginFilter> l_criterialist = new ArrayList<LoginFilter>();
		LoginFilter emailcriteria = new LoginFilter();
		emailcriteria.setFieldname(Login.EMAIL);
		emailcriteria.setFieldvalue(loginuser.getEmail());
		emailcriteria.setRestricationtype(LogicqRestrictions.EQUALS);
		l_criterialist.add(emailcriteria);
		LoginFilter passwordcriteria = new LoginFilter();
		passwordcriteria.setFieldname(Login.PASSWORD);
		passwordcriteria.setFieldvalue(loginuser.getPassword());
		passwordcriteria.setRestricationtype(LogicqRestrictions.EQUALS);
		l_criterialist.add(passwordcriteria);
		/*LoginFilter l_criteria1 = new LoginFilter();
		l_criteria1.setFieldname(Login.PASSWORD);
		l_criteria1.setFieldvalue(loginuser.getPassword());
		l_criteria1.setRestricationtype(LogicqRestrictions.EQUALS);
		
		l_criterialist.add(l_criteria1);*/
		return l_criterialist;
	}
/**
 * 
 * 
 */
	public void insertLoginDetails(Login login) {
		save(login, getCurrentSession());
	}
}
