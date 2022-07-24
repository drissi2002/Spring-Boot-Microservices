package com.springboot.first.app.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import com.springboot.first.app.*;
import com.springboot.first.app.services.MovieInfo;
import com.springboot.first.app.services.MovieRatting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.security.RolesAllowed;

@RestController
public class MovieCatalogController {


	//@Autowired
	//private DiscoveryClient discoveryClient;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	MovieInfo movieInfo;

	@Autowired
	MovieRatting movieRatting;

	/*@Autowired
	private  WebClient.Builder webClientBuilder;*/


	@GetMapping("/catalog/{userId}")
	//@HystrixCommand(fallbackMethod = "getFallbackCatalog")
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

		UserRatting rattings = movieRatting.getUserRatting(userId);
		return rattings.getUserRatting().stream()
				.map( ratting -> movieInfo.getMovieCatalog(ratting))
				.collect(Collectors.toList());
	}


	// -- In fact we splited the "getCatalog" method into 2 methods "getMovieCatalog" & "getUserRatting"

	/*@HystrixCommand(fallbackMethod = "getFallbackMovieCatalog")
	private Catalog getMovieCatalog(Ratting ratting){
		MovieSummary movie = restTemplate.getForObject("http://movie-info-service/movies/"+ ratting.getMovieId(),MovieSummary.class);
		return new Catalog(movie.getTitle(),movie.getOverview(),ratting.getRating());
	}*/


	/*@HystrixCommand(fallbackMethod = "getFallbackRatting")
	private UserRatting getUserRatting(@PathVariable("userId") String userId){
		return restTemplate.getForObject("http://movie-ratting-service/ratting/user/" + userId, UserRatting.class);
	}*/


	//Fallbacks methods

	public List<Catalog> getFallbackCatalog(@PathVariable("userId") String userId) {
		return Arrays.asList(new Catalog("no movie","",0));
	}

	/*private Catalog getFallbackMovieCatalog(Ratting ratting){
		return new Catalog("Movie name not found","", ratting.getRating());
	}*/

	/*private UserRatting getFallbackRatting(@PathVariable("userId") String userId){
		UserRatting userRatting = new UserRatting();
		Ratting ratting = new Ratting("",0);
		userRatting.setUserRatting(ratting);
		return userRatting;
	}*/
}


		//  return Collections.singletonList(
		//	new Catalog("Imitation Game","historical",5));



