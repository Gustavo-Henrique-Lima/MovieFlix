package com.gustavonascimento.MovieFlix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustavonascimento.MovieFlix.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}