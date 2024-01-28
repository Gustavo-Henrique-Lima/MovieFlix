package com.gustavonascimento.MovieFlix.entities;

import java.io.Serializable;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
=======
import java.util.HashSet;
>>>>>>> 8a83f0c8ee67c41bfbe9fa0d1efb01d1e70a04b2
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name = "tb_genre")
@Entity
public class Genre implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@OneToMany(mappedBy = "genre")
<<<<<<< HEAD
	private List<Movie> movies = new ArrayList<>();
=======
	private Set<Movie> movies = new HashSet<>();
>>>>>>> 8a83f0c8ee67c41bfbe9fa0d1efb01d1e70a04b2

	public Genre() {
	}

	public Genre(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

<<<<<<< HEAD
	public List<Movie> getMovies() {
=======
	public Set<Movie> getMovies() {
>>>>>>> 8a83f0c8ee67c41bfbe9fa0d1efb01d1e70a04b2
		return movies;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Genre other = (Genre) obj;
		return Objects.equals(id, other.id);
	}

}