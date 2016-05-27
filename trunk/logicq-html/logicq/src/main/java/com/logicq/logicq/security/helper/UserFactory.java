package com.logicq.logicq.security.helper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.logicq.logicq.model.security.Authority;
import com.logicq.logicq.model.security.LoginUser;
import com.logicq.logicq.ui.security.LoginUserVO;

public final class UserFactory {

    private UserFactory() {
    }

    public static LoginUserVO create(LoginUser user) {
        return new LoginUserVO(
                user.getId(),
                user.getUsername(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail(),
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
