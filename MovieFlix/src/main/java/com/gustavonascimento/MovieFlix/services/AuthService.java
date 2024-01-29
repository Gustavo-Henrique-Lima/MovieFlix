package com.gustavonascimento.MovieFlix.services;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gustavonascimento.MovieFlix.entities.User;
import com.gustavonascimento.MovieFlix.repositories.UserRepository;
import com.gustavonascimento.MovieFlix.services.exceptions.UnauthorizedException;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;
	
	private static Logger logger = org.slf4j.LoggerFactory.getLogger(AuthService.class);

	@Transactional(readOnly = true)
	public User authenticated() {
		try {
			JwtAuthenticationToken jwtToken = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
			Jwt jwt = (Jwt) jwtToken.getPrincipal();
			String username = jwt.getClaimAsString("username");
			logger.info(username);
			return userRepository.findByEmail(username);
		} catch (Exception e) {
			throw new UnauthorizedException("Usuário inválido");
		}
	}

	public User getCurrentUser() {
		User user = authenticated();
		return user;
	}

}