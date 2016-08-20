package com.crm.logicq.security.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.crm.logicq.model.login.Authority;
import com.crm.logicq.model.login.Login;
import com.crm.logicq.ui.security.LoginVO;

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
