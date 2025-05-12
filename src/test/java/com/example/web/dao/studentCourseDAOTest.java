package com.example.web.dao;

import com.example.web.entities.Student_course;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application.properties")
public class studentCourseDAOTest {

    @Autowired
    private StudentCourseDAO studentCourseDAO;

    @Test
    void testFindByStudent_Id() {
        List<Student_course> relations = studentCourseDAO.getCoursesByStudentId(3L);
        assertThat(relations).isNotEmpty();
    }

    @Test
    void testFindByNonExistentTeacher_Id() {
        List<Student_course> relations = studentCourseDAO.getCoursesByStudentId(999L);
        assertThat(relations).isEmpty();
    }

    @Test
    void testDeleteStudentCourseRelation() {
        assertTrue(studentCourseDAO.deleteStudentCourseRelation(2L));
    }
}