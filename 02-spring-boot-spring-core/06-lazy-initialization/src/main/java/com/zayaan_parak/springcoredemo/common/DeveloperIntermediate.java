package com.zayaan_parak.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Lazy       //for a single lazy class, for all you need to add it in the application properties
public class DeveloperIntermediate implements Developer{

    public DeveloperIntermediate() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyTask() {
        return "Continue with project assigned";
    }
}
