package com.project.student.controller;

import com.project.student.entity.student_entity;
import com.project.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public student_entity addStudent(@RequestBody student_entity student) {
        return service.saveStudent(student);
    }

    @GetMapping
    public Page<student_entity> getAll(@RequestParam int page, @RequestParam int size) {
        return service.getAllStudents(page, size);
    }

    @GetMapping("/{id}")
    public student_entity getById(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    @GetMapping("/search")
    public List<student_entity> search(@RequestParam String name) {
        return service.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteStudent(id);
        return "Deleted Successfully";
    }
}