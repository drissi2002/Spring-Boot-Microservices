package com.springboot.first.app.movieservicecatalogfeignclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MovieServiceCatalogFeignClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieServiceCatalogFeignClientApplication.class, args);
    }

}
