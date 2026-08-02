package com.example.CollegeManagementSystem.Controller;

import com.example.CollegeManagementSystem.DTO.StudentDto;
import com.example.CollegeManagementSystem.Entity.Student;
import com.example.CollegeManagementSystem.Entity.Subject;
import com.example.CollegeManagementSystem.RescouceException.ResourceNotFoundException;
import com.example.CollegeManagementSystem.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/Student")
public class StudentContoller {
    private final StudentService studentService;

    public StudentContoller(StudentService studentService) {
        this.studentService = studentService;
    }//Dependency Injection
    @GetMapping(path  = "/{studentId}")
    public ResponseEntity<StudentDto> getAllStudent(@PathVariable (name = "studentId")Long studentId) {
        Optional<StudentDto> studentDtoOptinal = studentService.getStudentById(studentId);
        return studentDtoOptinal.map(student -> ResponseEntity.ok(student)).orElseThrow(() -> new ResourceNotFoundException("Student with ID:"+studentId + "not found" ));
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }


    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
        StudentDto savedStudent = studentService.addStudent(studentDto);
        return  new ResponseEntity<>(savedStudent , HttpStatus.CREATED);
    }

    @PutMapping(path = "/{studentId}")
    public StudentDto updateStudent(@PathVariable (name = "studentId") Long studentId, @RequestBody StudentDto studentDto) {
        return studentService.updatedStudent();
    }

    @DeleteMapping(path = ("/{studentId}"))
    public ResponseEntity<Boolean> deleteStudent(@PathVariable (name = "studentId") Long studentId) {
        boolean gotDeleted = StudentService.deleteStudent();
        if(gotDeleted) return  ResponseEntity.ok(true);
        else return  ResponseEntity.notFound().build();
    }

    @PostMapping(path = ("/{Subjects}"))
    public ResponseEntity<Subject> addSubjectsToStudents(@PathVariable (name = "Subjects") String subjects) {}
}
