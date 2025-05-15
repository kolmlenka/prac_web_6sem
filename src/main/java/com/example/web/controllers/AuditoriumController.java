package com.example.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.web.dao.AuditoriumDAO;

import com.example.web.entities.Auditorium;

import java.util.List;
import java.util.Optional;

@Controller
public class AuditoriumController {

    @Autowired
    private AuditoriumDAO auditoriumDAO;

    @GetMapping("/auditoriums/list")
    public String auditoriumListPage(Model model) {
        List<Auditorium> auditoriums = auditoriumDAO.getAllAuditoriums();
        model.addAttribute("auditoriums", auditoriums);
        return "auditoriums/list";
    }

    @GetMapping("/auditorium")
    public String auditoriumPage(@RequestParam(name = "auditoriumId") Long auditoriumId, Model model) {
        Optional<Auditorium> auditorium = auditoriumDAO.getAuditoriumById(auditoriumId);

        if (!auditorium.isPresent()) {
            model.addAttribute("error_msg", "В базе нет аудитории с ID = " + auditoriumId);
            model.addAttribute("backUrl", "auditoriums/list");
            return "errorPage";
        }

        Auditorium a = auditorium.get();
        model.addAttribute("auditorium", a);
        return "auditorium";
    }
}
