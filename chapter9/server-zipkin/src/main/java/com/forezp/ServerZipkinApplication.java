package com.forezp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer; // MIGRATED: @EnableZipkinServer - NOTE: Embedded Zipkin server removed in Spring Cloud 2020.x; use standalone Zipkin server (https://zipkin.io/pages/quickstart)

@SpringBootApplication
@EnableZipkinServer
public class ServerZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerZipkinApplication.class, args);
	}
}
