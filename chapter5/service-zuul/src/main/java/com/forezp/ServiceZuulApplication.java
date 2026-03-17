package com.forezp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
// MIGRATED: removed EnableZuulProxy import (Spring Cloud Gateway replaces Zuul)
import org.springframework.context.annotation.Bean;

// MIGRATED: removed @EnableZuulProxy (Spring Cloud Gateway is auto-configured)
@EnableEurekaClient
@SpringBootApplication
public class ServiceZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceZuulApplication.class, args);
	}



}
