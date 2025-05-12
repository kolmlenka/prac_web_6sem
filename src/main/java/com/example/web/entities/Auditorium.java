package com.example.web.entities;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "Auditoriums")
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor

public class Auditorium implements CommonEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "auditorium_id")
    private Long id;

    @Column(nullable = false, name = "aud_number")
    @NonNull
    private Integer number;

    @Column(name = "capacity")
    @NonNull
    private Integer capacity;
}