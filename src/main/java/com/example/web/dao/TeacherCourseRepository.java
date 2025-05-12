package com.example.web.dao;

import com.example.web.entities.Teacher_course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherCourseRepository extends JpaRepository<Teacher_course, Long> {

    @Query("SELECT tc FROM Teacher_course tc WHERE tc.teacher.id = :teacherId")
    List<Teacher_course> findByTeacher_Id(Long teacherId);
}