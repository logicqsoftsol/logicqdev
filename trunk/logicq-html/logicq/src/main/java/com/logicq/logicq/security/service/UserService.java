package com.logicq.logicq.security.service;

import java.util.HashMap;

import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.logicq.logicq.service.login.impl.LoginService;
import com.logicq.logicq.ui.login.vo.LoginVO;

public class UserService implements UserDetailsService {

    private final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();
    private static  HashMap<String, LoginVO> userMap = new HashMap<String, LoginVO>();

	public final LoginVO loadUserByUsername(String username) throws UsernameNotFoundException {
		return userMap.get(username);
	}
    
	public LoginVO checkUserDetails(String username, String password) {
		LoginVO uservo = loadUserByUsername(username);
		if (null == uservo) {
			throw new UsernameNotFoundException("user not found");
		}
		detailsChecker.check(uservo);
		return uservo;
	}

    public void addUser(LoginVO user) {
        userMap.put(user.getUsername(), user);
    }
    
    
    public static HashMap<String, LoginVO> getUserMap() {
		return userMap;
	}

	public static void setUserMap(HashMap<String, LoginVO> userMap) {
		UserService.userMap = userMap;
	}
}
