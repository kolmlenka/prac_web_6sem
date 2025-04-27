package com.example.web.dao;

import com.example.web.Teacher;

public interface TeacherDao extends CommonDAO<Teacher, Long> {
    Teacher getTeacherNameById(Long teacherId);
    Teacher getTeacherIdByName(String teacherName );
}