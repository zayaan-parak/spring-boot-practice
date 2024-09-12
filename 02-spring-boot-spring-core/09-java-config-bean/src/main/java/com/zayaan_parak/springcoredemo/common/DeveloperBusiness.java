package com.zayaan_parak.springcoredemo.common;

public class DeveloperBusiness implements Developer{

    public DeveloperBusiness() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyTask() {
        return "Speak to clients and find issues";
    }
}
