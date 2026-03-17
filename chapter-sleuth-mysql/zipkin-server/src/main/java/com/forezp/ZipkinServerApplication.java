package com.forezp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
// MIGRATED: zipkin.server.EnableZipkinServer and zipkin.storage.mysql.MySQLStorage removed in Spring Boot 3.x
// import zipkin.server.EnableZipkinServer;
// import zipkin.storage.mysql.MySQLStorage;
// MIGRATED: javax.sql.DataSource remains in JDK (not Jakarta), but the embedded Zipkin server is no longer supported
// import javax.sql.DataSource;

@SpringBootApplication
@EnableEurekaClient
// MIGRATED: @EnableZipkinServer removed; run Zipkin as a standalone server (https://zipkin.io/pages/quickstart.html)
// For MySQL storage, configure it in the standalone Zipkin server with STORAGE_TYPE=mysql
public class ZipkinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinServerApplication.class, args);
	}


	// MIGRATED: MySQLStorage bean removed because zipkin.storage.mysql.MySQLStorage was removed in Spring Boot 3.x
	// Configure MySQL storage in the standalone Zipkin server with: STORAGE_TYPE=mysql MYSQL_HOST=... etc.
	/* MIGRATED: commented out - use standalone Zipkin server with MySQL backend instead
	@Bean
	public MySQLStorage mySQLStorage(DataSource datasource) {
		return MySQLStorage.builder().datasource(datasource).executor(Runnable::run).build();
	}
	*/
}
