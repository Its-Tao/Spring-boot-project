package com.example.demo.controller;

import com.example.demo.model.Lecturer;
import com.example.demo.service.LecturerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lecturers")
public class LecturerController {

    private final LecturerService lecturerService;

    public LecturerController(LecturerService lecturerService) {
        this.lecturerService = lecturerService;
    }

    // Create lecturer
    @PostMapping
    public Lecturer createLecturer(@RequestBody Lecturer lecturer) {
        return lecturerService.createLecturer(lecturer);
    }

    // Get all lecturers
    @GetMapping
    public List<Lecturer> getAllLecturers() {
        return lecturerService.getAllLecturers();
    }

    // Get lecturer by ID
    @GetMapping("/{id}")
    public Lecturer getLecturerById(@PathVariable int id) {
        return lecturerService.getLecturerById(id);
    }

    // Update lecturer
    @PutMapping("/{id}")
    public Lecturer updateLecturer(
            @PathVariable int id,
            @RequestBody Lecturer lecturer) {

        return lecturerService.updateLecturer(id, lecturer);
    }

    // Delete lecturer
    @DeleteMapping("/{id}")
    public String deleteLecturer(@PathVariable int id) {

        lecturerService.deleteLecturer(id);

        return "Lecturer deleted successfully";
    }
}