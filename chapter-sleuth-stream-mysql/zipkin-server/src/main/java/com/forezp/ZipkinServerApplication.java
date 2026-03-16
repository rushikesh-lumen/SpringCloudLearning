package com.forezp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
// MIGRATED: import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer removed - EnableZipkinStreamServer removed in Spring Cloud Sleuth 2.x
// MIGRATED: import zipkin.server.EnableZipkinServer removed - @EnableZipkinServer deprecated and removed in Zipkin 2.x; Zipkin server now uses Spring Boot autoconfiguration

@SpringBootApplication
@EnableEurekaClient
// MIGRATED: @EnableZipkinStreamServer removed - streaming Zipkin server removed in Spring Cloud Sleuth 2.x; use spring-cloud-sleuth-zipkin for HTTP transport
public class ZipkinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinServerApplication.class, args);
	}
}
