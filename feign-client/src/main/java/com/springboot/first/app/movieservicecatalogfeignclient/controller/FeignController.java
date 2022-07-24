package com.springboot.first.app.movieservicecatalogfeignclient.controller;

import com.springboot.first.app.movieservicecatalogfeignclient.util.FeignServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Feign")
public class FeignController {

    @Autowired
    private FeignServiceUtil feignServiceUtil;

    @GetMapping("/username")
    public String getUser(){
        return feignServiceUtil.getUser();
    }

}
