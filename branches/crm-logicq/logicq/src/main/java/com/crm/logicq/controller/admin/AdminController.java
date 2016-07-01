package com.crm.logicq.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crm.logicq.model.login.Authority;
import com.crm.logicq.model.login.AuthorityName;
import com.crm.logicq.model.login.Login;
import com.crm.logicq.security.helper.LoginFactory;
import com.crm.logicq.ui.security.LoginVO;


@RestController
@RequestMapping("/admin")
public class AdminController {




	@RequestMapping(value = "/loadDefaultUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LoginVO> login() {
		//testing need to remove this code
		Login login=new Login();
		login.setEmail("test@gmail.com");
		login.setMobilenumber("75014118");
		List<Authority> authorities =new ArrayList<Authority>();
		Authority auth=new Authority();
		auth.setId(new Long(1100));
		auth.setName(AuthorityName.ROLE_ADMIN);
		authorities.add(auth);
		login.setAuthorities(authorities);
		login.setUsername("Admin");
		login.setEnabled(Boolean.TRUE);
		LoginVO loginvo=LoginFactory.create(login);
		return new ResponseEntity<LoginVO>(loginvo, HttpStatus.OK);
	}
	



}
