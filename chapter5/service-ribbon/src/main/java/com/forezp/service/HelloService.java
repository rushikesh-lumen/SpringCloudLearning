package com.forezp.service;


// MIGRATED: HystrixCommand removed in Spring Cloud 2020.x, replaced with Resilience4J CircuitBreaker
// import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker; // MIGRATED: Resilience4J CircuitBreaker replaces HystrixCommand
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by fangzhipeng on 2017/4/6.
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @CircuitBreaker(name = "default", fallbackMethod = "hiError") // MIGRATED: @HystrixCommand replaced with @CircuitBreaker (Resilience4J)
    public String hiService(String name) {
        return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}
