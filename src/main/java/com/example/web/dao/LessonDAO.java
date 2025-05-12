package com.example.web.dao;

import com.example.web.entities.Auditorium;
import com.example.web.entities.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LessonDAO {

    private final LessonRepository lessonRepository;

    @Autowired
    public LessonDAO(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Transactional(readOnly = true)
    public List<Lesson> getScheduleByTimeInterval(LocalDateTime startTime, LocalDateTime endTime) {
        return lessonRepository.findScheduleByTimeInterval(startTime, endTime);
    }

    public List<Lesson> getAllLessons() {
        return lessonRepository.findAllLessons();
    }

    @Transactional(readOnly = true)
    public List<Auditorium> getFreeAuditoriums(LocalDateTime startTime, LocalDateTime endTime) {
        return lessonRepository.findFreeAuditoriums(startTime, endTime);
    }
}
