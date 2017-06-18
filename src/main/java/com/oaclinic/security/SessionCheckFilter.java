package com.oaclinic.security;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.oaclinic.session.SessionService;

@Component  
@Order(Ordered.HIGHEST_PRECEDENCE) 
@WebFilter(urlPatterns = {"/*"}, description = "Session Checker Filter")
public class SessionCheckFilter implements Filter {
	
	private static final Logger LOGGER = Logger.getLogger(SessionCheckFilter.class);
	
	private static final String LOGIN_REQUEST = "/login/";
	
	private static final String HEADER_KEY_SESSION = "session-id";
	
	private static final String HEADER_KEY_ROOT_USER = "root-user";
	
	private static final String ROOT_PASSWORD = "root-psk";
	
	private static final String HEADER_AUTH = "Authorization";
	
	private static final String ROOT_AUTH = "Basic cm9vdC11c2VyOnJvb3QtcHNr";
	
	@Autowired
	private SessionService sessionService;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {		
		LOGGER.info("Filter initialized");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;        
        
		if(loginRequest(httpRequest) || rootUser(httpRequest) || validSession(httpRequest)) {
        	chain.doFilter(request, response);
        } else {
        	throw new SecurityException("Illegal access!");
        }
	}

	private boolean validSession(HttpServletRequest httpRequest) {
		String sessionId = httpRequest.getHeader(HEADER_KEY_SESSION);
		if(Objects.isNull(sessionId)) {
			return Boolean.FALSE;
		}
		sessionService.validate(sessionId);
		return Boolean.TRUE;
	}

	private boolean loginRequest(HttpServletRequest httpRequest) {
		return httpRequest.getRequestURI().contains(LOGIN_REQUEST);
	}

	private Boolean rootUser(HttpServletRequest httpRequest) {
		String rootPassword = httpRequest.getHeader(HEADER_KEY_ROOT_USER);
		String rootAuth = httpRequest.getHeader(HEADER_AUTH);
		return (Objects.nonNull(rootPassword) && ROOT_PASSWORD.equals(rootPassword))
				|| (Objects.nonNull(rootAuth) && ROOT_AUTH.equals(rootAuth));
	}

	@Override
	public void destroy() {
		LOGGER.info("Filter destroyed");
	}  
	
}