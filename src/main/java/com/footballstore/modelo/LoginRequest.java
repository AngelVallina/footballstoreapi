package com.footballstore.modelo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.footballstore.core.utils.ConstantesComunes;

public class LoginRequest {
	
	@NotBlank
	@Email(regexp = ConstantesComunes.EMAIL_REGEXP)
	private String email;

	@NotBlank
	private String password;

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}
	
	
}
