package com.reactive.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Component;

import com.reactive.demo.entity.MovieRedis;

//@Component
//public class LoadData {
//	private final ReactiveRedisConnectionFactory factory;
//	private final ReactiveRedisOperations<String, MovieRedis> coffeeOps;
//}
