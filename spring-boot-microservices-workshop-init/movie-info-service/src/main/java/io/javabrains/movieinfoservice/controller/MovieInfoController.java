package io.javabrains.movieinfoservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.movieinfoservice.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieInfoController {

	@GetMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable ("movieId") String movieId) {
		return new Movie(movieId, "One Cut of the Dead", "Zombie horror");
	}
}
