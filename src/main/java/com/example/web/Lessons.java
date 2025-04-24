package com.example.web;

import lombok.*;
import jakarta.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Lessons")
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor

public class Lessons implements CommonEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "lesson_id")
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id")
    @ToString.Exclude
    @NonNull
    private Set<Teachers> teachers;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    @ToString.Exclude
    @NonNull
    private Set<Courses> courses;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "auditorium_id")
    @ToString.Exclude
    @NonNull
    private Set<Auditoriums> auditoriums;

    @Column(nullable = false, name = "time")
    @NonNull
    private Long time;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lessons other = (Lessons) o;
        return Objects.equals(id, other.id)
                && teachers.equals(other.teachers)
                && courses.equals(other.courses)
                && auditoriums.equals(other.auditoriums)
                && time.equals(other.time);
    }
}