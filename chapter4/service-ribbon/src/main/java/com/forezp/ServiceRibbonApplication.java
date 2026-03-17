package com.forezp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
// MIGRATED: @EnableHystrix removed in Spring Cloud 2020.x; Resilience4J circuit breaker is auto-configured via spring-cloud-starter-circuitbreaker-resilience4j
// import org.springframework.cloud.netflix.hystrix.EnableHystrix;
// MIGRATED: @EnableHystrixDashboard removed in Spring Cloud 2020.x; use Spring Boot Actuator with Micrometer
// import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
// MIGRATED: @EnableHystrix removed, Resilience4J auto-configured via spring-cloud-starter-circuitbreaker-resilience4j
// MIGRATED: @EnableHystrix removed, Resilience4J auto-configured via spring-cloud-starter-circuitbreaker-resilience4j
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