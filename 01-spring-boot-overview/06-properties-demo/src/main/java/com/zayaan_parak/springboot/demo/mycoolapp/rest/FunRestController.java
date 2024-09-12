package com.zayaan_parak.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    // Exposing endpoints to return values on my browser

    // expose "/" that returns Hello World
    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }

    // expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a hard 5k!";
    }

    // expose a new endpoint for "fortune"
    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is your lucky day";
    }

   // expose a new endpoint for "car"
    @GetMapping("/car")
    public String getDailyCar(){
        return "Porsche";
    }

    // expose another endpoint for "jet"
    @GetMapping("/jet")
    public String getDailyJet(){
        return "F22-Raptor";
    }


    // Inject properties for: dev.name and team.name

    @Value("${dev.name}")
    private String devName;

    @Value("${team.name}")
    private String teamName;

    @Value("${role.name}")
    private String roleName;

    // exposing a new endpoint for "teamInfo"
    @GetMapping("/teamInfo")
    private String getTeamInfo(){
        return "Developer Name: " + devName + " | Role: " + roleName +" | Team Name: " + teamName;
    }

}
