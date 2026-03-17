package com.forezp;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker; // MIGRATED: replaced HystrixCommand with Resilience4J CircuitBreaker
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
// MIGRATED: removed EnableHystrix import (Resilience4J is auto-configured)
// MIGRATED: removed EnableHystrixDashboard import (no replacement in Spring Cloud 2021.0.x)
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
// MIGRATED: removed @EnableHystrix (Resilience4J auto-configured via spring-cloud-starter-circuitbreaker-resilience4j)
// MIGRATED: removed @EnableHystrixDashboard (no equivalent in Spring Cloud 2021.0.x; use Actuator + Micrometer)
public class ServiceHiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceHiApplication.class, args);
	}

	@Value("${server.port}")
	String port;
	@RequestMapping("/hi")
	@CircuitBreaker(name = "default", fallbackMethod = "hiError") // MIGRATED: replaced @HystrixCommand with Resilience4J @CircuitBreaker
	public String home(@RequestParam String name) {
		return "hi "+name+",i am from port:" +port;
	}

	public String hiError(String name, Throwable t) { // MIGRATED: added Throwable parameter required by Resilience4J
		return "hi,"+name+",sorry,error!";
	}
}
