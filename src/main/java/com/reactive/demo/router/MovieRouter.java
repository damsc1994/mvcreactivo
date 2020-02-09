package com.reactive.demo.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.reactive.demo.handler.MovieHandler;

@Configuration
@EnableWebFlux
public class MovieRouter implements WebFluxConfigurer{
	
	 @Bean
	 public RouterFunction<ServerResponse> routeShow(MovieHandler movieHandler) {
	    return RouterFunctions
	      .route(RequestPredicates.GET("/movies"), movieHandler::all)
	      .andRoute(RequestPredicates.POST("/movies/add"), movieHandler::add)
	      .andRoute(RequestPredicates.GET("/movies/redis"), movieHandler::allRedis)
	      .andRoute(RequestPredicates.POST("/movies/redis/add"), movieHandler::addRedis)
	      .andRoute(RequestPredicates.GET("/movies/redis/{id}"), movieHandler::getById);
	 }
}
