package com.forezp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient; // MIGRATED: @EnableEurekaClient deprecated in Spring Cloud 2021.x → use @EnableDiscoveryClient
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient // MIGRATED: @EnableEurekaClient → @EnableDiscoveryClient (deprecated in Spring Cloud 2021.x)
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}
}
