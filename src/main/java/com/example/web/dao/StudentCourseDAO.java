package com.example.web.dao;

import com.example.web.entities.Student_course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCourseDAO {

    private final StudentCourseRepository studentCourseRepository;

    @Autowired
    public StudentCourseDAO(StudentCourseRepository studentCourseRepository) {
        this.studentCourseRepository = studentCourseRepository;
    }

    public List<Student_course> getCoursesByStudentId(Long studentId) {
        return studentCourseRepository.findByStudent_id(studentId);
    }

    public boolean deleteStudentCourseRelation(Long studentId) {
        int deletedCount = studentCourseRepository.deleteRelation(studentId);
        return deletedCount > 0;
    }
}