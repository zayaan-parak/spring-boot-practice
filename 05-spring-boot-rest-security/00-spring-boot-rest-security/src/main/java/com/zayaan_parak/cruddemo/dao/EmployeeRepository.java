package com.zayaan_parak.cruddemo.dao;

import com.zayaan_parak.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
