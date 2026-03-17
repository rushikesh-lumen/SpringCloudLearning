package com.forezp;


import org.springframework.boot.autoconfigure.SpringBootApplication;
// MIGRATED: removed unused SpringApplicationBuilder import
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ConsulMiyaApplication {

	@RequestMapping("/hi")
	public String home() {
		return "hi ,i'm miya";
	}

	public static void main(String[] args) {
		SpringApplication.run(ConsulMiyaApplication.class, args); // MIGRATED: replaced SpringApplicationBuilder.web(boolean) which was removed in Spring Boot 2.x
	}
}
