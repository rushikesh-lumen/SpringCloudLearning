package com.forezp.servicegateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient; // MIGRATED: @EnableEurekaClient deprecated in Spring Cloud 2021.x → use @EnableDiscoveryClient
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient // MIGRATED: @EnableEurekaClient → @EnableDiscoveryClient (deprecated in Spring Cloud 2021.x)
public class ServiceGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run( ServiceGatewayApplication.class, args );
    }

    @Bean
    public RequestTimeGatewayFilterFactory requestTimeGatewayFilterFactory() {
        return new RequestTimeGatewayFilterFactory();
    }
}
