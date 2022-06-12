package com.footballstore.servicios;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;

import com.footballstore.modelo.JwtResponse;
import com.footballstore.modelo.LoginRequest;
import com.footballstore.modelo.SignupRequest;
import com.footballstore.modelo.User;

public interface UserService {

	Optional<User> findById(Long id);

	Optional<User> findByUsername(String username);

	List<User> findAll();

	User save(User usuario);

	boolean existsByEmail(String email);

	boolean existsByUsername(String username);

	User registerUser(SignupRequest signupRequest);

	JwtResponse doLogin(Authentication authentication);

	void doLogout(HttpServletRequest request, HttpServletResponse response);

	boolean registerUpdate(LoginRequest loginRequest, HttpServletRequest request);



}
