package com.zayaan_parak.cruddemo.rest;

import com.zayaan_parak.cruddemo.entity.Employee;
import com.zayaan_parak.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // expose "/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAllEmployees() {
        return employeeService.findAll();
    }

    // expose "/employees/{employeeId}" and return an employee matching id
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);

        if (employee == null) {
            throw new RuntimeException("Employee with id " + employeeId + " not found");
        }

        return employee;
    }

    // expose "/employees" to post a new employee and return the added employee + id generated
    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        employee.setId(0);
        Employee savedEmployee = employeeService.save(employee);
        return savedEmployee;
    }

    // expose "/employees" to update an existing employee with details including
    // the id and return the updated employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee updatedEmployee = employeeService.save(employee);

        return updatedEmployee;
    }

    // expose "/employees/{employeeId}" to delete an employee using the id
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee temp = employeeService.findById(employeeId);

        if (temp == null) {
            throw new RuntimeException("Employee with id " + employeeId + " not found");
        }

        employeeService.deleteById(employeeId);

        return "Employee with id " + employeeId + " deleted";
    }
}