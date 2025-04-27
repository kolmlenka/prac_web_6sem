package com.example.web.dao;

import com.example.web.Auditorium;
import com.example.web.Lesson;

import java.util.List;

public interface AuditoriumDao extends CommonDAO<Auditorium, Long> {
    List<Auditorium> auditoriumsByTime(Lesson time);
}
