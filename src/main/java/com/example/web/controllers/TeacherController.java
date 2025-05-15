package com.example.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.web.dao.TeacherDAO;
import com.example.web.dao.Teacher_courseDAO;

import com.example.web.entities.Teacher;
import com.example.web.entities.Teacher_course;

import java.util.List;
import java.util.Optional;

@Controller
public class TeacherController {

    @Autowired
    private TeacherDAO teacherDAO;

    @Autowired
    private Teacher_courseDAO teacherCourseDAO;

    @GetMapping("/teachers/list")
    public String teacherListPage(Model model) {
        List<Teacher> teachers = teacherDAO.getAllTeachers();
        model.addAttribute("teachers", teachers);
        return "teachers/list";
    }

    @GetMapping("/teachers")
    public String teacherPage(@RequestParam(name = "teacherId") Long teacherId, Model model) {
        Optional<Teacher> teacher = teacherDAO.getTeacherById(teacherId);

        if (!teacher.isPresent()) {
            model.addAttribute("error_msg", "В базе нет преподавателя с ID = " + teacherId);
            model.addAttribute("backUrl", "teachers/list");
            return "errorPage";
        }

        Teacher t = teacher.get();
        model.addAttribute("teacher", t);
        return "teacher";
    }

    @GetMapping("/teachers/filter")
    public String filterTeachersByCourse(@RequestParam(name = "teacherId") Long teacherId, Model model) {
        List<Teacher_course> courses = teacherCourseDAO.getCoursesByTeacherId(teacherId);
        model.addAttribute("teachers", courses);
        model.addAttribute("selectedTeacherId", teacherId);
        return "teachers";
    }
}
