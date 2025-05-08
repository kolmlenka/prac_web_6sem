package com.example.web;

import lombok.*;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Students")
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor

public class Student implements CommonEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "student_id")
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id")
    @ToString.Exclude
    @NonNull
    private Stream_group group_id;

    @Column(nullable = false, name = "full_name")
    @NonNull
    private String full_name;

    @Column(nullable = false, name = "year")
    @NonNull
    private Long year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student other = (Student) o;
        return Objects.equals(id, other.id)
                && group_id.equals(other.group_id)
                && full_name.equals(other.full_name)
                && year.equals(other.year);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", group_id=" + group_id +
                ", full_name='" + full_name + '\'' +
                ", year=" + year +
                '}';
    }

    public @NonNull Stream_group getGroup_id() {
        return group_id;
    }

    public void setGroup_id(@NonNull Stream_group group_id) {
        this.group_id = group_id;
    }

    public @NonNull String getFull_name() {
        return full_name;
    }

    public void setFull_name(@NonNull String full_name) {
        this.full_name = full_name;
    }

    public @NonNull Long getYear() {
        return year;
    }

    public void setYear(@NonNull Long year) {
        this.year = year;
    }
}