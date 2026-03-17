package com.forezp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// MIGRATED: removed zipkin.server.EnableZipkinServer import (Zipkin 2.x auto-configures via @SpringBootApplication)

@SpringBootApplication
// MIGRATED: removed @EnableZipkinServer (Zipkin 2.x uses auto-configuration)
public class ServerZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerZipkinApplication.class, args);
	}
}
