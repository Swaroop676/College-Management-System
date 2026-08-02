package com.example.CollegeManagementSystem.Service;

import com.example.CollegeManagementSystem.DTO.StudentDto;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements studservice {

    @Override
    public Optional<StudentDto> getStudentById(Long studentId) {
        return Optional.empty();
    }

    @Override
    public List<StudentDto> getAllStudents() {
        return List.of();
    }

    @Override
    public StudentDto addStudent(StudentDto studentDto) {
        return null;
    }


}
