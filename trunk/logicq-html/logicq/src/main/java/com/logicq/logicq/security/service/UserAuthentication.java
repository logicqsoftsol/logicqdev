package com.logicq.logicq.security.service;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import com.logicq.logicq.ui.login.vo.LoginVO;
import com.logicq.logicq.ui.security.LoginUserVO;

public class UserAuthentication implements Authentication {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3893087502431740099L;
	private final LoginVO user;
    private boolean authenticated = true;

    public UserAuthentication(LoginVO user) {
        this.user = user;
    }

  
    public String getName() {
        return user.getUsername();
    }

  
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getAuthorities();
    }


    public Object getCredentials() {
        return user.getPassword();
    }

    public LoginVO getDetails() {
        return user;
    }

 
    public Object getPrincipal() {
        return user.getUsername();
    }

    
    public boolean isAuthenticated() {
        return authenticated;
    }

   
    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }
}
