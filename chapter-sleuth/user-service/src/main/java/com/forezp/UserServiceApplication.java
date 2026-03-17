package com.forezp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient; // MIGRATED: @EnableEurekaClient deprecated in Spring Cloud 2021.x → use @EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient // MIGRATED: @EnableEurekaClient → @EnableDiscoveryClient (deprecated in Spring Cloud 2021.x)
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
}
