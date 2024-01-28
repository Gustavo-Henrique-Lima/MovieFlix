package com.gustavonascimento.MovieFlix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustavonascimento.MovieFlix.entities.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

}