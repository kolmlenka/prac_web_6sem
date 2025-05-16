package com.example.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.web.dao.StudentDAO;
import com.example.web.entities.Student;

import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {

    @Autowired
    private StudentDAO studentDAO;

    @GetMapping("/students/list")
    public String studentListPage(@RequestParam(name = "groupId", required = false) Long groupId, Model model) {
        List<Student> students = (groupId != null) ? studentDAO.getStudentsByGroupId(groupId) : studentDAO.getAllStudents();
        model.addAttribute("students", students);
        return "students/list";
    }

    @GetMapping("/students/add")
    public String addStudentPage(Model model) {
        model.addAttribute("student", new Student());
        return "students/add";
    }

    @PostMapping("/students/add")
    public String addStudent(@ModelAttribute Student student) {
        studentDAO.addStudent(student);
        return "/students/list";
    }

    @GetMapping("/students/edit")
    public String editStudentPage(@RequestParam(name = "studentId") Long studentId, Model model) {
        Optional<Student> student = studentDAO.getStudentById(studentId);
        if (!student.isPresent()) {
            model.addAttribute("error_msg", "Студент с ID = " + studentId + " не найден.");
            model.addAttribute("backUrl", "students/list");
            return "errorPage";
        }
        model.addAttribute("student", student.get());
        return "students/edit";
    }

    @PostMapping("/students/edit")
    public String editStudent(@ModelAttribute Student student) {
        studentDAO.updateStudent(student.getId(), student);
        return "/students/list";
    }

    @GetMapping("/students/delete")
    public String deleteStudent(@RequestParam(name = "studentId") Long studentId, Model model) {
        Optional<Student> student = studentDAO.getStudentById(studentId);
        if (!student.isPresent()) {
            model.addAttribute("error_msg", "Студент с ID = " + studentId + " не найден.");
            model.addAttribute("backUrl", "students/list");
            return "errorPage";
        }
        studentDAO.deleteStudent(studentId);
        return "/students/list";
    }

    @GetMapping("/students/profile")
    public String studentProfilePage(@RequestParam(name = "studentId") Long studentId, Model model) {
        Optional<Student> student = studentDAO.getStudentById(studentId);
        if (!student.isPresent()) {
            model.addAttribute("error_msg", "Студент с ID = " + studentId + " не найден.");
            model.addAttribute("backUrl", "students/list");
            return "errorPage";
        }
        model.addAttribute("student", student.get());
        return "students/profile";
    }
}
