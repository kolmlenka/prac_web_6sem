package com.example.web.dao;

import com.example.web.entities.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class CourseDAOTest {

    @Autowired
    private CourseDAO courseDAO;

    @Test
    void testFindByCourse_Id() {
        Long courseId = 2L;
        Optional<Course> courses = courseDAO.getCourseById(courseId);
        assertThat(courses).isPresent();
    }

    @Test
    void testFindByNonExistingCourse_Id() {
        Long courseId = 13L;
        Optional<Course> courses = courseDAO.getCourseById(courseId);
        assertThat(courses).isEmpty();
    }

    @Test
    void testFindAll() {
        List<Course> courses = courseDAO.getAllCourses();
        assertThat(courses).hasSize(7);
    }
}