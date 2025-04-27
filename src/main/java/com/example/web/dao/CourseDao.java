package com.example.web.dao;

import com.example.web.Course;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

public interface CourseDao extends CommonDAO<Course, Long>{

    List<Course> getAllCourseByName(String courseName);
    Course getCourseById(Long id);
    String getCourseNameById(Long id);
    List<Course> getByFilter(Filter filter);

    @Builder
    @Getter
    class Filter {
        private String courseName;
    }

    static Filter.FilterBuilder getFilterBuilder() {
        return Filter.builder();
    }
}