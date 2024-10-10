package com.zayaan_parak.springboot.thymeleafdemo.controller;

import com.zayaan_parak.springboot.thymeleafdemo.entity.Employee;
import com.zayaan_parak.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // add mapping for listing employees
    @GetMapping("/list")
    private String listEmployees(Model model) {

        // get the employees from the db
        List<Employee> employees = employeeService.findAll();

        // add employees to the spring model
        model.addAttribute("employees", employees);

        return "list-employees";
    }
}
