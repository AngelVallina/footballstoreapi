package com.footballstore.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.footballstore.core.exceptions.ResourceNotFoundException;
import com.footballstore.core.utils.MessageResponse;
import com.footballstore.core.utils.Utils;
import com.footballstore.modelo.LoginRequest;
import com.footballstore.modelo.SignupRequest;
import com.footballstore.modelo.User;
import com.footballstore.servicios.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class UserAuthController {
	
	private Logger logger = LoggerFactory.getLogger(UserAuthController.class);
	
	@Autowired
	private UserService userService;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	private Utils utils;
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest, Errors errors) {
		
		if (errors.hasErrors()) {
			return ResponseEntity.badRequest().body(new MessageResponse(new Date(), utils.mensajesError(errors), HttpStatus.BAD_REQUEST.value()));
		}
			
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		return ResponseEntity.ok(userService.doLogin(authentication));
	}
	
	@DeleteMapping(value = "/logout")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<?> logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		userService.doLogout(request, response);
		return ResponseEntity.ok(new MessageResponse(new Date(), "User logout...", HttpStatus.OK.value()));
	}
	
	@PostMapping("/registro")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest, Errors errors) {
		
		if (errors.hasErrors()) {
			return ResponseEntity.badRequest().body(new MessageResponse(new Date(), utils.mensajesError(errors), HttpStatus.BAD_REQUEST.value()));
		}
		
		if (userService.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse(new Date(), "Error: El email esta en uso", HttpStatus.BAD_REQUEST.value()));
		}
		
		User usuario = userService.registerUser(signUpRequest);
		logger.info("Registro de usuario {}", usuario.getEmail());
		return ResponseEntity.ok(new MessageResponse(new Date(), "Usuario registrado", HttpStatus.OK.value()));
	}
	
	@GetMapping(value = "/usuarios/listarUsuarios")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> listarUsuarios() {
		List<User> usuarios = userService.findAll();
		logger.info("Usuarios recuperadas: {}", usuarios.size());
		
		return ResponseEntity.ok(usuarios);
	}
	
	@PostMapping(value = "/usuarios/getUsuario")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<?> getUsuario(@RequestBody Map<String, String> payload) {
		String username = payload.get("username");
		User usuario = userService.findByUsername(username).get();
		logger.info("Usuario recuperado: {}", usuario.getEmail());
		
		return ResponseEntity.ok(usuario);
	}
	
	@GetMapping(value = "/usuarios/{id}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public ResponseEntity<?> getUsuarioById(@PathVariable Long id) throws ResourceNotFoundException{
		User usuario = userService.findById(id).orElseThrow(() -> new ResourceNotFoundException("No existe un usuario con el id: " + id));
		return ResponseEntity.ok(usuario);
	}

	
}