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

    public @NonNull String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public @NonNull String getCoverage() {
        return coverage;
    }

    public void setCoverage(@NonNull String coverage) {
        this.coverage = coverage;
    }

    public @NonNull Long getIntensity() {
        return intensity;
    }

    public void setIntensity(@NonNull Long intensity) {
        this.intensity = intensity;
    }

    public @NonNull Long getYear() {
        return year;
    }

    public void setYear(@NonNull Long year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coverage='" + coverage + '\'' +
                ", intensity=" + intensity +
                ", year=" + year +
                '}';
    }
}