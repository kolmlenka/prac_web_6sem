package com.example.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.web.dao.LessonDAO;
import com.example.web.entities.Lesson;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class LessonController {

    @Autowired
    private LessonDAO lessonDAO;

    @GetMapping("/lessons")
    public String lessonsPage(Model model) {
        List<Lesson> lessons = lessonDAO.getAllLessons();
        model.addAttribute("lessons", lessons);
        return "lessons";
    }

    @GetMapping("/lessons/filter")
    public String filterLessons(
            @RequestParam(name = "startTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startTime,
            @RequestParam(name = "endTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endTime,
            @RequestParam(name = "teacherId", required = false) Long teacherId,
            @RequestParam(name = "auditoriumId", required = false) Long auditoriumId,
            Model model) {

        if (startTime.isAfter(endTime)) {
            model.addAttribute("error_msg", "Дата начала интервала не может быть позже даты окончания.");
            model.addAttribute("backUrl", "/lessons");
            return "errorPage";
        }

        List<Lesson> filteredLessons = lessonDAO.getScheduleByTimeInterval(startTime, endTime);

        if (teacherId != null) {
            filteredLessons = filteredLessons.stream()
                    .filter(lesson -> lesson.getTeacher() != null && lesson.getTeacher().getId().equals(teacherId))
                    .collect(Collectors.toList());

            if (filteredLessons.isEmpty()) {
                model.addAttribute("error_msg", "Расписание для преподавателя с ID = " + teacherId + " не найдено.");
                model.addAttribute("backUrl", "/lessons");
                return "errorPage";
            }
        }

        if (auditoriumId != null) {
            filteredLessons = filteredLessons.stream()
                    .filter(lesson -> lesson.getAuditorium() != null && lesson.getAuditorium().getId().equals(auditoriumId))
                    .collect(Collectors.toList());

            if (filteredLessons.isEmpty()) {
                model.addAttribute("error_msg", "Расписание для аудитории с ID = " + auditoriumId + " не найдено.");
                model.addAttribute("backUrl", "/lessons");
                return "errorPage";
            }
        }

        if (filteredLessons.isEmpty()) {
            model.addAttribute("error_msg", "Расписание на указанный интервал времени не найдено.");
            model.addAttribute("backUrl", "/lessons");
            return "errorPage";
        }

        model.addAttribute("lessons", filteredLessons);
        return "lessons";
    }
}