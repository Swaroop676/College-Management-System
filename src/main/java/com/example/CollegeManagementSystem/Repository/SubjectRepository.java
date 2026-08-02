package com.example.CollegeManagementSystem.Repository;

import com.example.CollegeManagementSystem.Entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}