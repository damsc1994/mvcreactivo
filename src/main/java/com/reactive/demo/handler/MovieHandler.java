package com.reactive.demo.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.reactive.demo.Repository.MovieRepository;
import com.reactive.demo.entity.Movie;
import com.reactive.demo.entity.MovieRedis;
import com.reactive.demo.services.MoviRedisServices;
import com.reactive.demo.services.MoviesServices;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class MovieHandler {
	private final MoviesServices moviesServices;
	private final MoviRedisServices moviRedisServices;
	
	public MovieHandler(MoviesServices moviesServices, MoviRedisServices moviRedisServices) {
		this.moviesServices = moviesServices;
		this.moviRedisServices = moviRedisServices;
	}
	
	public Mono<ServerResponse> all(ServerRequest serverRequest) {
	    Flux<Movie> movies = this.moviesServices.findAll();
	    return ServerResponse.ok().body(movies, Movie.class);
	}
	
	public Mono<ServerResponse> add(ServerRequest serverRequest) {
	    Mono<Movie> movie = serverRequest.bodyToMono(Movie.class).flatMap(this.moviesServices::save);
	    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(movie, Movie.class);
	}
	
	
	public Mono<ServerResponse> allRedis(ServerRequest serverRequest) {
		Flux<MovieRedis> moviesRedis = this.moviRedisServices.findAll();
		return ServerResponse.ok().body(moviesRedis, MovieRedis.class);
	}
	
	public Mono<ServerResponse> addRedis(ServerRequest serverRequest) {
	   Mono<Boolean> moviesRedis = serverRequest.bodyToMono(MovieRedis.class)
			   .flatMap(this.moviRedisServices::add);
	   return ServerResponse.ok().body(moviesRedis, Boolean.class);
	}
	
	public Mono<ServerResponse> getById(ServerRequest serverRequest) {
		Mono<MovieRedis> movieRedis = this.moviRedisServices.finById(serverRequest.pathVariable("id"));
		return ServerResponse.ok().body(movieRedis, MovieRedis.class);
				
	}
}
