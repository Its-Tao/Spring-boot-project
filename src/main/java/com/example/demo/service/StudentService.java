package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final List<Student> students = new ArrayList<>();

    public StudentService() {
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
                "Mathematics"
        ));
    }

    // Get all students
    public List<Student> getStudents() {
        return students;
    }

    // Get one student by ID
    public Student getStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    // Add a new student
    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }

    public Student updateStudent(int id, Student updatedStudent) {
    for (Student student : students) {
        if (student.getId() == id) {
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            student.setCourse(updatedStudent.getCourse());

            return student;
        }
    }

    return null;
}
}