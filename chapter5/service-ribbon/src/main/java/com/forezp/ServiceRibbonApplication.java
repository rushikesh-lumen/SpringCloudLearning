package com.forezp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
// MIGRATED: removed EnableHystrix import (Resilience4J is auto-configured)
// MIGRATED: removed EnableHystrixDashboard import (no replacement in Spring Cloud 2021.0.x)
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
// MIGRATED: removed @EnableHystrix (Resilience4J auto-configured via spring-cloud-starter-circuitbreaker-resilience4j)
// MIGRATED: removed @EnableHystrixDashboard (no equivalent in Spring Cloud 2021.0.x; use Actuator + Micrometer)
public class ServiceRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRibbonApplication.class, args);
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}