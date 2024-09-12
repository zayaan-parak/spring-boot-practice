package com.zayaan_parak.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class DeveloperIntermediate implements Developer{

    @Override
    public String getDailyTask() {
        return "Continue with project assigned";
    }
}
