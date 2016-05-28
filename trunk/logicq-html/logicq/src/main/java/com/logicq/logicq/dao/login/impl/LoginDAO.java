package com.logicq.logicq.dao.login.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.logicq.logicq.common.criteriamanager.DataFetchType;
import com.logicq.logicq.common.criteriamanager.LogicqCriteriaHandler;
import com.logicq.logicq.common.criteriamanager.LogicqRestrictions;
import com.logicq.logicq.dao.AbstractDAO;
import com.logicq.logicq.dao.login.ILoginDAO;
import com.logicq.logicq.dao.login.LoginFilter;
import com.logicq.logicq.model.login.Login;
import com.logicq.logicq.model.security.Authority;
import com.logicq.logicq.model.security.AuthorityName;
import com.logicq.logicq.model.security.LoginUser;

@Repository
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
		save(login);
	}

	@Override
	public LoginUser fethchUser(String username, String password) {
		LoginUser userentity = new LoginUser();
		if ("Test".equalsIgnoreCase(username)) {
			userentity.setUsername(username);
			userentity.setFirstname("Test");
			userentity.setEmail("test@gmail.com");
			userentity.setEnabled(Boolean.TRUE);
			userentity.setLastname("test");
			userentity.setLastPasswordResetDate(new Date());
			List<Authority> authorities = new ArrayList<Authority>();
			Authority auth = new Authority();
			auth.setId(new Long(123));
			auth.setName(AuthorityName.ROLE_ADMIN);
			authorities.add(auth);
			userentity.setAuthorities(authorities);
		}
		return userentity;
}
}
