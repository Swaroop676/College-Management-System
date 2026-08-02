package com.example.CollegeManagementSystem.Repository;

import com.example.CollegeManagementSystem.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}