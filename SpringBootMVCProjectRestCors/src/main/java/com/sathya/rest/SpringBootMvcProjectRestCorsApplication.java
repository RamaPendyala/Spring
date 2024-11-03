package com.sathya.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
@EnableCaching
@SpringBootApplication
public class SpringBootMvcProjectRestCorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcProjectRestCorsApplication.class, args);
	}

}
