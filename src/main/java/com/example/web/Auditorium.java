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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auditorium other = (Auditorium) o;
        return Objects.equals(id, other.id)
                && number.equals(other.number)
                && capacity.equals(other.capacity);
    }

    public @NonNull Integer getNumber() {
        return number;
    }

    public void setNumber(@NonNull Integer number) {
        this.number = number;
    }

    public @NonNull Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(@NonNull Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Auditorium{" +
                "id=" + id +
                ", number=" + number +
                ", capacity=" + capacity +
                '}';
    }
}