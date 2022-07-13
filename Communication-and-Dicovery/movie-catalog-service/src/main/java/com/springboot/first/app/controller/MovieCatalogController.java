package com.springboot.first.app.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.netflix.discovery.DiscoveryClient;
import com.springboot.first.app.UserRatting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springboot.first.app.Catalog;
import com.springboot.first.app.Movie;
@RestController
public class MovieCatalogController {


	//@Autowired
	//private DiscoveryClient discoveryClient;

	@Autowired
	private RestTemplate restTemplate;

	/*@Autowired
	private  WebClient.Builder webClientBuilder;*/

	@GetMapping("/catalog/{userId}")
	public List<Catalog> getCatalog(@PathVariable("userId") String userId) {
		
		/*
		 -- Steps to follow :
		 1) get all rated movie IDs
		 2) for each movie ID , call movie info service to get details
		 3) put them all together
		  
		  */
		/* for (Ratting ratting : rattings) {
			Movie movie = restTemplate.getForObject("http://localhost:8082/movies/"+ ratting.getMovieId(),Movie.class);
			Movie movie = webClientBuilder.build()
					.get()
					.uri("http://localhost:8082/movies/" + ratting.getMovieId())
					.retrieve()
					.bodyToMono(Movie.class)
					.block();
			listeCat.add(new Catalog(movie.getName(),"Desc",ratting.getRating()));

		}
		return listeCat ; */
		UserRatting rattings = restTemplate.getForObject("http://movie-ratting-service/ratting/user/" + userId, UserRatting.class);
		return rattings.getUserRatting().stream().map( ratting ->{
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/"+ ratting.getMovieId(),Movie.class);
			return new Catalog(movie.getName(),"Desc",ratting.getRating());
		}).collect(Collectors.toList());
	}}

		
		//return Collections.singletonList(
		//		new Catalog("Imitation Game","historical",5));



