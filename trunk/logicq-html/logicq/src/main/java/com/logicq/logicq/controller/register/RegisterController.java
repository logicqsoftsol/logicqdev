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

import com.logicq.logicq.constant.CommunicationType;
import com.logicq.logicq.security.helper.TokenHandler;
import com.logicq.logicq.security.helper.UserFactory;
import com.logicq.logicq.security.service.TokenAuthenticationConstant;
import com.logicq.logicq.security.service.UserService;
import com.logicq.logicq.service.login.IloginService;
import com.logicq.logicq.service.login.impl.LoginService;
import com.logicq.logicq.service.user.IUserService;
import com.logicq.logicq.ui.login.vo.LoginVO;
import com.logicq.logicq.ui.user.vo.BasicUserVO;
import com.logicq.logicq.ui.user.vo.UserVO;

@RestController
@RequestMapping("/user")
public class RegisterController {

	@Autowired
	IUserService userservice;
	
	@Autowired
	IloginService loginService;
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BasicUserVO> userRegister(@RequestBody BasicUserVO bsicuservo) {
		 HttpHeaders headers = new HttpHeaders();
		if(null!=bsicuservo){
	       userservice.createNewUser(bsicuservo);
		}else{
			return new ResponseEntity<BasicUserVO>(bsicuservo, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<BasicUserVO>(bsicuservo, headers,HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/validateOTP/{otp}/{mobilenumber}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BasicUserVO> validateOTP(@PathVariable String otp ,@PathVariable String mobilenumber) {
		BasicUserVO basicuservo=new BasicUserVO();
		HttpHeaders headers = new HttpHeaders();
		if(!StringUtils.isEmpty(otp)){
			basicuservo.setPhone(mobilenumber);
			basicuservo.setMobileVerified("true");
			headers.add("redirect", "http://127.0.0.1:8090/logicq/assets/globals/views/login.html");
			//This added to load user in map but we need to change for this as 
			loginService.load();
		}else{
			headers.add("redirect", "http://127.0.0.1:8090/logicq/error.html");
			return new ResponseEntity<BasicUserVO>(basicuservo,headers, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<BasicUserVO>(basicuservo,headers, HttpStatus.OK);
	}
}
