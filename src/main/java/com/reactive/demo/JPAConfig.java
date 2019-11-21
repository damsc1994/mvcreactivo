package com.reactive.demo;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JPAConfig{

	@Bean
	public BasicDataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		//dataSource.setDriverClassName("");
		dataSource.setUrl("r2dbc:mysql://localhost/cleanArchitecture");
		dataSource.setUsername("root");
		dataSource.setPassword("123");
		
		return dataSource;
	}
	
}
