package com.forezp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// MIGRATED: import zipkin.server.EnableZipkinServer removed - @EnableZipkinServer deprecated and removed in Zipkin 2.x; Zipkin server now uses Spring Boot autoconfiguration

@SpringBootApplication
// MIGRATED: @EnableZipkinServer removed - deprecated and removed in Zipkin 2.x; use Zipkin standalone server or Spring Boot autoconfiguration
public class ServerZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerZipkinApplication.class, args);
	}
}
