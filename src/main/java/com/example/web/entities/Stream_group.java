package com.example.web.entities;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "Stream_group")
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor

public class Stream_group implements CommonEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "group_id")
    private Long id;

    @Column(nullable = false, name = "stream")
    @NonNull
    private Long stream;
}