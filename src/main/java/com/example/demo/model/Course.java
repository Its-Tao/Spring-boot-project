package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "lecturer_id")
    private Lecturer lecturer;

    public Course() {
    }

    public Course(int id, String name) {
    this.id = id;
    this.name = name;
}

    public Course(int id, String name ,Lecturer lecturer) {
        this.id = id;
        this.name = name; 
        this.lecturer = lecturer;  
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lecturer getLecturer() {
    return lecturer;
}

     public void setLecturer(Lecturer lecturer) {

    this.lecturer = lecturer;
}
}