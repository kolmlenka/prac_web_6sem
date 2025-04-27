package com.example.web.dao;

import lombok.Builder;
import lombok.Getter;

import com.example.web.Student;

import java.util.List;

public interface StudentDao extends CommonDAO<Student, Long> {
    List<Student> getAllStudentByGroupId(Long groupId);
    List<Student> getAllStudentByYear(Integer year);

    @Builder
    @Getter
    class Filter {
        private String name;
    }

    static Filter.FilterBuilder getFilterBuilder() {
        return Filter.builder();
    }
}