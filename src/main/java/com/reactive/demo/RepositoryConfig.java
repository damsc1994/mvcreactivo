package com.reactive.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.reactive.demo.Repository.MovieRepository;
import com.reactive.demo.services.MoviesServices;

@Configuration
public class RepositoryConfig{
	
	@Bean
	public MoviesServices movieServices(MovieRepository movieRepository) {
		return new MoviesServices(movieRepository);
	}
}
