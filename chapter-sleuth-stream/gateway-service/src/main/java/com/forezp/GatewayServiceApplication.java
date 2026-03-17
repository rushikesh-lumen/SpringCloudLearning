package com.forezp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
// MIGRATED: removed EnableZuulProxy import (Spring Cloud Gateway replaces Zuul)

@SpringBootApplication
// MIGRATED: removed @EnableZuulProxy (Spring Cloud Gateway is auto-configured)
@EnableEurekaClient
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}
}
