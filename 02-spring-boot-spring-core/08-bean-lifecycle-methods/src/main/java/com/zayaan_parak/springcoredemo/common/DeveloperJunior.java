package com.zayaan_parak.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class DeveloperJunior implements Developer{

    public DeveloperJunior() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyTask() {
        return "Download all the essential software";
    }

    // define our init method
    @PostConstruct
    public void startUp(){
        System.out.println("Startup(): " + getClass().getSimpleName());
    }

    // define our destroy method
    @PreDestroy
    public void cleanUp(){
        System.out.println("Cleanup(): " + getClass().getSimpleName());
    }
}
