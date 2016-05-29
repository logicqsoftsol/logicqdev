package com.logicq.logicq.controller.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.logicq.logicq.service.user.IUserService;
import com.logicq.logicq.ui.user.vo.BasicUserVO;
import com.logicq.logicq.ui.user.vo.UserVO;

@RestController
@RequestMapping("/user")
public class RegisterController {

	@Autowired
	IUserService userservice;
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserVO> userRegister(@RequestBody BasicUserVO bsicuservo) {
		UserVO uservo=null;
		if(null!=bsicuservo){
	       uservo = userservice.createNewUser(bsicuservo);
		}else{
			return new ResponseEntity<UserVO>(uservo, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<UserVO>(uservo, HttpStatus.OK);
	}
}
