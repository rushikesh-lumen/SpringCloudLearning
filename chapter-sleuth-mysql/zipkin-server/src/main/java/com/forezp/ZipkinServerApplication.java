package com.forezp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient; // MIGRATED: @EnableEurekaClient deprecated in Spring Cloud 2021.x → use @EnableDiscoveryClient
import org.springframework.context.annotation.Bean;
import zipkin.server.EnableZipkinServer; // MIGRATED: @EnableZipkinServer - NOTE: Embedded Zipkin server removed in Spring Cloud 2020.x; use standalone Zipkin server (https://zipkin.io/pages/quickstart)
import zipkin.storage.mysql.MySQLStorage;

import javax.sql.DataSource;

@SpringBootApplication
@EnableDiscoveryClient // MIGRATED: @EnableEurekaClient → @EnableDiscoveryClient (deprecated in Spring Cloud 2021.x)
@EnableZipkinServer
public class ZipkinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinServerApplication.class, args);
	}


	@Bean
	public MySQLStorage mySQLStorage(DataSource datasource) {
		return MySQLStorage.builder().datasource(datasource).executor(Runnable::run).build();
	}
}
