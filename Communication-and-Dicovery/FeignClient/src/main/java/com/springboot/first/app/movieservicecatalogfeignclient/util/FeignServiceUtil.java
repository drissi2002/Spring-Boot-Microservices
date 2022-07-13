package com.springboot.first.app.movieservicecatalogfeignclient.util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value="ratting-service",url="http://localhost:8083/ratting")
public interface FeignServiceUtil {

    @GetMapping("/user")
    String getUser();

}
