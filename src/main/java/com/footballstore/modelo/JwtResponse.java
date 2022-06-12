package com.footballstore.modelo;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private User usuario;
	

	public JwtResponse() {
	}

	public JwtResponse(String accessToken, User usuario) {
		this.token = accessToken;
		this.usuario = usuario;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
	
}