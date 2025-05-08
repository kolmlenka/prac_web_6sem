package com.example.web.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import com.example.web.Teacher_course;
import com.example.web.Teacher;
import com.example.web.Course;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class Teacher_courseDAOTest {

    @Autowired
    private Teacher_courseDAO teacher_courseDAO;

    @Test
    void testFindByTeacher_Id() {
        Long teacherId = 1L;

        List<Teacher_course> courses = teacher_courseDAO.getCoursesByTeacherId(teacherId);

        assertThat(courses).hasSize(2);
        assertThat(courses).extracting("name").containsExactlyInAnyOrder("Course 1", "Course 2");
    }

    @Test
    void testFindByNonExistentTeacher_Id() {
        Long nonExistentTeacherId = 999L;

        List<Teacher_course> courses = teacher_courseDAO.getCoursesByTeacherId(nonExistentTeacherId);

        assertThat(courses).isEmpty();
    }
}
