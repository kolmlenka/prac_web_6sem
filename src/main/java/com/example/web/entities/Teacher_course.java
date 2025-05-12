package com.example.web.entities;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "Teachers_courses")
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor

public class Teacher_course implements CommonEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id")
    @ToString.Exclude
    @NonNull
    private Teacher teacher;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    @ToString.Exclude
    @NonNull
    private Course course_id;

    @Column(nullable = false, name = "year_of_course")
    @NonNull
    private Long year_of_course;
}