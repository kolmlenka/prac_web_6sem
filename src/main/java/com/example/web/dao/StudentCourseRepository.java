package com.example.web.dao;

import com.example.web.Student_course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentCourseRepository extends JpaRepository<Student_course, Long> {

    @Query("SELECT sc FROM Student_course sc WHERE sc.student_id.id = :studentId")
    List<Student_course> findByStudent_id(Long studentId);

    @Modifying
    @Query("DELETE FROM Student_course sc WHERE sc.student_id.id = :studentId")
    int deleteRelation(Long studentId);
}