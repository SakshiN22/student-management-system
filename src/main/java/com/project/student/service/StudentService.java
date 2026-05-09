package com.project.student.service;

import com.project.student.entity.student_entity;
import com.project.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public student_entity saveStudent(student_entity student) {
        return repo.save(student);
    }

    public Page<student_entity> getAllStudents(int page, int size) {
        return repo.findAll(PageRequest.of(page, size));
    }

    public student_entity getStudentById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<student_entity> searchByName(String name) {
        return repo.findByNameContaining(name);
    }

    public void deleteStudent(Long id) {
        repo.deleteById(id);
    }
}