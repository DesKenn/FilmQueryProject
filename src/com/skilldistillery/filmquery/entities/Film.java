package com.skilldistillery.filmquery.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Film {
//	FIELDS
	private int filmId;
	private String title;
	private String description;
	private Integer releaseYear;
	private int langId;
	private int rentalDuration;
	private double rentalRate;
	private Integer length;
	private double replacementCost;
	private String rating;
	private String specialFeatures;
	private String language;
	private List<Actor>actors;
	
	

	public Film() {
		super();
	}

	List<Actor> actor = new ArrayList<>();
	List<Film> films = new ArrayList<>();

	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public List<Actor> getActor() {
		return actor;
	}

	public void setActor(List<Actor> actor) {
		this.actor = actor;
	}

	public int getFilmId() {
		return filmId;
	}

	public void setId(int filmId) {
		this.filmId = filmId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLangId() {
		return langId;
	}

	public void setLangId(int langId) {
		this.langId = langId;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	

	@Override
	public String toString() {
		return "Film id is " + filmId + ", the title is " + title + ", description= " + description + ", Release Year= " 
				+ releaseYear + ", language ID= " + langId + ", rental Duration= " + rentalDuration + ", rental Rate= "
				+ rentalRate + ", length= " + length + ", replacement Cost= " + replacementCost + ", rating= " + rating
				+ ", Special Features include; " + specialFeatures + ", language is in " + language ;
	}

	@Override
	public int hashCode() {
		return Objects.hash(actor, actors, description, filmId, films, langId, language, length, rating, releaseYear,
				rentalDuration, rentalRate, replacementCost, specialFeatures, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(actor, other.actor) && Objects.equals(actors, other.actors)
				&& Objects.equals(description, other.description) && filmId == other.filmId
				&& Objects.equals(films, other.films) && langId == other.langId
				&& Objects.equals(language, other.language) && Objects.equals(length, other.length)
				&& Objects.equals(rating, other.rating) && Objects.equals(releaseYear, other.releaseYear)
				&& rentalDuration == other.rentalDuration
				&& Double.doubleToLongBits(rentalRate) == Double.doubleToLongBits(other.rentalRate)
				&& Double.doubleToLongBits(replacementCost) == Double.doubleToLongBits(other.replacementCost)
				&& Objects.equals(specialFeatures, other.specialFeatures) && Objects.equals(title, other.title);
	}

	
}