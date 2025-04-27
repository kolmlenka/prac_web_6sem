package com.example.web;

import lombok.*;
import jakarta.persistence.*;
import java.util.Objects;

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
    private Teacher teacher_id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    @ToString.Exclude
    @NonNull
    private Course course_id;

    @Column(nullable = false, name = "year_of_course")
    @NonNull
    private Long year_of_course;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher_course other = (Teacher_course) o;
        return Objects.equals(id, other.id)
                && teacher_id.equals(other.teacher_id)
                && course_id.equals(other.course_id)
                && year_of_course.equals(other.year_of_course);
    }
}