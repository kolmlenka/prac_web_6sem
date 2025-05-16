package com.example.web.dao;

import com.example.web.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class StudentDAO {

    private final StudentRepository studentRepository;
    private final StudentCourseRepository studentCourseRepository;

    @Autowired
    public StudentDAO(StudentRepository studentRepository, StudentCourseRepository studentCourseRepository) {
        this.studentRepository = studentRepository;
        this.studentCourseRepository = studentCourseRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    public Student updateStudent(Long id, Student studentDetails) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));
        student.setFull_name(studentDetails.getFull_name());
        student.setYear(studentDetails.getYear());
        student.setGroup_id(studentDetails.getGroup_id());
        return studentRepository.save(student);
    }

    @Transactional
    public void deleteStudent(Long id) {
        studentCourseRepository.deleteRelation(id);
        studentRepository.deleteById(id);
    }

    public List<Student> getStudentsByGroupId(Long groupId) {
        return studentRepository.findByGroupId(groupId);
    }
}
