package com.logicq.logicq.controller.login;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.logicq.logicq.ui.login.vo.LoginVO;
import com.logicq.logicq.ui.user.vo.UserVO;

@RestController
@RequestMapping("/app")
public class LoginController {
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserVO> getAllLocationOptioon(@RequestBody LoginVO login) {
		UserVO uservo=new UserVO();
		System.out.println(" login sucess ");
		return new ResponseEntity<UserVO>(uservo, HttpStatus.OK);
	}

}
