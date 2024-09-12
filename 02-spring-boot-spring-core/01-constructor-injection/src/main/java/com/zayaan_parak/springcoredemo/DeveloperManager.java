package com.zayaan_parak.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class DeveloperManager implements Developer{
    @Override
    public String getDailyTask() {
        return "Practice Spring Boot for 2 hours!!!!!!!!";
    }
}
