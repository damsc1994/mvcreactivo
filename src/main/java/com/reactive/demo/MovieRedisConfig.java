package com.reactive.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.reactive.demo.entity.MovieRedis;

@Configuration
public class MovieRedisConfig {

	@Bean
	ReactiveRedisOperations<String, MovieRedis> redisOperations(ReactiveRedisConnectionFactory factory) {
		Jackson2JsonRedisSerializer<MovieRedis> serializer = 
				new Jackson2JsonRedisSerializer<MovieRedis>(MovieRedis.class); 
		RedisSerializationContext.RedisSerializationContextBuilder<String, MovieRedis>
			movieRedisBuilder = RedisSerializationContext
			.newSerializationContext(new StringRedisSerializer());
		RedisSerializationContext<String, MovieRedis> context = movieRedisBuilder
				.value(serializer).build();
		return new ReactiveRedisTemplate<>(factory, context);
	}
}
