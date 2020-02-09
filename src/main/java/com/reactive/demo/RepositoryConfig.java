package com.reactive.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;

import com.reactive.demo.Repository.MovieRepository;
import com.reactive.demo.entity.MovieRedis;
import com.reactive.demo.services.MoviRedisServices;
import com.reactive.demo.services.MoviesServices;

@Configuration
public class RepositoryConfig{
	
	@Bean
	public MoviesServices movieServices(MovieRepository movieRepository) {
		return new MoviesServices(movieRepository);
	}
	
	@Bean
	public MoviRedisServices moviRedisServices(ReactiveRedisOperations<String, MovieRedis> moviRedisOperations) {
		return new MoviRedisServices(moviRedisOperations);
	}

/*	@Bean
	public RedisConnectionFactory jedisConnectionFactory() {
		RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration()
				.master("myRedis")
				.sentinel("127.0.0.1", 26379)
				.sentinel("127.0.0.1", 26380);
		return new LettuceConnectionFactory(sentinelConfig);
	} */
}
