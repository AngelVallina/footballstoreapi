package com.footballstore.core.security.jwt;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.footballstore.core.exceptions.ErrorDetails;

@Component
public class AuthEntryPointJwt implements AuthenticationEntryPoint {

	private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class);

	/*
	 * Este método se invoca cada vez que un usuario sin autenticar hace una petición a un recurso HTTP
	 * securizado y se lanza una AuthenticationException.
	 */
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
		AuthenticationException authException) throws IOException, ServletException {
		logger.error("Unauthorized error: {}", authException.getMessage() + " -> " + request.getRequestURL() + " -> " + request.getRemoteAddr());
		ErrorDetails messageResponse = new ErrorDetails(new Date(), authException.getMessage(), request.getRequestURI(), HttpStatus.UNAUTHORIZED.value());
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		OutputStream out = response.getOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		mapper.writerWithDefaultPrettyPrinter().writeValue(out, messageResponse);
		out.flush();
	}

}