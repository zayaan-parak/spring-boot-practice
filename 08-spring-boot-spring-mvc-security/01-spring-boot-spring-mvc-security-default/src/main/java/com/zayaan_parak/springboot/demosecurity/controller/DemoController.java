package com.zayaan_parak.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome() {

        return "home";
    }

    @GetMapping("/leaders")
    public String showLeaderPage() {

        return "leader-page";
    }

    @GetMapping("/systems")
    public String showSystemPage() {

        return "system-page";
    }

    @GetMapping("/employees")
    public String showEmployeePage() {

        return "employee-page";
    }
}