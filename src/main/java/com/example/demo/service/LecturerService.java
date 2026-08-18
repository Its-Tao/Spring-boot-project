package com.example.demo.service;

import com.example.demo.model.Lecturer;
import com.example.demo.repository.LecturerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LecturerService {

    private final LecturerRepository lecturerRepository;

    public LecturerService(LecturerRepository lecturerRepository) {
        this.lecturerRepository = lecturerRepository;
    }

    // Create lecturer
    public Lecturer createLecturer(Lecturer lecturer) {
        return lecturerRepository.save(lecturer);
    }

    // Get all lecturers
    public List<Lecturer> getAllLecturers() {
        return lecturerRepository.findAll();
    }

    // Get lecturer by ID
    public Lecturer getLecturerById(int id) {
        return lecturerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lecturer not found"));
    }

    // Update lecturer
    public Lecturer updateLecturer(int id, Lecturer updatedLecturer) {

        Lecturer existingLecturer = lecturerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lecturer not found"));

        existingLecturer.setName(updatedLecturer.getName());
        existingLecturer.setEmail(updatedLecturer.getEmail());
        existingLecturer.setDepartment(updatedLecturer.getDepartment());

        return lecturerRepository.save(existingLecturer);
    }

    // Delete lecturer
    public void deleteLecturer(int id) {

        if (!lecturerRepository.existsById(id)) {
            throw new RuntimeException("Lecturer not found");
        }

        lecturerRepository.deleteById(id);
    }
}