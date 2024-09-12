package com.zayaan_parak.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class DeveloperIntermediate implements Developer{

    public DeveloperIntermediate() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyTask() {
        return "Continue with project assigned";
    }
}
