package com.forezp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MIGRATED: Embedded Zipkin server removed from Spring Cloud Sleuth 3.x.
 * To use Zipkin: run the standalone Zipkin server (https://zipkin.io/pages/quickstart.html)
 * This service is now a placeholder to be replaced by standalone Zipkin.
 * Configure services: spring.zipkin.base-url=http://localhost:9411
 */
@SpringBootApplication
// MIGRATED: @EnableZipkinServer removed - use standalone Zipkin server
public class ServerZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerZipkinApplication.class, args);
	}
}
