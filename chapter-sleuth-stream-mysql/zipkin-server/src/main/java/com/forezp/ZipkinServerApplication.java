package com.forezp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * MIGRATED: Embedded Zipkin server removed from Spring Cloud Sleuth 3.x.
 * To use Zipkin: run the standalone Zipkin server (https://zipkin.io/pages/quickstart.html)
 * This service is now a placeholder application to be replaced by standalone Zipkin.
 * Configure services to send traces using: spring.zipkin.base-url=http://localhost:9411
 */
@SpringBootApplication
@EnableDiscoveryClient // MIGRATED: @EnableEurekaClient -> @EnableDiscoveryClient
public class ZipkinServerApplication {

public static void main(String[] args) {
SpringApplication.run(ZipkinServerApplication.class, args);
}
}
