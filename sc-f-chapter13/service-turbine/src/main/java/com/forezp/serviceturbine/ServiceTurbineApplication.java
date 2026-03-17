package com.forezp.serviceturbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// MIGRATED: @EnableCircuitBreaker removed in Spring Cloud 2020.x; circuit breaker is auto-configured
// import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
// MIGRATED: @EnableHystrix removed in Spring Cloud 2020.x; Resilience4J circuit breaker is auto-configured via spring-cloud-starter-circuitbreaker-resilience4j
// import org.springframework.cloud.netflix.hystrix.EnableHystrix;
// MIGRATED: @EnableHystrixDashboard removed in Spring Cloud 2020.x; use Spring Boot Actuator with Micrometer
// import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
// MIGRATED: @EnableTurbine removed in Spring Cloud 2020.x; use Micrometer/Prometheus for metrics aggregation instead
// import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RestController
// MIGRATED: @EnableHystrix removed, Resilience4J auto-configured via spring-cloud-starter-circuitbreaker-resilience4j
// MIGRATED: @EnableHystrix removed, Resilience4J auto-configured via spring-cloud-starter-circuitbreaker-resilience4j
// MIGRATED: @EnableCircuitBreaker removed, circuit breaker is auto-configured
// MIGRATED: @EnableTurbine removed; use Micrometer/Prometheus for metrics aggregation instead
public class ServiceTurbineApplication {

    /**
     * http://localhost:8764/turbine.stream
     */

    public static void main(String[] args) {
        SpringApplication.run( ServiceTurbineApplication.class, args );
    }
}
