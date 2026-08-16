package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.model.Course;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.exception.StudentNotFoundException;

@Service
public class StudentService {

    private final List<Student> students = new ArrayList<>();

    public StudentService() {

        Course softwareEngineering = new Course(1, "Software Engineering");
        Course computerScience = new Course(2, "Computer Science");
        Course mathematics = new Course(3, "Mathematics");

        students.add(new Student(
                1,
                "John",
                "john@gmail.com",
                softwareEngineering
        ));

        students.add(new Student(
                2,
                "Mary",
                "mary@gmail.com",
                computerScience
        ));

        students.add(new Student(
                3,
                "Peter",
                "peter@gmail.com",
                mathematics
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

        throw new StudentNotFoundException(
                "Student with id " + id + " not found"
        );
    }

    // Add a new student
    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }

    // Update student
    public Student updateStudent(int id, Student updatedStudent) {
        for (Student student : students) {
            if (student.getId() == id) {

                student.setName(updatedStudent.getName());
                student.setEmail(updatedStudent.getEmail());
                student.setCourse(updatedStudent.getCourse());

                return student;
            }
        }

        throw new StudentNotFoundException(
                "Student with id " + id + " not found"
        );
    }
}