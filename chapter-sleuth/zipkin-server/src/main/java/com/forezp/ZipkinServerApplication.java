package com.forezp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
// MIGRATED: removed zipkin.server.EnableZipkinServer import (Zipkin 2.x auto-configures via @SpringBootApplication)

@SpringBootApplication
@EnableEurekaClient
// MIGRATED: removed @EnableZipkinServer (Zipkin 2.x uses auto-configuration)
public class ZipkinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinServerApplication.class, args);
	}
}
