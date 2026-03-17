package com.forezp;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
// MIGRATED: removed EnableTurbine import (Turbine removed from Spring Cloud 2021.0.x)

@SpringBootApplication
// MIGRATED: removed @EnableTurbine (Turbine removed from Spring Cloud 2021.0.x)

public class ServiceTurbineApplication {

	public static void main(String[] args) {

			new SpringApplicationBuilder(ServiceTurbineApplication.class).web(true).run(args);
	}
}
