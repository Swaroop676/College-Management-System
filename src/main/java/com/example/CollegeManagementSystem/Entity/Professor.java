package com.example.CollegeManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String phone;

    private String department;      // e.g. "Computer Science"

    private String designation;     // e.g. "Assistant Professor"

    private LocalDate joiningDate;

    private Double salary;

    @OneToMany(mappedBy = "professor")
    private Set<Subject> subjects = new HashSet<>();//Inverse Side

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "student_professor",
            joinColumns = @JoinColumn(name = "professor_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> students = new HashSet<>();//Owner side
}

//joinColumns
//Points to the entity that owns this side of the relationship — i.e., the entity in the class where you wrote this annotation.
//
//        java
//        name = "professor_id"
//
//This column in student_professor holds the foreign key referencing the Professor table's primary key.
//
//inverseJoinColumns
//
//Points to the other (inverse) entity — the one on the opposite side of the relationship.
//
//        java
//        name = "student_id"
//
//This column in student_professor holds the foreign key referencing the Student table's primary key.
//
//Putting it together
//
//This annotation would typically sit inside the Professor entity, like:
//So the resulting join table looks like:
//
//professor_id	student_id
//1	            5
//1	            7
//2	            5