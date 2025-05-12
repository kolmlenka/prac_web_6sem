package com.example.web.dao;

import com.example.web.entities.Teacher_course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Teacher_courseDAO {

    private final TeacherCourseRepository teacherCourseRepository;

    @Autowired
    public Teacher_courseDAO(TeacherCourseRepository teacherCourseRepository) {
        this.teacherCourseRepository = teacherCourseRepository;
    }

    public List<Teacher_course> getCoursesByTeacherId(Long teacherId) {
        return teacherCourseRepository.findByTeacher_Id(teacherId);
    }
}