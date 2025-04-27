package com.example.web.dao;

import com.example.web.Student_course;
import com.example.web.Course;
import com.example.web.Student;

import java.util.List;

public interface Student_courseDao extends CommonDAO<Student_course, Long> {
    Student_course getStudentIDByCourseId(Long course_id);
    List<Student_course> getCoursesByStudentID(Long student_id);
    List<Student_course> getStudentIDsByCourseName(Course name);
    List<Student_course> getCoursesByStudentName(Student full_name);

}