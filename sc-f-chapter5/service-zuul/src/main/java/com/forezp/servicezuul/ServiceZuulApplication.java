package com.forezp.servicezuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
// MIGRATED: removed EnableZuulProxy import (Spring Cloud Gateway replaces Zuul)

@SpringBootApplication
// MIGRATED: removed @EnableZuulProxy (Spring Cloud Gateway is auto-configured)
@EnableEurekaClient
@EnableDiscoveryClient
public class ServiceZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run( ServiceZuulApplication.class, args );
    }
}
