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
public class Lesson implements CommonEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "lesson_id")
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "lesson_teachers",
            joinColumns = @JoinColumn(name = "lesson_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    @ToString.Exclude
    @NonNull
    private Set<Teacher> teachers;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "lesson_courses",
            joinColumns = @JoinColumn(name = "lesson_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    @ToString.Exclude
    @NonNull
    private Set<Course> courses;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "lesson_auditoriums",
            joinColumns = @JoinColumn(name = "lesson_id"),
            inverseJoinColumns = @JoinColumn(name = "auditorium_id")
    )
    @ToString.Exclude
    @NonNull
    private Set<Auditorium> auditoriums;

    @Column(nullable = false, name = "time")
    @NonNull
    private Long time;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson other = (Lesson) o;
        return Objects.equals(id, other.id)
                && teachers.equals(other.teachers)
                && courses.equals(other.courses)
                && auditoriums.equals(other.auditoriums)
                && time.equals(other.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teachers, courses, auditoriums, time);
    }

    public @NonNull Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(@NonNull Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    public @NonNull Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(@NonNull Set<Course> courses) {
        this.courses = courses;
    }

    public @NonNull Set<Auditorium> getAuditoriums() {
        return auditoriums;
    }

    public void setAuditoriums(@NonNull Set<Auditorium> auditoriums) {
        this.auditoriums = auditoriums;
    }

    public @NonNull Long getTime() {
        return time;
    }

    public void setTime(@NonNull Long time) {
        this.time = time;
    }
}