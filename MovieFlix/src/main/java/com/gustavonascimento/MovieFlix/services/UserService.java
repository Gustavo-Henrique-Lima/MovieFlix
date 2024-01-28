package com.gustavonascimento.MovieFlix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gustavonascimento.MovieFlix.entities.User;
import com.gustavonascimento.MovieFlix.entities.dto.UserDTO;
import com.gustavonascimento.MovieFlix.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private AuthService authService;

	@Transactional(readOnly = true)
	public UserDTO findCurrentUser() {
		User entity = authService.getCurrentUser();
		return new UserDTO(entity);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User entity = repository.findByEmail(username);
		if (entity == null) {
			throw new UsernameNotFoundException("Email não encontrado");
		}
		return entity;
	}
	
}