package io.javabrains.ratingsdataservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.ratingsdataservice.model.Rating;
import io.javabrains.ratingsdataservice.model.UserRating;

@RestController
@RequestMapping("/ratings")
public class MovieRatingsController {

	@GetMapping("/{movieId}")
	public Rating getRatings(@PathVariable("movieId") String movieId){
		return new Rating(movieId, 5);
	}
	
	@GetMapping("/users/{userId}")
	public UserRating getUserRatings(@PathVariable("userId") String userId){
		
		List<Rating> ratings = new ArrayList<>();
		ratings.add(new Rating("1234", 5));
		ratings.add(new Rating("5678", 4));
		
		return new UserRating(ratings);
		
	}


}
