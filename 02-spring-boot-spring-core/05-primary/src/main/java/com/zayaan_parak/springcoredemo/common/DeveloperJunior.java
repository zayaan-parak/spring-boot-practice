package com.zayaan_parak.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class DeveloperJunior implements Developer{

    @Override
    public String getDailyTask() {
        return "Download all the essential software";
    }
}
