package com.forezp;

// MIGRATED: HystrixCommand removed in Spring Cloud 2020.x, replaced with Resilience4J CircuitBreaker
// import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker; // MIGRATED: Resilience4J CircuitBreaker replaces HystrixCommand
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
// MIGRATED: @EnableHystrix removed in Spring Cloud 2020.x; Resilience4J circuit breaker is auto-configured via spring-cloud-starter-circuitbreaker-resilience4j
// import org.springframework.cloud.netflix.hystrix.EnableHystrix;
// MIGRATED: @EnableHystrixDashboard removed in Spring Cloud 2020.x; use Spring Boot Actuator with Micrometer
// import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
// MIGRATED: @EnableHystrix removed, Resilience4J auto-configured via spring-cloud-starter-circuitbreaker-resilience4j
// MIGRATED: @EnableHystrix removed, Resilience4J auto-configured via spring-cloud-starter-circuitbreaker-resilience4j
public class ServiceHiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceHiApplication.class, args);
	}

	@Value("${server.port}")
	String port;
	@RequestMapping("/hi")
	@CircuitBreaker(name = "default", fallbackMethod = "hiError") // MIGRATED: @HystrixCommand replaced with @CircuitBreaker (Resilience4J)
	public String home(@RequestParam String name) {
		return "hi "+name+",i am from port:" +port;
	}

	public String hiError(String name) {
		return "hi,"+name+",sorry,error!";
	}
}
