package com.school.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.school") 
@EnableJpaRepositories(basePackages = "com.school.repository") 
@EntityScan(basePackages = "com.school.entity") 
public class SchoolManagementRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolManagementRestApiApplication.class, args);
	}

}
