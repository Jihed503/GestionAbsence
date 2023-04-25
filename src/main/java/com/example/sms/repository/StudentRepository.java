package com.example.sms.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sms.entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Page<Student> findByNameContains(String firstName, Pageable pageable);
    List<Student> findByClasse(String classe);
}
