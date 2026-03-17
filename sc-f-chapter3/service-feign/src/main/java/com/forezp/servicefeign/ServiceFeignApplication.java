package com.forezp.servicefeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient; // MIGRATED: @EnableEurekaClient deprecated → using existing @EnableDiscoveryClient import
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
// MIGRATED: @EnableEurekaClient removed (replaced by @EnableDiscoveryClient below)
@EnableDiscoveryClient
@EnableFeignClients
public class ServiceFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run( ServiceFeignApplication.class, args );
    }
}
