package com.project.student.repository;

import com.project.student.entity.student_entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface StudentRepository  extends JpaRepository<student_entity, Long> {

        List<student_entity> findByNameContaining(String name);
}

