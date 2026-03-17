package com.forezp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient; // MIGRATED: @EnableEurekaClient deprecated in Spring Cloud 2021.x → use @EnableDiscoveryClient
import zipkin.server.EnableZipkinServer; // MIGRATED: @EnableZipkinServer - NOTE: Embedded Zipkin server removed in Spring Cloud 2020.x; use standalone Zipkin server (https://zipkin.io/pages/quickstart)

@SpringBootApplication
@EnableDiscoveryClient // MIGRATED: @EnableEurekaClient → @EnableDiscoveryClient (deprecated in Spring Cloud 2021.x)
@EnableZipkinServer
public class ZipkinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinServerApplication.class, args);
	}
}
