package com.example.CollegeManagementSystem.DTO;

import com.example.CollegeManagementSystem.Entity.Enums.AdmissionStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AdmissionRecordDto {

    private Long id;

    @NotNull(message = "Fees is required")
    @Positive(message = "Fees must be positive")
    private Long fees;

    @PastOrPresent(message = "Admission date cannot be in the future")
    private LocalDate admissionDate;

    @NotNull(message = "Status is required")
    private AdmissionStatus status;

    @NotNull(message = "Student id is required")
    private Long studentId;
}