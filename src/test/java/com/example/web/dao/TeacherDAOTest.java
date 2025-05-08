package com.example.web.dao;

import com.example.web.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class TeacherDAOTest {

    @Autowired
    private TeacherDAO teacherDAO;

    @Test
    void testFindByTeacher_Id() {
        Long teacherId = 1L;

        Optional<Teacher> teachers = teacherDAO.getTeacherById(teacherId);

        assertThat(teachers).isPresent();
    }

    @Test
    void testFindByNonExistingTeacher_Id() {
        Long teacherId = 22L;

        Optional<Teacher> teachers = teacherDAO.getTeacherById(teacherId);

        assertThat(teachers).isEmpty();
    }

    @Test
    void testFindAll() {
        List<Teacher> courses = teacherDAO.getAllTeachers();

        assertThat(courses).hasSize(9);
    }
}