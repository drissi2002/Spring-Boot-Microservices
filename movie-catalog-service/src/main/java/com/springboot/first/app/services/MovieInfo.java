package com.springboot.first.app.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.springboot.first.app.Catalog;
import com.springboot.first.app.MovieSummary;
import com.springboot.first.app.Ratting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfo {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackMovieCatalog",
            threadPoolKey = "movieInfoPool", // bulkhead concept (sperate the thread pool between microservices to avoid issues when things slow down )
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize",value = "20"),     // thread pool size for the bulkhead
                    @HystrixProperty(name="maxQueueSize", value = "10") // threads that are waiting to be consumed
            }
    )
    public Catalog getMovieCatalog(Ratting ratting){
        MovieSummary movie = restTemplate.getForObject("http://movie-info-service/movies/"+ ratting.getMovieId(),MovieSummary.class);
        return new Catalog(movie.getTitle(),movie.getOverview(),ratting.getRating());
    }
    private Catalog getFallbackMovieCatalog(Ratting ratting){
        return new Catalog("Movie name not found","", ratting.getRating());
    }
}
