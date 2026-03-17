package com.forezp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// MIGRATED: zipkin.server.EnableZipkinServer removed in Spring Boot 3.x; Zipkin server is now a standalone service
// import zipkin.server.EnableZipkinServer;

@SpringBootApplication
// MIGRATED: @EnableZipkinServer removed; run Zipkin as a standalone server (https://zipkin.io/pages/quickstart.html)
public class ServerZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerZipkinApplication.class, args);
	}
}
