package com.springboot.first.app;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties("attribute") // mapping with attribute values in application.propreties
public class attributeSettings {
    private String value;
    private String list;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }


}
