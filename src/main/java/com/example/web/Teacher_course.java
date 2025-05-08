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
    private Teacher teacher;

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
                && teacher.equals(other.teacher)
                && course_id.equals(other.course_id)
                && year_of_course.equals(other.year_of_course);
    }

    public @NonNull Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(@NonNull Teacher teacher) {
        this.teacher = teacher;
    }

    public @NonNull Course getCourse_id() {
        return course_id;
    }

    public void setCourse_id(@NonNull Course course_id) {
        this.course_id = course_id;
    }

    public @NonNull Long getYear_of_course() {
        return year_of_course;
    }

    public void setYear_of_course(@NonNull Long year_of_course) {
        this.year_of_course = year_of_course;
    }

    @Override
    public String toString() {
        return "Teacher_course{" +
                "id=" + id +
                ", teacher_id=" + teacher +
                ", course_id=" + course_id +
                ", year_of_course=" + year_of_course +
                '}';
    }
}