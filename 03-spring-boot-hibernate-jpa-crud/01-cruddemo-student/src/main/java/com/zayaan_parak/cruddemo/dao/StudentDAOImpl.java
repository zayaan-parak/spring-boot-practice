package com.zayaan_parak.cruddemo.dao;

import com.zayaan_parak.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    // define field for entity manager

    private EntityManager entityManager;


    // inject entity manager using constructor injection

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    // implement the save method

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }


    // implement find by id method
    // no need for @Transactional as it is just a query

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }


    // implement find all method

    @Override
    public List<Student> findAll() {
        // create query
                                                                  //by default order by is asc.
        TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);


        // return query results

        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        // create query

        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName=:data", Student.class);


        // set query parameter

        query.setParameter("data", lastName);


        // return query results

        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();

        return numRowsDeleted;
    }
}
