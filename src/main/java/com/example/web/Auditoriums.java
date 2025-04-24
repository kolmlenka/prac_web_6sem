package com.example.web;

import lombok.*;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Auditoriums")
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor

public class Auditoriums implements CommonEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "auditorium_id")
    private Long id;

    @Column(nullable = false, name = "aud_number")
    @NonNull
    private Long number;

    @Column(name = "capacity")
    @NonNull
    private Long capacity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auditoriums other = (Auditoriums) o;
        return Objects.equals(id, other.id)
                && number.equals(other.number)
                && capacity.equals(other.capacity);
    }
}