package com.example.product;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.example.product"})
public class AppConfig {
	
	@Bean
	public EntityManagerFactory factory() {
		return Persistence.createEntityManagerFactory("abc");
	}
	
}
