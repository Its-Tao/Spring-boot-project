package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    private List<Student> students = new ArrayList<>();

    public StudentController() {
        students.add(new Student(
                1,
                "John",
                "john@gmail.com",
                "Software Engineering"
        ));

        students.add(new Student(
                2,
                "Mary",
                "mary@gmail.com",
                "Computer Science"
        ));

        students.add(new Student(
                3,
                "Peter",
                "peter@gmail.com",
                "mathematics"
        ));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }
}