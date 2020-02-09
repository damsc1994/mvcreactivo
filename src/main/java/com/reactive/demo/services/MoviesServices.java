package com.reactive.demo.services;


import com.reactive.demo.Repository.MovieRepository;
import com.reactive.demo.entity.Movie;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MoviesServices {
	public MovieRepository movieRepository;
	
	public MoviesServices(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	
	public Flux<Movie> findAll() {
		return movieRepository.findAll();
	}
	
	public Mono<Movie> save(Movie movie) {
		return movieRepository.save(movie);
	}
}
