package com.zayaan_parak.cruddemo.dao;

import com.zayaan_parak.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        // create query
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);

        // execute the query
        List<Employee> employees = query.getResultList();

        // return the results
        return employees;
    }

    @Override
    public Employee findById(int id) {
        // get employee
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        // save or update depending on the employee id - if zero it will be an insert else it will be an update
        Employee savedEmployee = entityManager.merge(employee);
        return savedEmployee;
    }

    @Override
    public void deleteById(int id) {
        // find employee
        Employee employee = entityManager.find(Employee.class, id);

        // remove the employee
        entityManager.remove(employee);
    }
}