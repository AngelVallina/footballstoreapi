package com.footballstore.servicios;

public interface AuthService {

	/**
     * Validador de autenticacion basica
     *
     * @param basicAuthHeaderValue the base 64 encoded header value
     * @return the boolean
     */
	Boolean validateBasicAuthentication(String basicAuthHeaderValue);
}
