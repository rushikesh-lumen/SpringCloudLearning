package com.forezp.serviceturbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * MIGRATED: Netflix Turbine, Hystrix, and related annotations removed.
 * Spring Cloud 2021.0+ no longer includes Netflix Turbine.
 * Monitoring can be achieved using Spring Boot Actuator + Micrometer + Zipkin.
 * http://localhost:8764/actuator - use Actuator endpoints for monitoring
 */
@SpringBootApplication
@EnableDiscoveryClient // MIGRATED: @EnableEurekaClient -> @EnableDiscoveryClient, @EnableTurbine removed
public class ServiceTurbineApplication {

    /**
     * MIGRATED: Turbine monitoring removed - use Spring Boot Actuator + Micrometer
     */
    public static void main(String[] args) {
        SpringApplication.run( ServiceTurbineApplication.class, args );
    }
}
