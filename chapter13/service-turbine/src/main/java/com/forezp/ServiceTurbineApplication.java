package com.forezp;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
// MIGRATED: removed EnableTurbine import (Turbine removed from Spring Cloud 2021.0.x)

@SpringBootApplication
// MIGRATED: removed @EnableTurbine (Turbine removed from Spring Cloud 2021.0.x)

public class ServiceTurbineApplication {

	public static void main(String[] args) {

			SpringApplication.run(ServiceTurbineApplication.class, args); // MIGRATED: replaced SpringApplicationBuilder.web(boolean) which was removed in Spring Boot 2.x
	}
}
