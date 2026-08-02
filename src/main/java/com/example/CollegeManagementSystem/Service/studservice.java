package com.example.CollegeManagementSystem.Service;

import com.example.CollegeManagementSystem.DTO.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface studservice {
    Optional<StudentDto> getStudentById(Long studentId);

    List<StudentDto> getAllStudents();

    StudentDto addStudent(StudentDto studentDto);


}
