package com.reactive.demo.Repository;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import com.reactive.demo.entity.Movie;

public interface MovieRepository extends ReactiveCrudRepository<Movie, Long>{

}