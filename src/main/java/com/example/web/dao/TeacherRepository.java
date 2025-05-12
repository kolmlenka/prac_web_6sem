package com.example.web.dao;

import com.example.web.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("SELECT t FROM Teacher t WHERE t.id = :teacherId")
    Optional<Teacher> findById(Long teacherId);

    @Query("SELECT t FROM Teacher t")
    List<Teacher> findAll();
}