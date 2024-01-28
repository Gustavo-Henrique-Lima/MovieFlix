package com.gustavonascimento.MovieFlix.entities;

import java.io.Serializable;
import java.util.Objects;

<<<<<<< HEAD
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "tb_movie")
@Entity
=======
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

>>>>>>> 8a83f0c8ee67c41bfbe9fa0d1efb01d1e70a04b2
public class Movie implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private Integer year;
	private String subTitle;
	private String imgUrl;
	private String synopsis;
	@ManyToOne
	@JoinColumn(name = "genre_id")
	private Genre genre;

	public Movie() {
	}

<<<<<<< HEAD
	public Movie(Long id, String title, Integer year, String subTitle, String imgUrl, String synopsis, Genre genre) {
=======
	public Movie(Long id, String title, String subTitle, Integer year, String imgUrl, String synopsis, Genre genre) {
>>>>>>> 8a83f0c8ee67c41bfbe9fa0d1efb01d1e70a04b2
		this.id = id;
		this.title = title;
		this.year = year;
		this.subTitle = subTitle;
		this.imgUrl = imgUrl;
		this.synopsis = synopsis;
		this.genre = genre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(id, other.id);
	}

}