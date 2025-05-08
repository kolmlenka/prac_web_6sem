package com.example.web.dao;

import com.example.web.Stream_group;
import com.example.web.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class studentDAOTest {

    Student student;

    @Autowired
    private StudentDAO studentDAO;

    @Test
    void testFindByStudent_Id() {
        Long studentID = 4L;
        Optional<Student> students = studentDAO.getStudentById(studentID);
        assertThat(students).isPresent();
    }

    @Test
    void testFindByNonExistingStudent_Id() {
        Long studentID = 111L;
        Optional<Student> students = studentDAO.getStudentById(studentID);
        assertThat(students).isEmpty();
    }

    @Test
    void testFindAllStudents() {
        List<Student> students = studentDAO.getAllStudents();
        assertThat(students).hasSize(6);
    }

    @BeforeEach
    public void setUp() {
        student = new Student();
        student.setId(1L);
        student.setFull_name("Иван Иванов");
        student.setYear(2L);
        Stream_group group = new Stream_group();
        group.setId(101L);
        student.setGroup_id(group);
    }

    @Test
    public void testAddStudent() {
        Stream_group expectedGroup = new Stream_group();
        expectedGroup.setId(101L);

        Student result = studentDAO.addStudent(student);

        assertNotNull(result);
        assertNotNull(result.getId());
        assertEquals("Иван Иванов", result.getFull_name());
        assertEquals(2L, result.getYear());

        assertEquals(expectedGroup.getId(), result.getGroup_id().getId());
    }

    @Test
    public void testUpdateStudent() {
        Student savedStudent = studentDAO.addStudent(student);

        Stream_group updatedGroup = new Stream_group();
        updatedGroup.setId(328L);

        Student updatedStudent = new Student();
        updatedStudent.setFull_name("Иван Иванов");
        updatedStudent.setYear(3L);
        updatedStudent.setGroup_id(updatedGroup);
        Student result = studentDAO.updateStudent(savedStudent.getId(), updatedStudent);

        assertNotNull(result);
        assertEquals(savedStudent.getId(), result.getId());
        assertEquals("Иван Иванов", result.getFull_name());
        assertEquals(3L, result.getYear());
        assertEquals(updatedGroup.getId(), result.getGroup_id().getId());
    }


    //@Test
    //public void testDeleteStudent() {
    //    Student savedStudent = studentDAO.addStudent(student);
    //    studentcourseDAO.deleteCoursesByStudentId(savedStudent.getId());
    //    studentDAO.deleteStudent(savedStudent.getId());
    //    assertFalse(studentDAO.getStudentById(savedStudent.getId()).isPresent());
    //}
}