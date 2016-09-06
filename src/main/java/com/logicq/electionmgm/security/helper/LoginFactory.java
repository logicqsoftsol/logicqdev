package com.logicq.electionmgm.security.helper;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.logicq.electionmgm.model.login.Authority;
import com.logicq.electionmgm.model.login.Login;
import com.logicq.electionmgm.ui.security.LoginVO;

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
                user.getEnabled(),
                user.getLastPasswordResetDate()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) {
        return null;//authorities.stream()
//                .map(authority -> new SimpleGrantedAuthority(authority.getName().name()))
//                .collect(Collectors.toList());
    }
}
