package com.reactive.demo.services;

import java.util.UUID;

import com.reactive.demo.entity.Movie;
import org.springframework.data.redis.core.ReactiveRedisOperations;

import com.reactive.demo.entity.MovieRedis;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MoviRedisServices {
	private final ReactiveRedisOperations<String, MovieRedis> movieOperations;
	private final SQSServices sqsServices;
	
	public MoviRedisServices(ReactiveRedisOperations<String, MovieRedis> movieOperations) {
		this.movieOperations = movieOperations;
		this.sqsServices = new SQSServices();
	}
	
	public Flux<MovieRedis> findAll() {
		return movieOperations.keys("*").flatMap(movieOperations.opsForValue()::get);
	}
	
	public Mono<Boolean> add(MovieRedis movieRedis) {
		//doOnSuccess(datas -> sqsServices.saveSQS(getMessageLog(movieRedis)));
		movieRedis.setKey(UUID.randomUUID().toString());
		return movieOperations.opsForValue().set(movieRedis.getKey(), movieRedis);
	}

	
	public Mono<MovieRedis> finById(String id) {
		return movieOperations.opsForValue().get(id);
	}

	public String getMessageLog(MovieRedis movie) {
		return "{'key':'"+movie.getKey()+"','value':'"+movie.getValue()+"'}";
	}
}
