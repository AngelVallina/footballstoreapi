package com.footballstore.core;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import com.footballstore.servicios.AuthService;

public class CustomFilter extends OncePerRequestFilter {
	
	private final Logger log = LogManager.getLogger(getClass());

	private static final String AUTH_HEADER_PARAMETER_AUTHERIZATION = "Authorization";

	@Autowired
	private AuthService authService;
	

    private static final String[] WHITELIST = {
    		"/users/login",
    		"/users/register",
      		"/productos/getAll",
    		"/productos/findByText",
    		"/productos/findById",
    		"/productos/findByTipo",
    		"/opiniones/getByIdProducto",
    		"/opiniones/getValoracionMedia"
    };
    
    //get con path variable, van por url
    //post con params, no van en la url
    
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		List<String> listaBlanca = Arrays.asList(WHITELIST);
		
		if(!listaBlanca.contains(request.getServletPath())) {
			Boolean isValidBasicAuthRequest = false;
			
			// Grab basic header value from request header object.
			String basicAuthHeaderValue = request.getHeader(AUTH_HEADER_PARAMETER_AUTHERIZATION);
		
			// Process basic authentication
			isValidBasicAuthRequest = authService.validateBasicAuthentication(basicAuthHeaderValue);
		
			// If this is invalid request, then set the status as UNAUTHORIZED.
			if (!isValidBasicAuthRequest) {
				response.setStatus(HttpStatus.UNAUTHORIZED.value());
				return;
			}
		}
    	
		//TODO spring security
		// SpringUserDetails userDetails = getUsuarioPorUsername
		// UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities())
		// SecurityContextHolder.getContext().setAuthentication( authentication);
		
		filterChain.doFilter(request, response);
		
	}

}