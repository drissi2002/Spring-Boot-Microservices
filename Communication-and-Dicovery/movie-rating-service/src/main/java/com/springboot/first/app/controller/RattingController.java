package com.springboot.first.app.controller;

import com.springboot.first.app.UserRatting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.first.app.Ratting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class  RattingController {
	
	@GetMapping("/ratting/{movieId}")
	public Ratting getRatting( @PathVariable("movieId") String movieId) {
		return new Ratting(movieId,5);
	}

	@GetMapping("/ratting/user/{userId}")
	public UserRatting getRattingMovie( @PathVariable("userId") String userId) {

		List<Ratting> rattings = Arrays.asList(
				new Ratting("1234",5),
				new Ratting("5678",3),
				new Ratting("9000",4)
		);

		UserRatting userRatting = new UserRatting();
		userRatting.setUserRatting(rattings);

		return userRatting;
	}


}
