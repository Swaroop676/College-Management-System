package com.example.CollegeManagementSystem.Repository;

import com.example.CollegeManagementSystem.Entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}