package com.example.web;

import lombok.*;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Teachers")
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor

public class Teacher implements CommonEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "teacher_id")
    private Long id;

    @Column(nullable = false, name = "full_name")
    @NonNull
    private String full_name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher other = (Teacher) o;
        return Objects.equals(id, other.id)
                && full_name.equals(other.full_name);
    }

    public @NonNull String getFull_name() {
        return full_name;
    }

    public void setFull_name(@NonNull String full_name) {
        this.full_name = full_name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", full_name='" + full_name + '\'' +
                '}';
    }
}