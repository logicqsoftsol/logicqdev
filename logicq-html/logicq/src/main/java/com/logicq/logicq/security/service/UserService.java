package com.logicq.logicq.security.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.logicq.logicq.model.security.Authority;
import com.logicq.logicq.model.security.AuthorityName;
import com.logicq.logicq.model.security.LoginUser;
import com.logicq.logicq.security.helper.UserFactory;
import com.logicq.logicq.ui.security.LoginUserVO;
import com.logicq.logicq.ui.user.vo.UserVO;

public class UserService implements UserDetailsService {

    private final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();
    private final HashMap<String, LoginUserVO> userMap = new HashMap<String, LoginUserVO>();

   
    public final LoginUserVO loadUserByUsername(String username) throws UsernameNotFoundException {
    	LoginUserVO user = userMap.get(username);
        if (user == null) {
        	if("Test".equalsIgnoreCase(username)){
        	LoginUser userentity = new LoginUser();
        	userentity.setUsername(username);
        	userentity.setFirstname("Test");
        	userentity.setEmail("test@gmail.com");
        	userentity.setEnabled(Boolean.TRUE);
        	userentity.setLastname("test");
        	userentity.setLastPasswordResetDate(new Date());
    		List<Authority> authorities = new ArrayList<Authority>();
    		Authority auth = new Authority();
    		auth.setId(new Long(123));
    		auth.setName(AuthorityName.ROLE_ADMIN);
    		authorities.add(auth);
    		userentity.setAuthorities(authorities);
    		user=UserFactory.create(userentity);
    		addUser(user);
        	}else{
        		throw new UsernameNotFoundException("user not found");
        	}
        }
        detailsChecker.check(user);
        return user;
    }

    public void addUser(LoginUserVO user) {
        userMap.put(user.getUsername(), user);
    }
}
