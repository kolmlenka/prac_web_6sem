package com.example.web;

import lombok.*;
import jakarta.persistence.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course other = (Course) o;
        return Objects.equals(id, other.id)
                && name.equals(other.name)
                && coverage.equals(other.coverage)
                && intensity.equals(other.intensity)
                && year.equals(other.year);
    }
}