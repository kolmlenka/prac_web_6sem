package com.example.web.entities;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "Courses")
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor

public class Course implements CommonEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "course_id")
    private Long id;

    @Column(nullable = false, name = "course_name")
    @NonNull
    private String name;

    @Column(name = "coverage")
    @NonNull
    private String coverage;

    @Column(name = "intensity")
    @NonNull
    private Long intensity;

    @Column(nullable = false, name = "for_what_year")
    @NonNull
    private Long year;
}