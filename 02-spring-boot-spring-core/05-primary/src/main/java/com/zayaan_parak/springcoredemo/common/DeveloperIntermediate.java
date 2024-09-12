package com.zayaan_parak.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class DeveloperIntermediate implements Developer{

    @Override
    public String getDailyTask() {
        return "Continue with project assigned";
    }
}
