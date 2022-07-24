package com.springboot.first.app.controller;

import com.springboot.first.app.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.first.app.Movie;
import org.springframework.web.client.RestTemplate;

import javax.annotation.security.RolesAllowed;

@RestController
public class MovieController {

	@Value("${api.key}")
	private String apiKey;

	@Autowired
	private RestTemplate restTemplate ;




	@GetMapping("/movies/{movieId}")
	public MovieSummary getMovieInfo(@PathVariable("movieId") String movieId) {
		MovieSummary movieSummary = restTemplate.getForObject(
				"https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey ,MovieSummary.class
		);

		return new MovieSummary (movieId,movieSummary.getTitle(),movieSummary.getOverview());
	}

}
