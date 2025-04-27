package com.example.web.dao;

import com.example.web.Lesson;
import com.example.web.Course;
import com.example.web.Teacher;
import com.example.web.Auditorium;

import java.util.List;

public interface LessonDao extends CommonDAO<Lesson, Long>{
    List<Lesson> findByCourse(Course course);
    List<Lesson> findByTeacher(Teacher teacher);
    List<Lesson> findByAuditorium(Auditorium auditorium);
    List<Lesson> findByGroupId(Long groupId);
    List<Lesson> findByTimeAndGroupId(Long time, Long groupId);
}