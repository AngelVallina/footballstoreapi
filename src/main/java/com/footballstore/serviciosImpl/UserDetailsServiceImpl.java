package com.footballstore.serviciosImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.footballstore.modelo.User;
import com.footballstore.modelo.UserDetailsImpl;
import com.footballstore.repositorio.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
		
	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("El usuario : " + username + " no ha sido encontrado."));
		return UserDetailsImpl.build(user);
	}
	
}