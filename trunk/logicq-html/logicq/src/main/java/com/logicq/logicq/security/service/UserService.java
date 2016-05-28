package com.logicq.logicq.security.service;

import java.util.HashMap;

import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.logicq.logicq.service.login.impl.LoginService;
import com.logicq.logicq.ui.security.LoginUserVO;

public class UserService implements UserDetailsService {

    private final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();
    private final HashMap<String, LoginUserVO> userMap = new HashMap<String, LoginUserVO>();
   
    
    public final LoginUserVO loadUserByUsername(String username) throws UsernameNotFoundException {
		return userMap.get(username);
	}
    
	public LoginUserVO checkUserDetails(String username, String password) {
		LoginService loginservice = new LoginService();
		LoginUserVO uservo = loadUserByUsername(username);
		if (null == uservo) {
			uservo = loginservice.checkLoginUser(username, password);
			if (null != uservo) {
				addUser(uservo);
			} else {
				if (uservo == null) {
					throw new UsernameNotFoundException("user not found");
				}

			}
		}
		detailsChecker.check(uservo);
		return uservo;
	}

    private void addUser(LoginUserVO user) {
        userMap.put(user.getUsername(), user);
    }
}
