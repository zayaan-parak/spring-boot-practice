package com.zayaan_parak.demo.rest;

import com.zayaan_parak.demo.entity.Student;
import com.zayaan_parak.demo.exceptionHandling.StudentErrorResponse;
import com.zayaan_parak.demo.exceptionHandling.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    List<Student> students;

    // define @PostConstruct to load the student data - only once
    @PostConstruct
    public void loadStudents() {
        students = new ArrayList<>();

        students.add(new Student("Zayaan", "Parak"));
        students.add(new Student("Moe", "Akoojee"));
        students.add(new Student("Zahara", "Parak"));
    }

    // define endpoint for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {

        return students;
    }

    // define endpoint for "/students/{studentId} - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        // check the studentId against the list size
        if ((studentId >= students.size()) || (studentId < 0)){
            throw new StudentNotFoundException("Student with id " + studentId + " not found");
        }

        // index into the list and get student from the list with id that matches the index
        return students.get(studentId);
    }
}