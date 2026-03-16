package com.forezp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
// MIGRATED: import zipkin.server.EnableZipkinServer removed - @EnableZipkinServer deprecated and removed in Zipkin 2.x; Zipkin server now uses Spring Boot autoconfiguration

@SpringBootApplication
@EnableEurekaClient
// MIGRATED: @EnableZipkinServer removed - deprecated and removed in Zipkin 2.x; use Zipkin standalone server or Spring Boot autoconfiguration
public class ZipkinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinServerApplication.class, args);
	}
}
