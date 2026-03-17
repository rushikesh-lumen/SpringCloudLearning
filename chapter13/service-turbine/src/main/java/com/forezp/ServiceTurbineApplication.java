package com.forezp;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
// MIGRATED: @EnableTurbine removed in Spring Cloud 2020.x; use Micrometer/Prometheus for metrics aggregation
// import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
// MIGRATED: @EnableTurbine removed; use Micrometer/Prometheus for metrics aggregation instead

public class ServiceTurbineApplication {

	public static void main(String[] args) {

			new SpringApplicationBuilder(ServiceTurbineApplication.class).web(true).run(args);
	}
}
