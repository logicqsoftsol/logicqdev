package com.logicq.electionmgm.security.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;

import com.logicq.electionmgm.security.helper.TokenHandler;
import com.logicq.electionmgm.ui.security.LoginVO;

/**
 * 
 * @author SudhanshuLenka
 *
 */
public class TokenAuthenticationService implements  TokenAuthenticationConstant {
 

    private final TokenHandler tokenHandler;

  
	public TokenAuthenticationService(String secret, UserService userService) {
        tokenHandler = new TokenHandler(secret, userService);
    }

    public String addAuthentication(HttpServletResponse response, UserAuthentication authentication) {
        final LoginVO user = authentication.getDetails();
        String token = tokenHandler.createTokenForUser(user);
        response.addHeader(AUTH_HEADER_NAME, token);
        return token;
    }

    public Authentication getAuthentication(HttpServletRequest request) {
        final String token = request.getHeader(AUTH_HEADER_NAME);
        if (token != null) {
            final LoginVO user = tokenHandler.parseUserFromToken(token);
            if (user != null) {
                return new UserAuthentication(user);
            }
        }
        return null;
    }

	public TokenHandler getTokenHandler() {
		return tokenHandler;
	}
    

}
