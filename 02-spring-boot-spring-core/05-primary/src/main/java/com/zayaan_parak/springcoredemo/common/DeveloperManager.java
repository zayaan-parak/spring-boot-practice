package com.zayaan_parak.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class DeveloperManager implements Developer{

    @Override
    public String getDailyTask() {
        return "Help the junior developers";
    }
}
