package com.crm.logicq.security.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;

import com.crm.logicq.ui.security.LoginVO;

public class UserService implements UserDetailsService {

    private final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();
    private static  Map<String, LoginVO> userMap = new ConcurrentHashMap<String, LoginVO>();
    private static final PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
	public final LoginVO loadUserByUsername(String username) throws UsernameNotFoundException {
		return userMap.get(username);
	}
    
	public LoginVO checkUserDetails(String username, String password) {
		LoginVO uservo = loadUserByUsername(username);
		if (null == uservo) {
			throw new UsernameNotFoundException("Check your User name and password");
		} else{
			if(StringUtils.isEmpty(uservo.getPassword())){
				throw new UsernameNotFoundException("Check your User name and password");
			}
			//very soon we we will change with admin token base login
		//    String encodedpassword=	passwordEncoder.encode(uservo.getPassword());
			if(!password.equals(uservo.getPassword())){
				throw new UsernameNotFoundException("Check your User name and password");
			}
			 detailsChecker.check(uservo);
		}
		return uservo;
	}

    public void addUser(LoginVO user) {
        userMap.put(user.getUsername(), user);
    }
    
    public static void removeUser(LoginVO user) {
        userMap.remove(user.getUsername());
    }
    
  
}
