package com.gustavonascimento.MovieFlix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustavonascimento.MovieFlix.entities.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long>{

}