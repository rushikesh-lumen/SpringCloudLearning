package com.forezp.serviceturbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// MIGRATED: removed EnableCircuitBreaker import (Resilience4J is auto-configured)
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
// MIGRATED: removed EnableHystrix import (Resilience4J is auto-configured)
// MIGRATED: removed EnableHystrixDashboard import (no replacement in Spring Cloud 2021.0.x)
// MIGRATED: removed EnableTurbine import (Turbine removed from Spring Cloud 2021.0.x)
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RestController
// MIGRATED: removed @EnableHystrix (Resilience4J auto-configured via spring-cloud-starter-circuitbreaker-resilience4j)
// MIGRATED: removed @EnableHystrixDashboard (no equivalent in Spring Cloud 2021.0.x; use Actuator + Micrometer)
// MIGRATED: removed @EnableCircuitBreaker (Resilience4J auto-configured)
// MIGRATED: removed @EnableTurbine (Turbine removed from Spring Cloud 2021.0.x)
public class ServiceTurbineApplication {

    /**
     * http://localhost:8764/turbine.stream
     */

    public static void main(String[] args) {
        SpringApplication.run( ServiceTurbineApplication.class, args );
    }
}
