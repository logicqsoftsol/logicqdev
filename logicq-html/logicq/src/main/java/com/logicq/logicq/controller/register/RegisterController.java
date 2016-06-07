package com.logicq.logicq.controller.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.logicq.logicq.security.helper.TokenHandler;
import com.logicq.logicq.security.service.TokenAuthenticationConstant;
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
		 HttpHeaders headers = new HttpHeaders();
		if(null!=bsicuservo){
	       uservo = userservice.createNewUser(bsicuservo);
	       String mobtoken=TokenHandler.createTokenForOTP(uservo.getPhone());
		headers.add("MOB_TOKEN", mobtoken);
		}else{
			return new ResponseEntity<UserVO>(uservo, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<UserVO>(uservo, headers,HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/validateOTP/{token}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserVO> validateOTP(@RequestBody String otp,@PathVariable String token) {
		UserVO uservo=null;
		if(!StringUtils.isEmpty(otp)){
			String mobilenumber=TokenHandler.parseMobileFromToken(token);
			//check for otp with mobile number
			//fetch basic user details
			//redirect to login page automatically 
			//redirect to index.html automatically with login details
		}else{
			return new ResponseEntity<UserVO>(uservo, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<UserVO>(uservo, HttpStatus.OK);
	}
}
