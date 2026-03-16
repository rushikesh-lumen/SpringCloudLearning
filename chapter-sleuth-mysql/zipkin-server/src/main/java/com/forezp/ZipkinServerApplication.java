package com.forezp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
// MIGRATED: import zipkin.server.EnableZipkinServer removed - @EnableZipkinServer deprecated and removed in Zipkin 2.x; Zipkin server now uses Spring Boot autoconfiguration
// MIGRATED: import zipkin.storage.mysql.MySQLStorage removed - MySQLStorage removed in Zipkin 2.x; use io.zipkin.zipkin2:zipkin-storage-mysql-v1 with new API

// MIGRATED: import javax.sql.DataSource removed along with MySQLStorage bean

@SpringBootApplication
@EnableEurekaClient
// MIGRATED: @EnableZipkinServer removed - deprecated and removed in Zipkin 2.x; use Zipkin standalone server or Spring Boot autoconfiguration
public class ZipkinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinServerApplication.class, args);
	}

	// MIGRATED: MySQLStorage bean removed - MySQLStorage API removed in Zipkin 2.x;
	// use io.zipkin.zipkin2:zipkin-storage-mysql-v1 or configure MySQL storage via zipkin.storage.type=mysql properties
}
