package com.forezp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MIGRATED: @EnableTurbine removed - Netflix Turbine no longer available in Spring Cloud 2021.0+.
 * Monitoring can be achieved using Spring Boot Actuator + Micrometer + Zipkin.
 */
@SpringBootApplication
// MIGRATED: @EnableTurbine removed - Turbine no longer available in Spring Cloud 2021.0+
public class ServiceTurbineApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceTurbineApplication.class, args); // MIGRATED: SpringApplicationBuilder.web(true) -> SpringApplication.run
	}
}
