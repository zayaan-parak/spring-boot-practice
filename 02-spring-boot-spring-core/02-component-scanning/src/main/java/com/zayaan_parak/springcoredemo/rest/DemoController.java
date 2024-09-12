package com.zayaan_parak.springcoredemo.rest;

import com.zayaan_parak.springcoredemo.common.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Developer myDev;

    //If you only have 1 constructor autowired is optional
    @Autowired
    public DemoController(Developer myDev) {
        this.myDev = myDev;
    }

    @GetMapping("/dailyTask")
    public String getDailyTask(){
        return myDev.getDailyTask();
    }


}
