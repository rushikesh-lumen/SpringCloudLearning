package com.forezp.servicegateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient; // MIGRATED: EnableEurekaClient -> EnableDiscoveryClient
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient // MIGRATED: @EnableEurekaClient -> @EnableDiscoveryClient
public class ServiceGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run( ServiceGatewayApplication.class, args );
    }

    @Bean
    public RequestTimeGatewayFilterFactory requestTimeGatewayFilterFactory() {
        return new RequestTimeGatewayFilterFactory();
    }
}
