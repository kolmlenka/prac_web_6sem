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

public class Students implements CommonEntity<Long> {

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
        Students other = (Students) o;
        return Objects.equals(id, other.id)
                && group_id.equals(other.group_id)
                && full_name.equals(other.full_name)
                && year.equals(other.year);
    }
}