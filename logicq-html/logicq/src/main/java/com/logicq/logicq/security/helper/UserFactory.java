package com.logicq.logicq.security.helper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.logicq.logicq.model.login.Authority;
import com.logicq.logicq.model.login.Login;
import com.logicq.logicq.ui.login.vo.LoginVO;

public final class UserFactory {

    private UserFactory() {
    }

    public static LoginVO create(Login user) {
        return new LoginVO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPhone(),
                user.getPassword(),
                mapToGrantedAuthorities(user.getAuthorities()),
                user.getEnabled(),
                user.getLastPasswordResetDate()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName().name()))
                .collect(Collectors.toList());
    }
}
