package com.example.web.dao;

import com.example.web.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT c FROM Course c WHERE c.id = :courseId")
    Optional<Course> findById(Long courseId);

    @Query("SELECT c FROM Course c")
    List<Course> findAll();
}