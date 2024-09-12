package com.zayaan_parak.springcoredemo.rest;

import com.zayaan_parak.springcoredemo.common.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Developer myDev;
    private Developer secondDev;

    @Autowired
    public DemoController(@Qualifier("developerSenior") Developer myDev, @Qualifier("developerJunior") Developer secondDev) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.myDev = myDev;
        this.secondDev = secondDev;
    }

    @GetMapping("/check")
    public String check(){
        return "Comparing beans: myDev == secondDev, " + (myDev == secondDev);
    }

    @GetMapping("/dailyTask")
    public String getDailyTask(){
        return myDev.getDailyTask();
    }
}
