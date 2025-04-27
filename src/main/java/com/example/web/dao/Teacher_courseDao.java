package com.example.web.dao;

import com.example.web.Teacher_course;
import com.example.web.Course;
import com.example.web.Teacher;

import java.util.List;

public interface Teacher_courseDao extends CommonDAO<Teacher_course, Long> {
    Teacher_course getStudentIDByCourseId(Long course_id);
    List<Teacher_course> getCoursesByStudentID(Long student_id);
    List<Teacher_course> getStudentIDsByCourseName(Course name);
    List<Teacher_course> getCoursesByStudentName(Teacher full_name);

}