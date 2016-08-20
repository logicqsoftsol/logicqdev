package com.crm.logicq.security.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import com.crm.logicq.security.helper.TokenHandler;
import com.crm.logicq.ui.security.LoginVO;

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

    public void addAuthentication(HttpServletResponse response, UsernamePasswordAuthenticationToken authentication) {
       if(null!=authentication && null!=authentication.getCredentials()){
    	response.addHeader(AUTH_HEADER_NAME, String.valueOf(authentication.getCredentials()));
       }
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
