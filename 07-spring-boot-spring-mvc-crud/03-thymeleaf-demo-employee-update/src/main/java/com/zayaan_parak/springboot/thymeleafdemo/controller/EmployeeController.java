package com.zayaan_parak.springboot.thymeleafdemo.controller;

import com.zayaan_parak.springboot.thymeleafdemo.entity.Employee;
import com.zayaan_parak.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        return "employees/list-employees";
    }

    // add mapping for add form
    @GetMapping("/showFormForAdd")
    private String showFormForAdd(Model model) {
        // create model attribute to bind form data
        Employee employee = new Employee();

        model.addAttribute("employee", employee);

        return "employees/employee-form";
    }

    @PostMapping("/save")
    private String saveEmployee(@ModelAttribute("employee") Employee employee) {

        // save the employee
        employeeService.save(employee);

        // redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    private String showFormForUpdate(@RequestParam("employeeId") int employeeId, Model model) {

        // get employee from the service using the id
        Employee employee = employeeService.findById(employeeId);

        // set employee as a model attribute to re-populate the form
        model.addAttribute("employee", employee);

        return "employees/employee-form";
    }

    @GetMapping("/delete")
    private String deleteEmployee(@RequestParam("employeeId") int employeeId) {

        // delete employee
        employeeService.deleteById(employeeId);

        // redirect to /employees/list
        return "redirect:/employees/list";
    }
}
