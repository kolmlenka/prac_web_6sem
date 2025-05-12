package com.example.web.entities;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "Teachers")
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor

public class Teacher implements CommonEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "teacher_id")
    private Long id;

    @Column(nullable = false, name = "full_name")
    @NonNull
    private String full_name;
}