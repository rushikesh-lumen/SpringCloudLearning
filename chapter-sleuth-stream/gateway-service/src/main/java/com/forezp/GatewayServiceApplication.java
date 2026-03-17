package com.forezp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

// MIGRATED: @EnableZuulProxy removed - Spring Cloud Gateway is auto-configured
@SpringBootApplication
@EnableDiscoveryClient // MIGRATED: @EnableEurekaClient -> @EnableDiscoveryClient
public class GatewayServiceApplication {

public static void main(String[] args) {
SpringApplication.run(GatewayServiceApplication.class, args);
}
}
