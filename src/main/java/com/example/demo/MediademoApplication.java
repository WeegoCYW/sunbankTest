package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;//
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;//
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;//

@SpringBootApplication
@EnableWebSecurity
@EnableJpaRepositories("com.example.demo.repository")//
@EntityScan("com.example.demo.entity")//
@ComponentScan(basePackages = {"com.example.demo", "com.example.demo.repository", "com.example.demo.entity"})//
public class MediademoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediademoApplication.class, args);
	}

}
