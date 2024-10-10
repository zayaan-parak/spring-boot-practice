package com.zayaan_parak.springboot.thymeleafdemo.dao;

import com.zayaan_parak.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // add method to sort by last name
    public List<Employee> findAllByOrderByLastNameAsc();
}
