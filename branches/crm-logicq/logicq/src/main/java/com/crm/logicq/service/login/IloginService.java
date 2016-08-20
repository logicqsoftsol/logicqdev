package com.crm.logicq.service.login;

import java.util.List;

import com.crm.logicq.ui.security.LoginVO;

public interface IloginService {
	
	List<LoginVO> loadloginUser();

}
