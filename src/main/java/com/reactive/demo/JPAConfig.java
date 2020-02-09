package com.reactive.demo;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import dev.miku.r2dbc.mysql.MySqlConnectionFactoryProvider;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;

@Configuration
@EnableR2dbcRepositories
public class JPAConfig extends AbstractR2dbcConfiguration{

//	@Bean
//	public BasicDataSource getDataSource() {
//		BasicDataSource dataSource = new BasicDataSource();
//		//dataSource.setDriverClassName("");
//		dataSource.setUrl("r2dbc:mysql://root:123@localhost/cleanArchitecture");
//		dataSource.setUsername("root");
//		dataSource.setPassword("123");
//		
//		return dataSource;
//	}

	@Bean
	public ConnectionFactory connectionFactory() {
		return new MySqlConnectionFactoryProvider()
			.create(ConnectionFactoryOptions.parse("r2dbc:mysql://root:123@localhost/cleanArchitecture"));
	}
	
	
	
}
