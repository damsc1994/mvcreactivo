//package com.reactive.demo;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
//import org.springframework.data.mongodb.core.MongoOperations;
//import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
//import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
//
//import com.mongodb.reactivestreams.client.MongoClient;
//import com.mongodb.reactivestreams.client.MongoClients;
//import com.reactive.demo.entity.Movie;
//
//@Configuration
//public class MongoReactiveApplication extends AbstractReactiveMongoConfiguration{
//
//	@Bean
//	public MongoClient reactiveMongoClient() {
//		// TODO Auto-generated method stub
//		return MongoClients.create("mongodb://localhost/cleanArchitecture");
//	}
//	  
//	@Override
//	protected String getDatabaseName() {
//		// TODO Auto-generated method stub
//		return "cleanArchitecture";
//	}
//	
//	@Bean
//    public ReactiveMongoTemplate reactiveMongoTemplate() {
//        return new ReactiveMongoTemplate(reactiveMongoClient(), getDatabaseName());
//    }
//
//}
