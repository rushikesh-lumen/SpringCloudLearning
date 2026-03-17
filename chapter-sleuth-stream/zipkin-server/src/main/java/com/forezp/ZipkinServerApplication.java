package com.forezp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
// MIGRATED: zipkin.server.EnableZipkinServer and spring-cloud-sleuth zipkin stream removed in Spring Boot 3.x
// import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;
// import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableEurekaClient
// MIGRATED: @EnableZipkinStreamServer removed; use Micrometer Tracing with separate Zipkin server instead
public class ZipkinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinServerApplication.class, args);
	}
}
