package com.logicq.mlm.common.factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.logicq.mlm.model.login.Authority;
import com.logicq.mlm.model.login.Login;
import com.logicq.mlm.vo.LoginVO;

public final class LoginFactory {

    private LoginFactory() {
    }

    public static LoginVO create(Login user) {
        return new LoginVO(
                user.getUsername(),
                user.getEmail(),
                user.getMobilenumber(),
                user.getPassword(),
                mapToGrantedAuthorities(user.getAuthorities()),
                user.getEnabled()
        );
    }

    
    public static Login createLoginDetails(LoginVO user) {
    	Login logindetails=	new Login();
    	logindetails.setEmail(user.getEmail());
    	logindetails.setMobilenumber(user.getMobilenumber());
    	logindetails.setUsername(user.getUsername());
    	return logindetails;
    }


    
    
	private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) {
		List<GrantedAuthority> grantedauth = new ArrayList<GrantedAuthority>();
		for (Authority auth : authorities) {
			GrantedAuthority grandauth = new SimpleGrantedAuthority(auth.getName());
			grantedauth.add(grandauth);
		}
//        return authorities.stream()
//                .map(authority -> new SimpleGrantedAuthority(authority.getName().name()))
//                .collect(Collectors.toList());
		return grantedauth;
    }
}
