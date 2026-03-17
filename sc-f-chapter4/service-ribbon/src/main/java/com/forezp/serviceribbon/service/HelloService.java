package com.forezp.serviceribbon.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker; // MIGRATED: replaced HystrixCommand with Resilience4J CircuitBreaker
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Email miles02@163.com
 *
 * @author fangzhipeng
 * create 2018-07-09
 **/
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @CircuitBreaker(name = "default", fallbackMethod = "hiError") // MIGRATED: replaced @HystrixCommand with Resilience4J @CircuitBreaker
    public String hiService(String name) {
        return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
    }

    public String hiError(String name, Throwable t) { // MIGRATED: added Throwable parameter required by Resilience4J
        return "hi,"+name+",sorry,error!";
    }

}
