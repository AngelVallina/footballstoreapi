package com.footballstore.serviciosImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.footballstore.core.security.jwt.JwtUtils;
import com.footballstore.modelo.JwtResponse;
import com.footballstore.modelo.LoginRequest;
import com.footballstore.modelo.Role;
import com.footballstore.modelo.RoleEnum;
import com.footballstore.modelo.SignupRequest;
import com.footballstore.modelo.User;
import com.footballstore.modelo.UserDetailsImpl;
import com.footballstore.repositorio.RoleRepository;
import com.footballstore.repositorio.UserRepository;
import com.footballstore.servicios.UserService;

@Service
public class UserServiceImpl implements UserService  {

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Override
	public Optional<User> findById(Long id){
		return userRepository.findById(id);
	}

	@Override
	public Optional<User> findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	@Override
	public User save(User usuario){
		return userRepository.save(usuario);
	}
	

	@Override
	public boolean existsByEmail(String email){
		return userRepository.existsByEmail(email);
	}
	
	@Override
	public boolean existsByUsername(String username) {
		return userRepository.existsByUsername(username);
	}
	
	// Registra un usuario
	@Override
	public User registerUser(SignupRequest signupRequest) {
		// Crear una nueva cuenta de usuario
		User user = new User(signupRequest.getEmail(), 
				 signupRequest.getEmail(),
				 encoder.encode(signupRequest.getPassword()),
				 signupRequest.getNombre(),
				 signupRequest.getApellidos()
				 );
		
		Set<Role> roles = new HashSet<>();
		Role userRole = roleRepository.findByName(RoleEnum.ROLE_USER)
				.orElseThrow(() -> new RuntimeException("Error: Rol no encontrado."));
		roles.add(userRole);
		
		user.setRoles(roles);

		logger.info("registerUser: Usuario {} registrado.", signupRequest.getEmail());
		return this.save(user);
	}
		
	@Override
	public JwtResponse doLogin(Authentication authentication) {
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		
		User usuario = this.findById(userDetails.getId()).get();
		//usuario.setLastLogin(new Date());
		this.save(usuario);
		
		JwtResponse jwtResponse = new JwtResponse(jwt, usuario);
		
		return jwtResponse;
	}
		
	@Override
	public void doLogout(HttpServletRequest request, HttpServletResponse response) {
		
		String jwt = jwtUtils.parseJwt(request);
		SecurityContextHolder.clearContext();
		HttpSession session= request.getSession(false);
		if(session != null) {
			session.invalidate();
		}
		if (null != request.getCookies()) {
			for(Cookie cookie : request.getCookies()) {
				cookie.setMaxAge(0);
			}
		}
		
		response.addHeader(HttpHeaders.AUTHORIZATION, "");
		logger.info("Logout de usuario. Invalidando token {}", jwt);
	}
	
	@Override
	public boolean registerUpdate(LoginRequest loginRequest, HttpServletRequest request) {
		boolean updated = Boolean.TRUE;
		if(existsByUsername(loginRequest.getEmail())) {
			User usuario = findByUsername(loginRequest.getEmail()).get();
			usuario.setPassword(encoder.encode(loginRequest.getPassword()));
			save(usuario);
			logger.info("Password modificado para {}", loginRequest.getEmail());
			
		} else {
			// El usuario no existe
			updated = Boolean.FALSE;
			logger.info("El usuario no existe. Imposible modificar password {}", loginRequest.getEmail());
		}
		
		return updated;
	}
	
	

}
