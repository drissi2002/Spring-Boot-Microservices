package com.springboot.first.app;

public class Ratting {
	
	private String movieId;
	private int rating;

	public Ratting() {
	}

	public Ratting(String movieId, int rating) {
		super();
		this.movieId = movieId;
		this.rating = rating;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
	
