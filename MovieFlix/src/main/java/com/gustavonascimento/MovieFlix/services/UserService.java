package com.gustavonascimento.MovieFlix.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gustavonascimento.MovieFlix.services.exceptions.ResourceNotFoundException;
import com.gustavonascimento.MovieFlix.entities.User;
import com.gustavonascimento.MovieFlix.entities.dto.UserDTO;
import com.gustavonascimento.MovieFlix.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository repository;

	@Transactional(readOnly = true)
	public UserDTO findCurrentUser(Long id) {
		Optional<User> obj = repository.findById(id);
		User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
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