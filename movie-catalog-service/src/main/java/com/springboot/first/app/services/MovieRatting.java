package com.springboot.first.app.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.springboot.first.app.Catalog;
import com.springboot.first.app.MovieSummary;
import com.springboot.first.app.Ratting;
import com.springboot.first.app.UserRatting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class MovieRatting {

    @Autowired
    RestTemplate restTemplate ;

    @HystrixCommand(fallbackMethod = "getFallbackRatting" ,
            commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="200"), // timeout
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "5"),            // number of request that we need to see
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "50"),         // percentage of request that failled
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "5000")       // how long the circuit breaker is going to sleep before getting sleep again
            }
    )
    public UserRatting getUserRatting(@PathVariable("userId") String userId){
        return restTemplate.getForObject("http://movie-ratting-service/ratting/user/" + userId, UserRatting.class);
    }
    private UserRatting getFallbackRatting(@PathVariable("userId") String userId){
        UserRatting userRatting = new UserRatting();
        Ratting ratting = new Ratting("",0);
        userRatting.setUserId(userId);
        userRatting.setUserRatting(Collections.singletonList(ratting));
        return userRatting;
    }
}
