package com.example.CollegeManagementSystem.Entity;


import com.example.CollegeManagementSystem.Entity.Enums.AdmissionStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class AdmisionRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long fees;

    private LocalDate admissionDate;

    @Enumerated(EnumType.STRING)
    private AdmissionStatus status;   // enum: PENDING, CONFIRMED, CANCELLED

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "student_id")
    private Student student;
}