package com.zayaan_parak.springboot.thymeleafdemo.controller;

import com.zayaan_parak.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${genders}")
    private List<String> genders;

    @Value("${languages}")
    private List<String> languages;

    @Value("${systems}")
    private List<String> systems;

    @GetMapping("/showStudentForm")
    public String showForm(Model model) {

        // create a student object
        Student student = new Student();

        // add student object to the model
        model.addAttribute("student", student);

        // add the list of countries to the model
        model.addAttribute("countries", countries);

        // add the list of languages to the model
        model.addAttribute("languages", languages);

        // add the list of systems to the model
        model.addAttribute("systems", systems);

        // add the list of genders to the model
        model.addAttribute("gender", genders);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student student) {

        // log the input data
        System.out.println("The student: " + student.getFirstName() + " " + student.getLastName());
        System.out.println("Student Country: " + student.getCountry());
        System.out.println("Gender: " + student.getGender());
        System.out.println("Languages: " + student.getFavouriteLanguage());
        System.out.println("Systems: " +student.getFavouriteSystems().toString());

        return "student-confirmation";
    }
}