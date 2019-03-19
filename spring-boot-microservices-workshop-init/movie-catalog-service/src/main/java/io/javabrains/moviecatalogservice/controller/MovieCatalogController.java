package io.javabrains.moviecatalogservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.javabrains.moviecatalogservice.model.CatalogItem;
import io.javabrains.moviecatalogservice.model.Movie;
import io.javabrains.moviecatalogservice.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

	private static final String MOVIE_INFO_URL = "http://movie-info-service/movies/";
	private static final String MOVIE_RATINGS_URL = "http://ratings-data-service/ratings/users/";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
				
		// get all movie ids
		UserRating userRating = restTemplate.getForObject(MOVIE_RATINGS_URL + userId, UserRating.class);
		
		// for each movie id, call movie info service and ratings
		return userRating.getUserRatings().stream()
		.map(rating -> {			
			Movie movie = restTemplate.getForObject(MOVIE_INFO_URL + rating.getMovieId(), Movie.class);
			return new CatalogItem(movie.getName(), movie.getDesc(), rating.getRating());
		})
		.collect(Collectors.toList());
		
	}
}
