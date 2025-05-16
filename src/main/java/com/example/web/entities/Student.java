package com.example.web.entities;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "Students")
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor

public class Student implements CommonEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "student_id")
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id")
    @ToString.Exclude
    @NonNull
    private Stream_group group;

    @Column(nullable = false, name = "full_name")
    @NonNull
    private String full_name;

    @Column(nullable = false, name = "stud_year")
    @NonNull
    private Long year;
}