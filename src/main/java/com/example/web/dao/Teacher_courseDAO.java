package com.example.web.dao;

import com.example.web.Teacher_course;
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

    public Teacher_course save(Teacher_course course) {
        return teacherCourseRepository.save(course);
    }

    public void deleteAll() {
        teacherCourseRepository.deleteAll();
    }
}