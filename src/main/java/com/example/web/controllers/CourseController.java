package com.example.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.web.dao.CourseDAO;

import com.example.web.entities.Course;

import java.util.List;
import java.util.Optional;

@Controller
public class CourseController {

    @Autowired
    private CourseDAO courseDAO;

    @GetMapping("/courses/list")
    public String coursesListPage(Model model) {
        List<Course> courses = courseDAO.getAllCourses();
        model.addAttribute("courses", courses);
        return "courses/list";
    }

    @GetMapping("/course")
    public String auditoriumPage(@RequestParam(name = "courseId") Long courseId, Model model) {
        Optional<Course> course = courseDAO.getCourseById(courseId);

        if (!course.isPresent()) {
            model.addAttribute("error_msg", "В базе нет курса с ID = " + courseId);
            model.addAttribute("backUrl", "courses/list");
            return "errorPage";
        }

        Course c = course.get();
        model.addAttribute("course", c);
        return "course";
    }
}
