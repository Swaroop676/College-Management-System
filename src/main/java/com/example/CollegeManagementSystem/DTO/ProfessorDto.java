package com.example.CollegeManagementSystem.DTO;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProfessorDto {

    private Long id;

    @NotBlank(message = "Name is required")
    @Size(max = 50, message = "Name must not exceed 50 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone must be 10 digits")
    private String phone;

    @NotBlank(message = "Department is required")
    private String department;

    private String designation;

    @PastOrPresent(message = "Joining date cannot be in the future")
    private LocalDate joiningDate;

    @PositiveOrZero(message = "Salary cannot be negative")
    private Double salary;

    private Set<Long> subjectIds;   // subjects taught

    private Set<Long> studentIds;   // students mentored/advised
}