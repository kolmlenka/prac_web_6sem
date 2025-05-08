package com.example.web.dao;

import com.example.web.Student;
import com.example.web.Student_course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class studentCourseDAOTest {

    @Autowired
    private StudentCourseDAO studentCourseDAO;

    @Test
    void testFindByStudent_Id() {
        Student student = new Student();
        student.setId(1L);

        List<Student_course> relations = studentCourseDAO.getCoursesByStudentId(student.getId());
        assertThat(relations).isNotEmpty();
    }

    @Test
    void testFindByNonExistentTeacher_Id() {
        Student student = new Student();
        student.setId(999L);

        List<Student_course> relations = studentCourseDAO.getCoursesByStudentId(student.getId());
        assertThat(relations).isEmpty();
    }


    @Test
    void testDeleteStudentCourseRelation() {
        Student student = new Student();
        student.setId(1L);
        assertTrue(studentCourseDAO.deleteStudentCourseRelation(student.getId()));
    }
}