package com.example.web.dao;

import com.example.web.dao.CourseRepository;
import com.example.web.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CourseDAO {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseDAO(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }
}