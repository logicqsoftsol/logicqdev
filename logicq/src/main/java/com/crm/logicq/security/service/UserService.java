package com.crm.logicq.security.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.StringUtils;

import com.crm.logicq.model.login.Authority;
import com.crm.logicq.model.login.AuthorityName;
import com.crm.logicq.model.login.Login;
import com.crm.logicq.security.helper.LoginFactory;
import com.crm.logicq.ui.security.LoginVO;

public class UserService implements UserDetailsService {

    private final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();
    private static  HashMap<String, LoginVO> userMap = new HashMap<String, LoginVO>();

	public final LoginVO loadUserByUsername(String username) throws UsernameNotFoundException {
		return userMap.get(username);
	}
    
	public LoginVO checkUserDetails(String username, String password) {
		LoginVO uservo = loadUserByUsername(username);
		//testing need to remove this code
		Login login=new Login();
		login.setEmail("test@gmail.com");
		login.setMobilenumber("7057014118");
		//login.setCreatetime(new Date());
		List<Authority> authorities =new ArrayList<Authority>();
		Authority auth=new Authority();
		auth.setId(new Long(1));
		auth.setName(AuthorityName.ROLE_ADMIN);
		authorities.add(auth);
		login.setAuthorities(authorities);
		login.setUsername("Admin");
		login.setEnabled(Boolean.TRUE);
		login.setPassword(new String(password));
		login.setLastPasswordResetDate(new Date());
		uservo=LoginFactory.create(login);
		if (null == uservo) {
			throw new UsernameNotFoundException("user not found");
		} else{
			if (!StringUtils.isEmpty(password)) {
				if (!uservo.getPassword().equals(password)) {
					throw new UsernameNotFoundException("user not found");
				}
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
    
    
    public static HashMap<String, LoginVO> getUserMap() {
		return userMap;
	}

	public static void setUserMap(HashMap<String, LoginVO> userMap) {
		UserService.userMap = userMap;
	}
}
