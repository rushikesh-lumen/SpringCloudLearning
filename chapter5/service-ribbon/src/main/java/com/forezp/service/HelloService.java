package com.forezp.service;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker; // MIGRATED: HystrixCommand -> CircuitBreaker
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

    @CircuitBreaker(name = "hiError", fallbackMethod = "hiError") // MIGRATED: @HystrixCommand -> @CircuitBreaker
    public String hiService(String name) {
        return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}
