package com.springboot.first.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class  MovieServiceCatalogApplication {

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	//@Bean
	/*public WebClient.Builder getWebBuilder(){
		return WebClient.builder();
	}*/

	public static void main(String[] args) {
		SpringApplication.run(MovieServiceCatalogApplication.class, args);
	}

}
