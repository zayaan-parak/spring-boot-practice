package com.zayaan_parak.cruddemo.dao;

import com.zayaan_parak.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
