package com.reactive.demo.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.reactive.demo.Repository.MovieRepository;
import com.reactive.demo.entity.Movie;
import com.reactive.demo.services.MoviesServices;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class MovieHandler {
	private final MoviesServices moviesServices;
	
	public MovieHandler(MoviesServices moviesServices) {
		this.moviesServices = moviesServices;
	}
	
	public Mono<ServerResponse> all(ServerRequest serverRequest) {
	    Flux<Movie> movies = this.moviesServices.findAll();
	    return ServerResponse.ok().body(movies, Movie.class);
	}
	
	public Mono<ServerResponse> add(ServerRequest serverRequest) {
	    Mono<Movie> movie = serverRequest.bodyToMono(Movie.class).flatMap(this.moviesServices::save);
	    //movie.subscribe(System.out::println);
	    //movie.subscribe(m -> movieRepository.save(m));
	    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(movie, Movie.class);
	}
}
