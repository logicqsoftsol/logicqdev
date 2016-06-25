package com.crm.logicq.security.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import com.crm.logicq.security.service.TokenAuthenticationConstant;
import com.crm.logicq.security.service.TokenAuthenticationService;
import com.crm.logicq.security.service.UserService;
import com.crm.logicq.ui.security.LoginVO;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 
 * @author SudhanshuLenka
 *
 */
public class RestAuthenticationFilter extends GenericFilterBean {
	private static final Logger LOGGER = Logger.getLogger(RestAuthenticationFilter.class);
	private final TokenAuthenticationService tokenAuthenticationService;
	private UserService userService;
	
    private PasswordEncoder passwordEncoder;
	
	public RestAuthenticationFilter(UserService userService, TokenAuthenticationService tokenAuthenticationService) {
		this.tokenAuthenticationService = tokenAuthenticationService;
		this.userService = userService;
		this.passwordEncoder=new BCryptPasswordEncoder();
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		try {

			final String token = httpRequest.getHeader(TokenAuthenticationConstant.AUTH_HEADER_NAME);
			if (!StringUtils.isEmpty(token)) {
				Authentication authentication = tokenAuthenticationService
						.getAuthentication((HttpServletRequest) request);
				SecurityContextHolder.getContext().setAuthentication(authentication);
				httpResponse.addHeader(TokenAuthenticationConstant.AUTH_HEADER_NAME, token);

			} else if (httpRequest.getRequestURI().endsWith("login")) {
				String username = (String) httpRequest.getHeader("userName");
				String password = (String) httpRequest.getHeader("password");
				if(!StringUtils.isEmpty(password) && !StringUtils.isEmpty(username)){
				UserDetails userDetails = userService.checkUserDetails(username, passwordEncoder.encode(password));
				final String authtoken = tokenAuthenticationService.getTokenHandler()
						.createTokenForUser((LoginVO) userDetails);
				if (!StringUtils.isEmpty(authtoken)) {
					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
							userDetails, authtoken, userDetails.getAuthorities());
					authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
				}
			}
			if (SecurityContextHolder.getContext().getAuthentication() != null
					&& SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
				filterChain.doFilter(request, response);
			}

		} catch (Exception ex) {
			LOGGER.error(" doFilter() : " + ex.getMessage(), ex);
			SetResponse(httpResponse, HttpStatus.UNAUTHORIZED, 403, ex);
		} finally {
			if (null != SecurityContextHolder.getContext()) {
				SecurityContextHolder.getContext().setAuthentication(null);
			}
		}

	}

	public void SetResponse(HttpServletResponse httpResponse, HttpStatus message, Integer responsecode, Exception ex)
			throws IOException {
		ObjectMapper jsonMapper = new ObjectMapper();
		httpResponse.setContentType("application/json;charset=UTF-8");
		((HttpServletResponse) httpResponse).setStatus(responsecode, message.toString());
		PrintWriter out = httpResponse.getWriter();
		out.print(jsonMapper.writeValueAsString(ex.getMessage()));
	}

}
