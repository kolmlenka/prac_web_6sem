package com.example.web.dao;

import com.example.web.Student;
import java.util.List;

public interface StudentDao extends CommonDAO<Student, Long> {
    List<Student> getAllStudentByGroupId(Long groupId);
    List<Student> getAllStudentByYear(Integer year);
}