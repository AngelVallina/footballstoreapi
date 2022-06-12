package com.footballstore.modelo;

import javax.validation.constraints.*;

public class RegisterRequestVO{
	
	@NotBlank
	private String nombreUsuario;
	@Email
	@NotBlank
	private String email;
	@NotBlank
	private String password;
	private String direccion;
	private String nombre;
	private String telefono;
	private String cp;
	private String provincia;
	private String notas;
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getDireccion() {
		return direccion;
	}
	public String getNombre() {
		return nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public String getCp() {
		return cp;
	}
	public String getNotas() {
		return notas;
	}
	public String getProvincia() {
		return provincia;
	}
	
}