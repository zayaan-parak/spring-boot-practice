package com.zayaan_parak.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    // a controller method to show initial HTML form
    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    // a controller method to read form data
    @RequestMapping("/processFormV2")
    public String shout(HttpServletRequest request, Model model){

        // read the request parameter from HTML form
        String name = request.getParameter("studentName");

        // convert the data to all caps
        name = name.toUpperCase();

        // create the message

        String result = "YO! " + name;

        // add the message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }

    @PostMapping("/processFormV3")
    public String processFormV3(@RequestParam("studentName") String name, Model model){

        // convert the data to all caps
        name = name.toUpperCase();

        // create the message

        String result = "Welcome Back " + name;

        // add the message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }
}
