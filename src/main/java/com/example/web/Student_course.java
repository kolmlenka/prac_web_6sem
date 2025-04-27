package com.example.web;

import lombok.*;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Students_courses")
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor

public class Student_course implements CommonEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    @ToString.Exclude
    @NonNull
    private Student student_id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    @ToString.Exclude
    @NonNull
    private Course course_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student_course other = (Student_course) o;
        return Objects.equals(id, other.id)
                && student_id.equals(other.student_id)
                && course_id.equals(other.course_id);
    }
}