package com.footballstore.modelo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.footballstore.core.utils.ConstantesComunes;

public class SignupRequest {

	@NotBlank
	@Email(regexp = ConstantesComunes.EMAIL_REGEXP)
	private String email;
	
	@NotBlank
	private String password;
	
	@NotBlank
	private String nombre;
	
	@NotBlank
	private String apellidos;
	
	public SignupRequest() {
		super();
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

}
