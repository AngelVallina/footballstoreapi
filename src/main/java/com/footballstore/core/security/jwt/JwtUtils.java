package com.footballstore.core.security.jwt;

import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.footballstore.core.utils.ConstantesComunes;
import com.footballstore.modelo.UserDetailsImpl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

	@Value("${app.base.jwtSecret}")
	private String jwtSecret;

	@Value("${app.base.jwtExpirationMs}")
	private int jwtExpirationMs;
	
	
	/*
	 * Genera un JWT con el username
	 */
	public String generateJwtToken(Authentication authentication) {

		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
		
		Claims claims = Jwts.claims().setSubject(userPrincipal.getUsername());
		Collection<? extends GrantedAuthority> roles = userPrincipal.getAuthorities();
		//claims.put("auth", roles.stream().map(s -> new SimpleGrantedAuthority(s.getAuthority())).filter(Objects::nonNull).collect(Collectors.toList()));
		
		Date expireDate = new Date((new Date()).getTime() + jwtExpirationMs);
		
		logger.info("Token creado para {} valido hasta {}", userPrincipal.getUsername(), expireDate);
		
		return Jwts.builder()
				.setClaims(claims)
				.setIssuedAt(new Date())
				.setExpiration(expireDate)
				.signWith(SignatureAlgorithm.HS512, jwtSecret)
				.compact();
	}
	
	/*
	 * Obtiene el username de un JWT
	 */
	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}

	/*
	 * Valida un JWT
	 */
	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
			logger.error("JWT signature no valida: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			logger.error("JWT token no valido: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("JWT token caducado: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token no soportado: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims vacio: {}", e.getMessage());
		} catch (NullPointerException e) {
			logger.error("JWT claims vacio: {}", e.getMessage());
		}
		return false;
	}
	
	public String parseJwt(HttpServletRequest request) {
		String headerAuth = request.getHeader(HttpHeaders.AUTHORIZATION);
		if (StringUtils.hasText(headerAuth) && headerAuth.startsWith(ConstantesComunes.BEARER)) {
			return headerAuth.substring(7, headerAuth.length());
		}
		return null;
	}
	
}