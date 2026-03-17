package com.forezp.servicehi;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker; // MIGRATED: HystrixCommand -> CircuitBreaker
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// MIGRATED: @SpringCloudApplication removed - circuit breaker auto-configured
// MIGRATED: @EnableCircuitBreaker removed - circuit breaker is auto-configured
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient; // MIGRATED: EnableEurekaClient -> EnableDiscoveryClient
// MIGRATED: @EnableHystrix removed - Resilience4J is auto-configured
// MIGRATED: @EnableHystrixDashboard removed - Hystrix Dashboard no longer available
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient // MIGRATED: @EnableEurekaClient -> @EnableDiscoveryClient
@RestController
// MIGRATED: @EnableHystrix removed
// MIGRATED: @EnableHystrixDashboard removed
// MIGRATED: @EnableCircuitBreaker removed
public class ServiceHiApplication {

    /**
     * 访问地址 http://localhost:8762/actuator/hystrix.stream
     * @param args
     */

    public static void main(String[] args) {
        SpringApplication.run( ServiceHiApplication.class, args );
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    @CircuitBreaker(name = "hiError", fallbackMethod = "hiError") // MIGRATED: @HystrixCommand -> @CircuitBreaker
    public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }

}



