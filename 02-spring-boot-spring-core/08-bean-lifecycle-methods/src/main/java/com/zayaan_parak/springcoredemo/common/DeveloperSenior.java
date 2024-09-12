package com.zayaan_parak.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class DeveloperSenior implements Developer{
    public DeveloperSenior() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyTask() {
        return "Fix bugs in banking api file";
    }
}
